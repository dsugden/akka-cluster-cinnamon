package example.second

import akka.actor.ActorSystem

object BootSecond {

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("CinnamonCluster")
    val secondActor = system.actorOf(SecondActor.props)

  }

}
