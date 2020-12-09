import sbt._

inThisBuild(Seq(
  name := "mouse",
  scalaVersion := "3.0.0-M2",
  crossScalaVersions := Seq("3.0.0-M2"),
  organization := "org.typelevel",
  sonatypeProfileName := "org.typelevel",
  testFrameworks += new TestFramework("munit.Framework"),
  Test / publishArtifact := false,
))

lazy val root = crossProject(JSPlatform, JVMPlatform).withoutSuffixFor(JVMPlatform).in(file(".")).
  settings(
    libraryDependencies ++= Seq(
      "org.typelevel" %%% "cats-core" % "2.3.0",
      "org.scalameta" %% "munit" % "0.7.19" % Test,
    ),
    scalacOptions ++= Seq("-feature", "-deprecation", "-language:higherKinds"),
    
    licenses += ("MIT license", url("http://opensource.org/licenses/MIT")),
    homepage := Some(url("https://github.com/typelevel/mouse")),
    developers := List(Developer("benhutchison", "Ben Hutchison", "brhutchison@gmail.com", url = url("https://github.com/benhutchison"))),
    scmInfo := Some(ScmInfo(url("https://github.com/typelevel/mouse"), "scm:git:https://github.com/typelevel/mouse.git")),
  )

inThisBuild(Seq(
  githubWorkflowTargetTags ++= Seq("v*"),
  githubWorkflowPublishTargetBranches := Seq(RefPredicate.StartsWith(Ref.Tag("v"))),

  githubWorkflowPublishPreamble += WorkflowStep.Use(UseRef.Public("olafurpg", "setup-gpg", "v3")),

  githubWorkflowPublish := Seq(
    WorkflowStep.Sbt(
      List("ci-release"),
      env = Map(
        "PGP_PASSPHRASE" -> "${{ secrets.PGP_PASSPHRASE }}",
        "PGP_SECRET" -> "${{ secrets.PGP_SECRET }}",
        "SONATYPE_PASSWORD" -> "${{ secrets.SONATYPE_PASSWORD }}",
        "SONATYPE_USERNAME" -> "${{ secrets.SONATYPE_USERNAME }}"
      )
  ))
))