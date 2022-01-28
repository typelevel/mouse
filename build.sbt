val Scala212 = "2.12.15"
val Scala213 = "2.13.8"
val Scala3 = "3.0.2"

ThisBuild / organization := "org.typelevel"
ThisBuild / organizationName := "Typelevel"
ThisBuild / tlBaseVersion := "1.0"
ThisBuild / scalaVersion := Scala213
ThisBuild / crossScalaVersions := Seq(Scala212, Scala3, Scala213)
ThisBuild / tlVersionIntroduced := Map("3" -> "1.0.3")
ThisBuild / tlCiReleaseBranches := Seq()
ThisBuild / tlSiteApiUrl := Some(url("https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest"))

lazy val root = project
  .in(file("."))
  .aggregate(js, jvm)
  .enablePlugins(NoPublishPlugin)

lazy val cross = crossProject(JSPlatform, JVMPlatform)
  .in(file("."))
  .settings(
    name := "mouse",
    libraryDependencies ++= Seq(
      "org.typelevel" %%% "cats-core" % "2.7.0",
      "org.scalameta" %%% "munit" % "0.7.29" % Test,
      "org.scalameta" %%% "munit-scalacheck" % "0.7.29" % Test
    ),
    licenses := List("MIT license" -> url("http://opensource.org/licenses/MIT")),
    developers := List(
      Developer("benhutchison", "Ben Hutchison", "brhutchison@gmail.com", url = url("https://github.com/benhutchison"))
    ),
    scalacOptions ++= Seq("-feature", "-deprecation", "-language:implicitConversions", "-language:higherKinds"),
    scalacOptions ++= {
      scalaVersion.value match {
        case v if v.startsWith("2.12") => Seq("-Ypartial-unification")
        case v if v.startsWith("3")    => Seq("-source", "3.0-migration")
        case _                         => Nil
      }
    },
    mimaPreviousArtifacts ~= { _.filterNot(_.revision == "1.0.1") }
  )
  .jsSettings(
    crossScalaVersions := (ThisBuild / crossScalaVersions).value.filter(_.startsWith("2"))
  )

lazy val docs = project
  .in(file("site"))
  .dependsOn(cross.jvm)
  .enablePlugins(TypelevelSitePlugin)

val JDK8 = JavaSpec.temurin("8")
val JDK17 = JavaSpec.temurin("17")

ThisBuild / githubWorkflowJavaVersions := Seq(JDK8, JDK17)

ThisBuild / githubWorkflowBuild ~= { steps =>
  val formatStep = WorkflowStep
    .Sbt(
      List("scalafmtCheckAll", "project /", "scalafmtSbtCheck"),
      name = Some("Check formatting")
    )
  formatStep +: steps
}

lazy val jvm = cross.jvm
lazy val js = cross.js

// Scalafmt
addCommandAlias("fmt", "; Compile / scalafmt; Test / scalafmt; scalafmtSbt")
addCommandAlias("fmtCheck", "; Compile / scalafmtCheck; Test / scalafmtCheck; scalafmtSbtCheck")

addCommandAlias("checkBinaryCompatibility", "; crossJVM/mimaReportBinaryIssues; crossJS/mimaReportBinaryIssues")
