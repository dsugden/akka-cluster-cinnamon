package example.first

import akka.actor.ActorSystem

object BootFirst {

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("CinnamonCluster")
    val firstActor = system.actorOf(FirstActor.props, "first-actor")


  }

}
