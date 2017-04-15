lazy val root = project.in(file(".")).aggregate(js, jvm).
  settings(
    publishArtifact := false,
    crossScalaVersions := Seq("2.10.6", "2.11.8", "2.12.1"),
    sonatypeProfileName := "com.github.benhutchison"
  )

lazy val cross = crossProject.in(file(".")).
  settings(
    name := "mouse",
    organization := "com.github.benhutchison",
    scalaVersion := "2.12.1",
    libraryDependencies ++= Seq(
      "org.typelevel" %%% "cats" % "0.9.0",
      "org.scalatest" %%% "scalatest" % "3.0.0" %  "test"
    ),
    publishMavenStyle := true,
    licenses += ("MIT license", url("http://opensource.org/licenses/MIT")),
    homepage := Some(url("https://github.com/benhutchison/mouse")),
    developers := List(Developer("benhutchison", "Ben Hutchison", "brhutchison@gmail.com", url = url("https://github.com/benhutchison")))
  )

lazy val jvm = cross.jvm
lazy val js = cross.js
