# akka-cluster-cinnamon

Examples of using lightbend's cinnamon monitoring agent with an akka cluster

  * Multi project build
  * SLF4J MDC extension
  
  
Things worth noting:
 
  * Enable Cinnamon plugin on each subproject 
  * Cinnamon related settings need to be specified per subproject
   

eg:

    lazy val first = (project in file("first"))
      .settings(
        libraryDependencies += Cinnamon.library.cinnamonSlf4jMdc,
        cinnamon in run := true,
        cinnamon in test := true
    ).dependsOn( common ).enablePlugins (Cinnamon)



Usage:


    sbt 'project first' 'run'
    
    sbt 'project second' 'run'
    
    
Two cluster nodes will come up and talk to each other. The first node will MDC.put().
The second node will log this context.
