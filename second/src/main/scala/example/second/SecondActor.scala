package example.second

import akka.actor.{Actor, ActorLogging, Props, RootActorPath}
import akka.cluster.{Cluster, Member}
import akka.cluster.ClusterEvent.{InitialStateAsEvents, MemberUp}
import example.common.Protocol.{Ping, Pong, SecondActorRegistration}

object SecondActor{
  def props:Props = Props(new SecondActor)
}

class SecondActor extends Actor with ActorLogging{



  val cluster = Cluster(context.system)

  override def preStart(): Unit = cluster.subscribe(self, initialStateMode = InitialStateAsEvents,
    classOf[MemberUp])
  override def postStop(): Unit = cluster.unsubscribe(self)



  override def receive: Receive = {

    case MemberUp(m) => register(m)

    case Ping(v) =>
      log.info("received Ping")
      sender() ! Pong(v)
      log.info("sent Pong")

  }

  def register(member: Member): Unit =
    if (member.hasRole("first")){
      log.info("Registering")
      context.actorSelection(RootActorPath(member.address) / "user" / "first-actor") !  SecondActorRegistration
    }



}
