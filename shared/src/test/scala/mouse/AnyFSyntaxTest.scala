package mouse

import cats.syntax.option._
import cats.syntax.functor._
import cats.{Id, ~>}

class AnyFSyntaxTest extends MouseSuite {

  val emptyK = new (List ~> List) {
    def apply[A](x: List[A]) = Nil
  }

  val double = new (List ~> List) {
    def apply[A](x: List[A]) = x ::: x
  }

  type E[B] = Either[String, B]
  val toRight = new (Option ~> E) {
    def apply[A](x: Option[A]) = x.toRight("foo")
  }

  val headOption = new (List ~> Option) {
    def apply[A](x: List[A]) = x.headOption
  }

  val optionGet = new (Option ~> Id) {
    def apply[A](x: Option[A]) = x.get
  }

  List(1, 2, 3) thrushK emptyK shouldEqual Nil

  List(5, 10) thrushK double shouldEqual List(5, 10, 5, 10)

  "thing".some thrushK toRight shouldEqual Right(
    "thing"
  )

  (List("This") ||> double
    ||> headOption
    ||> optionGet) shouldEqual "This"
}
