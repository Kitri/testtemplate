val specs2Version = "4.8.1"
val specs2Deps = Seq(
  "org.specs2" %% "specs2-core"       % specs2Version % "test",
  "org.specs2" %% "specs2-scalacheck" % specs2Version % "test",
  "org.specs2" %% "specs2-mock"       % specs2Version % "test"
)

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-Xlint",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-unused",
  "-Ywarn-value-discard",
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked"
)

organization := "test"

// Note: version is controlled by the git tag closest to the current
// version.  We need to make sure that we publish at that commit hash
// too by first checking out the tag.

scalaVersion := "2.13.1"

lazy val `libtemplate`: Project = (project in file("."))
  .settings(
    scalaVersion := "2.13.1",
    name         := "libtemplate",
    libraryDependencies ++= specs2Deps,
    publishTo := Some("Artifactory Realm" at "https://repo.jemstep.com/artifactory/sbt-release"),
    wartremoverErrors  in (Compile, compile) ++= Warts.all,
    wartremoverErrors in (Compile, test) := Warts.all,
    organization := "test",
    crossScalaVersions := Seq("2.11.12", "2.13.1")
  )

enablePlugins(GitVersioning)
