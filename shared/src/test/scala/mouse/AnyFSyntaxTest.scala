/*
 * Copyright (c) 2016 Typelevel
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package mouse

import cats.data.EitherT
import cats.data.OptionT
import cats.syntax.option.*
import cats.syntax.either.*
import cats.{Id, ~>}

import scala.util.{Success, Try}

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

  test("AnyFSyntax.asRightIn") {
    assertEquals(List(1).mapAsRight[String], List(1.asRight))
  }

  test("AnyFSyntax.asLeftIn") {
    assertEquals(List(1).mapAsLeft[String], List(1.asLeft))
  }

  test("AnyFSyntax.asSomeIn") {
    assertEquals(List(1).mapAsSome, List(1.some))
  }

  test("AnyFSyntax.recoverEither") {
    assertEquals(
      Try[Int](1).recoverEither {
        case _: Throwable => Right(2)
      },
      Success(1.asRight)
    )

    assertEquals(
      Try[Int](throw new RuntimeException("boom")).recoverEither {
        case _: Throwable => Right(2)
      },
      Success(2.asRight)
    )
  }


  test("AnyFSyntax.recoverAsRight") {
    assertEquals(
      Try[Int](1).recoverAsRight {
        case _: Throwable => 2
      },
      Success(1.asRight)
    )

    assertEquals(
      Try[Int](throw new RuntimeException("boom")).recoverAsRight {
        case _: Throwable => 2
      },
      Success(2.asRight)
    )
  }

  test("AnyFSyntax.recoverAsLeft") {
    assertEquals(
      Try(1).recoverAsLeft {
        case _: Throwable => "foo"
      },
      Success(1.asRight)
    )

    assertEquals(
      Try(throw new RuntimeException("boom")).recoverAsLeft {
        case _: Throwable => "error"
      },
      Success("error".asLeft)
    )
  }

  test("AnyFSyntax.liftEitherT") {
    assertEquals(List(1).liftEitherT[String], EitherT(List(1.asRight[String])))
  }

  test("AnyFSyntax.liftOptionT") {
    assertEquals(List(1).liftOptionT, OptionT(List(Option(1))))
  }
}
