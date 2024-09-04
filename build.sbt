val Scala212 = "2.12.20"
val Scala213 = "2.13.14"
val Scala3 = "3.3.3"

ThisBuild / organization := "org.typelevel"
ThisBuild / organizationName := "Typelevel"
ThisBuild / licenses := List(License.MIT)
ThisBuild / startYear := Some(2016)
ThisBuild / tlBaseVersion := "1.3"
ThisBuild / scalaVersion := Scala213
ThisBuild / crossScalaVersions := Seq(Scala212, Scala3, Scala213)
ThisBuild / tlVersionIntroduced := Map("3" -> "1.0.3")
ThisBuild / tlCiReleaseBranches := Seq("main")
ThisBuild / tlSiteApiUrl := Some(url("https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest"))
ThisBuild / githubWorkflowOSes := Seq("ubuntu-22.04")

lazy val mouse = tlCrossRootProject.aggregate(cross)

lazy val cross = crossProject(JSPlatform, JVMPlatform, NativePlatform)
  .in(file("."))
  .settings(
    name := "mouse",
    libraryDependencies ++= Seq(
      "org.typelevel" %%% "cats-core" % "2.12.0",
      "org.scalameta" %%% "munit" % "1.0.1" % Test,
      "org.scalameta" %%% "munit-scalacheck" % "1.0.0" % Test
    ),
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
    Compile / sourceGenerators += (Compile / sourceManaged).map(Boilerplate.gen).taskValue
  )
  .jsSettings(
    tlVersionIntroduced := Map("3" -> "1.0.13")
  )
  .nativeSettings(
    tlVersionIntroduced := List("2.12", "2.13", "3").map(_ -> "1.3.0").toMap
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
lazy val native = cross.native

// Scalafmt
addCommandAlias("fmt", "; Compile / scalafmt; Test / scalafmt; scalafmtSbt")
addCommandAlias("fmtCheck", "; Compile / scalafmtCheck; Test / scalafmtCheck; scalafmtSbtCheck")

addCommandAlias("checkBinaryCompatibility", "; crossJVM/mimaReportBinaryIssues; crossJS/mimaReportBinaryIssues")
