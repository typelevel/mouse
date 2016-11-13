lazy val root = project.in(file(".")).aggregate(mouseJS, mouseJVM).
  settings(
    publishArtifact := false,
    crossScalaVersions := Seq("2.10.6", "2.11.8", "2.12.0"),
    sonatypeProfileName := "com.github.benhutchison"
  )

lazy val mouseCross = crossProject.in(file(".")).
  settings(
    name := "mouse",
    organization := "com.github.benhutchison",
    version := "0.6",
    scalaVersion := "2.12.0",
    libraryDependencies ++= Seq(
      "org.typelevel" %%% "cats" % "0.8.1",
      "org.scalatest" %%% "scalatest" % "3.0.0" %  "test"
    ),
    publishTo <<= version { (v: String) =>
      Some("releases"  at "https://oss.sonatype.org/service/local/staging/deploy/maven2")
    },
    publishMavenStyle := true,
    pomExtra :=
      <url>https://github.com/benhutchison/mouse</url>
      <licenses>
        <license>
          <name>MIT license</name>
          <url>http://opensource.org/licenses/MIT</url>
        </license>
      </licenses>
      <scm>
        <url>git://github.com/benhutchison/mouse.git</url>
      </scm>
      <developers>
        <developer>
          <id>benhutchison</id>
          <name>Ben Hutchison</name>
          <url>https://github.com/benhutchison</url>
        </developer>
      </developers>
  )

lazy val mouseJVM = mouseCross.jvm
lazy val mouseJS = mouseCross.js