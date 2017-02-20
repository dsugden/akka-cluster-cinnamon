package example.common

/**
  * Created by dave on 2017-02-20.
  */
object Protocol {

  case class Ping(value:String)

  case class Pong(value:String)

  case object SecondActorRegistration

}
