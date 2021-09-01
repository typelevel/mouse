import sbt._
import sbtcrossproject.CrossPlugin.autoImport.crossProject

ThisBuild / githubWorkflowPublishTargetBranches := Seq()

ThisBuild / crossScalaVersions := Seq("2.12.14", "2.13.6", "3.0.1")

ThisBuild / scalaVersion := "2.13.6"

lazy val root = project
  .in(file("."))
  .aggregate(js, jvm)
  .settings(
    name := "mouse",
    publish / skip := true,
    sonatypeProfileName := "org.typelevel"
  )

lazy val cross = crossProject(JSPlatform, JVMPlatform)
  .in(file("."))
  .settings(
    name := "mouse",
    organization := "org.typelevel",
    sonatypeProfileName := "org.typelevel",
    libraryDependencies ++= Seq(
      "org.typelevel" %%% "cats-core" % "2.6.1",
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
  .jsSettings(
    crossScalaVersions := (ThisBuild / crossScalaVersions).value.filter(_.startsWith("2")),
    publishConfiguration := publishConfiguration.value.withOverwrite(true)
  )

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

lazy val jvm = cross.jvm
lazy val js = cross.js

// Scalafmt
addCommandAlias("fmt", "; Compile / scalafmt; Test / scalafmt; scalafmtSbt")
addCommandAlias("fmtCheck", "; Compile / scalafmtCheck; Test / scalafmtCheck; scalafmtSbtCheck")
