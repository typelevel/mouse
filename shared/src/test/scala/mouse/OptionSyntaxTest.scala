package mouse

import scala.util.{Failure, Success}
import cats.implicits._

class OptionSyntaxTest extends MouseSuite {

  Option(1).cata(_.toString, "") shouldEqual "1"

  Option.empty[Int].cata(_.toString, "") shouldEqual ""


  Option(1).toTry(new RuntimeException("Err")) shouldEqual Success(1)

  val ex = new RuntimeException("Err")
  Option.empty[Int].toTry(ex) shouldEqual Failure(ex)

  Option(3).right("S") shouldEqual Option(3).toRight("S")

  Option(3).left("S") shouldEqual Option(3).toLeft("S")

  None.right("S") shouldEqual None.toRight("S")

  None.left("S") shouldEqual None.toLeft("S")

  implicit class ExtraTest[A](a: A) {
    def shouldBeA[T](implicit ev: T =:= A) = succeed
  }

  Option(3).right("S").shouldBeA[Either[String, Int]]

  Option(3).left("S").shouldBeA[Either[Int, String]]

}
