import com.lightbend.cinnamon.sbt.Cinnamon.CinnamonKeys._

name := "akka-cluster-cinnamon"

version := "1.0"


scalaVersion := "2.12.1"


val akkaVer = "2.4.17"
val akkaDataRepVer = "0.11"
val logbackVer = "1.1.3"
val scalaParsersVer= "1.0.4"
val scalaTestVer = "2.2.4"

lazy val commonDependencies = Seq(
  "com.typesafe.akka"        %% "akka-actor"                    % akkaVer,
  "com.typesafe.akka"        %% "akka-cluster"                  % akkaVer,
  "com.typesafe.akka"        %% "akka-contrib"                  % akkaVer,
  "com.typesafe.akka"        %% "akka-slf4j"                    % akkaVer,
  "ch.qos.logback"           %  "logback-classic"               % logbackVer,
  "com.typesafe.akka"        %% "akka-testkit"                  % akkaVer            % "test"
)



lazy val first = (project in file("first"))
  .settings(
    scalaVersion := "2.12.1",
    libraryDependencies ++= commonDependencies,
    libraryDependencies += Cinnamon.library.cinnamonSlf4jMdc,
    cinnamon in run := true,
    cinnamon in test := true
).dependsOn( common ).enablePlugins (Cinnamon)


lazy val second = (project in file("second"))
  .settings(
    scalaVersion := "2.12.1",
    libraryDependencies ++= commonDependencies,
    libraryDependencies += Cinnamon.library.cinnamonSlf4jMdc,
    cinnamon in run := true,
    cinnamon in test := true
  )
  .dependsOn( common ).enablePlugins(Cinnamon)

lazy val common = (project in file("common")).settings(
  scalaVersion := "2.12.1"
)



    