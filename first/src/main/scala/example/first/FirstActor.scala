package example.first

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import example.common.Protocol.{Ping, Pong, SecondActorRegistration}
import org.slf4j.MDC


object FirstActor{
  def props:Props = Props(new FirstActor)
}

class FirstActor extends Actor with ActorLogging{

  override def receive: Receive = initial




  def initial: Receive = {

    case SecondActorRegistration =>
      MDC.putCloseable("ping", java.util.UUID.randomUUID()+"")
      log.info("Starting PingPong")
      val second = sender()
      second ! Ping("ping")
      log.info("Sent Ping")
      context.become(withSecondNode(second))
  }

  def withSecondNode(ref: ActorRef):Receive = {
    case Pong(v) => log.info(s"Pong $v")
  }


}
