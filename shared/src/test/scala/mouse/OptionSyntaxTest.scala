package mouse

import scala.util.{Failure, Success}

class OptionSyntaxTest extends MouseSuite {

  Option(1).cata(_.toString, "") shouldEqual "1"

  Option.empty[Int].cata(_.toString, "") shouldEqual ""


  Option(1).toTry(new RuntimeException("Err")) shouldEqual Success(1)

  val ex = new RuntimeException("Err")
  Option.empty[Int].toTry(ex) shouldEqual Failure(ex)


}
