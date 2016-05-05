lazy val root = project.in(file(".")).aggregate(mouseJS, mouseJVM)

lazy val mouseCross = crossProject.in(file(".")).
  settings(
    name := "mouse",
    organization := "com.github.benhutchison",
    version := "0.1",
    scalaVersion := "2.11.8",
    crossScalaVersions := Seq("2.10.6", "2.11.8"),
    libraryDependencies ++= Seq(
      "org.typelevel" %%% "cats" % "0.5.0",
      "org.scalatest" %%% "scalatest" % "3.0.0-M15" %  "test"
    )
  )

lazy val mouseJVM = mouseCross.jvm
lazy val mouseJS = mouseCross.js