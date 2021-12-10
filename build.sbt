import sbt._
import sbtcrossproject.CrossPlugin.autoImport.crossProject

ThisBuild / githubWorkflowPublishTargetBranches := Seq()

val Scala212 = "2.12.15"
val Scala213 = "2.13.7"
val Scala3 = "3.0.2"

ThisBuild / crossScalaVersions := Seq(Scala212, Scala213, Scala3)

ThisBuild / scalaVersion := Scala213

lazy val previousMouseVersion = "1.0.7"

def scalaVersionSpecificJVMFolder(srcName: String, srcBaseDir: java.io.File, scalaVersion: String) = {
  def extraDir(suffix: String) = {
    List(srcBaseDir / "jvm" / "src" / srcName / s"scala$suffix")
  }

  CrossVersion.partialVersion(scalaVersion) match {
    case Some((2, _))     => extraDir("-2.x")
    case Some((0 | 3, _)) => extraDir("-3.x")
    case _                => Nil
  }
}

def scalaVersionSpecificFolders(srcName: String, srcBaseDir: java.io.File, scalaVersion: String) = {
  def extraDirs(suffix: String) =
    List(CrossType.Pure, CrossType.Full)
      .flatMap(_.sharedSrcDir(srcBaseDir, srcName).toList.map(f => file(f.getPath + suffix)))

  CrossVersion.partialVersion(scalaVersion) match {
    case Some((2, _))     => extraDirs("-2.x")
    case Some((0 | 3, _)) => extraDirs("-3.x")
    case _                => Nil
  }
}

// general settings
lazy val commonSettings = Seq(
  name := "mouse",
  organization := "org.typelevel",
  sonatypeProfileName := "org.typelevel",
  Compile / unmanagedSourceDirectories ++= scalaVersionSpecificFolders(
    "main",
    baseDirectory.value,
    scalaVersion.value
  ),
  Test / unmanagedSourceDirectories ++= scalaVersionSpecificFolders(
    "test",
    baseDirectory.value,
    scalaVersion.value
  ),
  mimaFailOnNoPrevious := false,
  mimaPreviousArtifacts := Set(organization.value %% moduleName.value % previousMouseVersion)
)

lazy val root = project
  .in(file("."))
  .aggregate(js, jvm)
  .settings(
    commonSettings,
    publish / skip := true
  )

lazy val cross = crossProject(JSPlatform, JVMPlatform)
  .in(file("."))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
      "org.typelevel" %%% "cats-core" % "2.7.0",
      "org.scalameta" %%% "munit" % "0.7.29" % Test,
      "org.scalameta" %%% "munit-scalacheck" % "0.7.29" % Test
    ),
    licenses += ("MIT license", url("http://opensource.org/licenses/MIT")),
    homepage := Some(url("https://github.com/typelevel/mouse")),
    developers := List(
      Developer("benhutchison", "Ben Hutchison", "brhutchison@gmail.com", url = url("https://github.com/benhutchison"))
    ),
    scmInfo := Some(
      ScmInfo(url("https://github.com/typelevel/mouse"), "scm:git:https://github.com/typelevel/mouse.git")
    ),
    scalacOptions ++= Seq("-feature", "-deprecation", "-language:implicitConversions", "-language:higherKinds"),
    scalacOptions ++= {
      scalaVersion.value match {
        case v if v.startsWith("2.12") => Seq("-Ypartial-unification")
        case v if v.startsWith("3")    => Seq("-source", "3.0-migration")
        case _                         => Nil
      }
    },
    Test / publishArtifact := false,
    pomIncludeRepository := { _ => false }
  )
  .jvmSettings(
    Compile / unmanagedSourceDirectories ++= scalaVersionSpecificJVMFolder(
      "main",
      (Compile / baseDirectory).value.getParentFile(),
      scalaVersion.value
    ),
    Test / unmanagedSourceDirectories ++= scalaVersionSpecificJVMFolder(
      "test",
      (Test / baseDirectory).value.getParentFile(),
      scalaVersion.value
    )
  )
  .jsSettings(
    crossScalaVersions := (ThisBuild / crossScalaVersions).value.filter(_.startsWith("2")),
    publishConfiguration := publishConfiguration.value.withOverwrite(true),
    mimaBinaryIssueFilters ++= {
      import com.typesafe.tools.mima.core.ProblemFilters._
      import com.typesafe.tools.mima.core._

      Seq(
        exclude[MissingClassProblem]("mouse.AllJvmSyntax"),
        exclude[MissingClassProblem]("mouse.JvmStringOps"),
        exclude[MissingClassProblem]("mouse.JvmStringOps$"),
        exclude[MissingClassProblem]("mouse.StringJvmSyntax"),
        exclude[MissingTypesProblem]("mouse.package$all$"),
        exclude[MissingTypesProblem]("mouse.package$string$"),
        exclude[DirectMissingMethodProblem]("mouse.package#all.stringJvmSyntaxMouse"),
        exclude[DirectMissingMethodProblem]("mouse.package#string.stringJvmSyntaxMouse"),
        exclude[DirectMissingMethodProblem]("mouse.package#string.stringJvmSyntaxMouse")
      )
    }
  )

val JDK8 = JavaSpec.temurin("8")
val JDK17 = JavaSpec.temurin("17")

ThisBuild / githubWorkflowJavaVersions := Seq(JDK8, JDK17)

ThisBuild / githubWorkflowTargetTags ++= Seq("v*")
ThisBuild / githubWorkflowPublishTargetBranches :=
  Seq(RefPredicate.StartsWith(Ref.Tag("v")))

ThisBuild / githubWorkflowPublishPreamble +=
  WorkflowStep.Use(UseRef.Public("olafurpg", "setup-gpg", "v3"))

ThisBuild / githubWorkflowPublish := Seq(
  WorkflowStep.Sbt(
    List("ci-release"),
    env = Map(
      "PGP_PASSPHRASE" -> "${{ secrets.PGP_PASSPHRASE }}",
      "PGP_SECRET" -> "${{ secrets.PGP_SECRET }}",
      "SONATYPE_PASSWORD" -> "${{ secrets.SONATYPE_PASSWORD }}",
      "SONATYPE_USERNAME" -> "${{ secrets.SONATYPE_USERNAME }}"
    )
  )
)

val NotScala3Cond = s"matrix.scala != '$Scala3'"

ThisBuild / githubWorkflowBuild := Seq(
  WorkflowStep
    .Sbt(
      List("scalafmtCheckAll", "scalafmtSbtCheck"),
      name = Some("Check formatting")
    ),
  WorkflowStep.Sbt(List("Test/compile"), name = Some("Compile")),
  WorkflowStep.Sbt(List("crossJVM/test"), name = Some("Run tests on JVM")),
  WorkflowStep.Sbt(List("crossJS/test"), name = Some("Run tests on JS"), cond = Some(NotScala3Cond))
)

lazy val jvm = cross.jvm
lazy val js = cross.js

// Scalafmt
addCommandAlias("fmt", "; Compile / scalafmt; Test / scalafmt; scalafmtSbt")
addCommandAlias("fmtCheck", "; Compile / scalafmtCheck; Test / scalafmtCheck; scalafmtSbtCheck")
