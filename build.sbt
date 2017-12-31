lazy val root = project.in(file(".")).aggregate(js, jvm).
  settings(
    skip in publish := true,
    sonatypeProfileName := "org.typelevel"
  )

lazy val cross = crossProject.in(file(".")).
  settings(
    name := "mouse",
    organization := "org.typelevel",
    scalaVersion := "2.12.4",
    crossScalaVersions := Seq("2.10.7", "2.11.12", "2.12.4"),
    sonatypeProfileName := "org.typelevel",
    libraryDependencies ++= Seq(
      "org.typelevel" %%% "cats-core" % "1.0.1",
      "org.scalatest" %%% "scalatest" % "3.0.1" %  "test",
      "org.scalacheck" %%% "scalacheck" % "1.13.5" %  "test"
    ),
    publishMavenStyle := true,
    licenses += ("MIT license", url("http://opensource.org/licenses/MIT")),
    homepage := Some(url("https://github.com/typelevel/mouse")),
    developers := List(Developer("benhutchison", "Ben Hutchison", "brhutchison@gmail.com", url = url("https://github.com/benhutchison"))),
    scmInfo := Some(ScmInfo(url("https://github.com/typelevel/mouse"), "scm:git:https://github.com/typelevel/mouse.git")),
    scalacOptions ++= Seq("-feature", "-deprecation", "-language:implicitConversions"),
    publishTo := Some(
      if (isSnapshot.value)
        Opts.resolver.sonatypeSnapshots
      else
        Opts.resolver.sonatypeStaging
      )
  )

lazy val jvm = cross.jvm
lazy val js = cross.js
