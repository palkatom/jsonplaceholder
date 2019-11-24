ThisBuild / scalaVersion := "2.12.10"

lazy val posts_downloader = (project in file("."))
    .settings(
        name := "PostsDownloader",
        libraryDependencies ++= List(
            "com.softwaremill.sttp.client" %% "core" % "2.0.0-RC2",
            "com.softwaremill.sttp.client" %% "json4s" % "2.0.0-RC2",
            "org.json4s" %% "json4s-native" % "3.6.0"
        )
    )
