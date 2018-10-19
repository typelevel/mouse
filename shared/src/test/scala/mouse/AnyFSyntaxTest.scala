package mouse

import cats.syntax.option._
import cats.syntax.functor._
import cats.{Id, ~>}

class AnyFSyntaxTest extends MouseSuite {

  val emptyK: List ~> List = λ[List ~> List](_ => Nil)

  val double: List ~> List = λ[List ~> List](list => list ::: list)

  List(1, 2, 3) thrushK emptyK shouldEqual Nil

  List(5, 10) thrushK double shouldEqual List(5, 10, 5, 10)

  "thing".some thrushK (λ[Option ~> Either[String, ?]](_.toRight("foo"))) shouldEqual Right(
    "thing"
  )

  (List("This") thrushK double
    thrushK λ[List ~> Option](_.headOption)
    thrushK λ[Option ~> Id](_.head)) shouldEqual "This"
}
