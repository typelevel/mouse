import ReleaseTransformations._
import sbt._
import sbtcrossproject.CrossPlugin.autoImport.crossProject

lazy val commonSettings = Def.settings(
  scalaVersion := "2.13.1",
  crossScalaVersions := Seq("2.12.10", "2.13.1")
)

lazy val root = project.in(file(".")).aggregate(js, jvm).
  settings(
    name := "mouse",
    commonSettings,
    publish / skip := true,
    sonatypeProfileName := "org.typelevel",
    releaseCrossBuild := true
  )

lazy val cross = crossProject(JSPlatform, JVMPlatform).in(file(".")).
  settings(
    name := "mouse",
    organization := "org.typelevel",
    commonSettings,
    sonatypeProfileName := "org.typelevel",
    libraryDependencies ++= Seq(
      "org.typelevel" %%% "cats-core" % "2.1.1",
      "org.scalatest" %%% "scalatest" % "3.1.1" % Test,
      "org.scalatestplus" %%% "scalacheck-1-14" % "3.1.1.1" % Test,
      "org.scalacheck" %%% "scalacheck" % "1.14.3" % Test,
      compilerPlugin("org.typelevel" %% "kind-projector" % "0.11.0" cross CrossVersion.full)
    ),
    publishMavenStyle := true,
    licenses += ("MIT license", url("http://opensource.org/licenses/MIT")),
    homepage := Some(url("https://github.com/typelevel/mouse")),
    developers := List(Developer("benhutchison", "Ben Hutchison", "brhutchison@gmail.com", url = url("https://github.com/benhutchison"))),
    scmInfo := Some(ScmInfo(url("https://github.com/typelevel/mouse"), "scm:git:https://github.com/typelevel/mouse.git")),
    scalacOptions ++= Seq("-feature", "-deprecation", "-language:implicitConversions", "-language:higherKinds"),
    scalacOptions ++= {
      scalaVersion.value match {
        case v if v.startsWith("2.13") => Nil
        case _ => Seq("-Ypartial-unification")
      }
    },
    publishMavenStyle := true,
    Test / publishArtifact := false,
    pomIncludeRepository := { _ => false },
    releasePublishArtifactsAction := PgpKeys.publishSigned.value,
    releaseProcess := Seq[ReleaseStep](
      checkSnapshotDependencies,
      inquireVersions,
      runClean,
      runTest,
      setReleaseVersion,
      commitReleaseVersion,
      tagRelease,
      publishArtifacts,
      setNextVersion,
      commitNextVersion,
    )
  )

ThisBuild / publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)

lazy val jvm = cross.jvm
lazy val js = cross.js

credentials ++= (for {
  username <- Option(System.getenv().get("SONATYPE_USERNAME"))
  password <- Option(System.getenv().get("SONATYPE_PASSWORD"))
} yield Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", username, password)).toSeq
