package mouse

import mouse.option._
import scala.util.{Failure, Success}

class OptionSyntaxTest extends MouseSuite:

  testEquals(Option(1).cata(_.toString, ""), "1")

  testEquals(Option.empty[Int].cata(_.toString, ""), "")


  testEquals(Option(1).toTry(new RuntimeException("Err")), Success(1))

  val ex = new RuntimeException("Err")
  testEquals(Option.empty[Int].toTry(ex), Failure(ex))

  testEquals(Option(3).right("S"), Option(3).toRight("S"))

  testEquals(Option(3).left("S"), Option(3).toLeft("S"))
