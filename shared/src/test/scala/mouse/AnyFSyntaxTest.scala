package mouse

import cats.syntax.option._
import cats.syntax.functor._
import cats.{~>, Id}

class AnyFSyntaxTest extends MouseSuite {
  private val emptyK = new (List ~> List) {
    def apply[A](x: List[A]) = Nil
  }

  private val double = new (List ~> List) {
    def apply[A](x: List[A]) = x ::: x
  }

  private type E[B] = Either[String, B]

  private val toRight = new (Option ~> E) {
    def apply[A](x: Option[A]) = x.toRight("foo")
  }

  private val headOption = new (List ~> Option) {
    def apply[A](x: List[A]) = x.headOption
  }

  private val optionGet = new (Option ~> Id) {
    def apply[A](x: Option[A]) = x.get
  }

  test("AnyFSyntax.thrushK") {
    assertEquals(List(1, 2, 3).thrushK(emptyK), List.empty)

    assertEquals(List(5, 10).thrushK(double), List(5, 10, 5, 10))

    assertEquals("thing".some.thrushK(toRight), Right("thing"))

    assertEquals(
      List("This") ||> double ||> headOption ||> optionGet,
      "This"
    )
  }
}
