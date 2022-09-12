val Scala212 = "2.12.16"
val Scala213 = "2.13.8"
val Scala3 = "3.1.3"

ThisBuild / organization := "org.typelevel"
ThisBuild / organizationName := "Typelevel"
ThisBuild / tlBaseVersion := "2.0"
ThisBuild / scalaVersion := Scala213
ThisBuild / crossScalaVersions := Seq(Scala212, Scala3, Scala213)
ThisBuild / tlVersionIntroduced := Map("3" -> "1.0.3")
ThisBuild / tlCiReleaseBranches := Seq("series/2.x")
ThisBuild / tlSiteApiUrl := Some(url("https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest"))

lazy val root = project
  .in(file("."))
  .settings(
    name := "mouse",
    licenses := List(License.MIT)
  )
  .aggregate(js, jvm)
  .enablePlugins(NoPublishPlugin)

lazy val cross = crossProject(JSPlatform, JVMPlatform)
  .in(file("."))
  .settings(
    name := "mouse",
    libraryDependencies ++= Seq(
      "org.typelevel" %%% "cats-core" % "2.8.0",
      "org.scalameta" %%% "munit" % "0.7.29" % Test,
      "org.scalameta" %%% "munit-scalacheck" % "0.7.29" % Test
    ),
    ThisBuild / licenses := List("MIT license" -> url("http://opensource.org/licenses/MIT")),
    developers := List(
      Developer("benhutchison", "Ben Hutchison", "brhutchison@gmail.com", url = url("https://github.com/benhutchison"))
    ),
    scalacOptions ++=
      (if (tlIsScala3.value) Nil
       else Seq("-language:implicitConversions", "-language:higherKinds")),
    scalacOptions ++= {
      scalaVersion.value match {
        case v if v.startsWith("2.12") => Seq("-Ypartial-unification")
        case _                         => Nil
      }
    },
    mimaPreviousArtifacts ~= { _.filterNot(_.revision == "1.0.1") },
    Compile / sourceGenerators += (Compile / sourceManaged).map(Boilerplate.gen).taskValue,
    licenses := List(License.MIT),
    startYear := Some(2016)
  )
  .jsSettings(
    tlVersionIntroduced := Map("3" -> "1.0.13")
  )

lazy val docs = project
  .in(file("site"))
  .dependsOn(cross.jvm)
  .enablePlugins(TypelevelSitePlugin)

val JDK8 = JavaSpec.temurin("8")
val JDK17 = JavaSpec.temurin("17")

ThisBuild / githubWorkflowJavaVersions := Seq(JDK8, JDK17)

lazy val jvm = cross.jvm
lazy val js = cross.js

// Scalafmt
addCommandAlias("fmt", "; Compile / scalafmt; Test / scalafmt; scalafmtSbt")
addCommandAlias("fmtCheck", "; Compile / scalafmtCheck; Test / scalafmtCheck; scalafmtSbtCheck")

addCommandAlias("checkBinaryCompatibility", "; crossJVM/mimaReportBinaryIssues; crossJS/mimaReportBinaryIssues")
