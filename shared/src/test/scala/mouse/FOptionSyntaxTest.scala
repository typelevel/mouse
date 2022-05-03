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

import cats.data.OptionT
import cats.data.EitherT
import cats.syntax.either._

import scala.util.{Failure, Success, Try}

class FOptionSyntaxTest extends MouseSuite {
  test("FOptionSyntax.cata") {
    assertEquals(List(Option(1)).cata(0, _ => 2), List(2))
    assertEquals(List(Option.empty[Int]).cata(0, _ => 2), List(0))
  }

  test("FOptionSyntax.cataF") {
    assertEquals(List(Option(1)).cataF(List.empty[Int], _ => List(2)), List(2))
    assertEquals(List(Option.empty[Int]).cataF(List.empty[Int], _ => List(2)), List.empty[Int])
  }

  test("FOptionSyntax.existsIn") {
    assertEquals(Option(Option(1)).existsIn(_ > 2), Option(false))
    assertEquals(Option(Option(1)).existsIn(_ == 1), Option(true))
    assertEquals(Option(Option.empty[Int]).existsIn(_ > 2), Option(false))
  }

  test("FOptionSyntax.existsF") {
    assertEquals(Option(Option(1)).existsF(a => Option(a > 2)), Option(false))
    assertEquals(Option(Option(1)).existsF(a => Option(a == 1)), Option(true))
    assertEquals(Option(Option.empty[Int]).existsF(a => Option(a > 2)), Option(false))
  }

  test("FOptionSyntax.filterIn") {
    assertEquals(Option(Option(1)).filterIn(_ > 2), Option(Option.empty[Int]))
    assertEquals(Option(Option(1)).filterIn(_ == 1), Option(Option(1)))
    assertEquals(Option(Option.empty[Int]).filterIn(_ > 2), Option(Option.empty))
  }

  test("FOptionSyntax.filterF") {
    assertEquals(Option(Option(1)).filterF(a => Option(a > 2)), Option(Option.empty[Int]))
    assertEquals(Option(Option(1)).filterF(a => Option(a == 1)), Option(Option(1)))
    assertEquals(Option(Option.empty[Int]).filterF(a => Option(a > 2)), Option(Option.empty[Int]))
  }

  test("FOptionSyntax.flatMapIn") {
    assertEquals(List(Option(1)).flatMapIn(a => Option(a * 2)), List(Option(2)))
    assertEquals(List(Option.empty[Int]).flatMapIn(a => Option(a * 2)), List(Option.empty[Int]))
  }

  test("FOptionSyntax.flatMapF") {
    assertEquals(List(Option(1)).flatMapF(a => List(Option(a * 2))), List(Option(2)))
    assertEquals(List(Option.empty[Int]).flatMapF(a => List(Option(a * 2))), List(Option.empty[Int]))
  }

  test("FOptionSyntax.foldIn") {
    assertEquals(List(Option(1)).foldIn(false)(_ => true), List(true))
    assertEquals(List(Option.empty[Int]).foldIn(false)(_ => true), List(false))
  }

  test("FOptionSyntax.foldF") {
    assertEquals(List(Option(1)).foldF(List(false))(_ => List(true)), List(true))
    assertEquals(List(Option.empty[Int]).foldF(List(false))(_ => List(true)), List(false))
  }

  test("FOptionSyntax.forallIn") {
    assertEquals(Option(Option(1)).forallIn(_ > 2), Option(false))
    assertEquals(Option(Option(1)).forallIn(_ == 1), Option(true))
    assertEquals(Option(Option.empty[Int]).forallIn(_ > 2), Option(true))
  }

  test("FOptionSyntax.forallF") {
    assertEquals(Option(Option(1)).forallF(a => Option(a > 2)), Option(false))
    assertEquals(Option(Option(1)).forallF(a => Option(a == 1)), Option(true))
    assertEquals(Option(Option.empty[Int]).forallF(a => Option(a > 2)), Option(true))
  }

  test("FOptionSyntax.getOrElse") {
    assertEquals(List(Option(1)).getOrElse(0), List(1))
    assertEquals(List(Option.empty[Int]).getOrElse(0), List(0))
  }

  test("FOptionSyntax.getOrRaise") {
    val ex1 = new RuntimeException("BOOM 1!")
    val ex2 = new RuntimeException("BOOM 2!")

    assertEquals(Try(Option(1)).getOrRaise(ex1), Success(1))
    assertEquals(Try(Option.empty[Int]).getOrRaise(ex1), Failure(ex1))
    assertEquals(Try[Option[Int]](throw ex1).getOrRaise(ex2), Failure(ex1))
  }

  test("FOptionSyntax.getOrRaiseMsg") {
    val ex1 = new RuntimeException("BOOM 1!")
    assertEquals(Try(Option(1)).getOrRaiseMsg("BOOM!"), Success(1))
    assertEquals(Try(Option.empty[Int]).getOrRaiseMsg("BOOM!").failed.map(_.getMessage), Success("BOOM!"))
    assertEquals(Try[Option[Int]](throw ex1).getOrRaiseMsg("BOOM!"), Failure(ex1))
  }

  test("FOptionSyntax.getOrElseF") {
    assertEquals(List(Option(1)).getOrElseF(List(0)), List(1))
    assertEquals(List(Option.empty[Int]).getOrElseF(List(0)), List(0))
  }

  test("FOptionSyntax.mapIn") {
    assertEquals(List(Option(1)).mapIn(_ + 1), List(Option(2)))
    assertEquals(List(Option.empty[Int]).mapIn(_ + 1), List(Option.empty[Int]))
  }

  test("FOptionSyntax.orElseIn") {
    assertEquals(List(Option(1)).orElseIn(Option(0)), List(Option(1)))
    assertEquals(List(Option.empty[Int]).orElseIn(Option(0)), List(Option(0)))
  }

  test("FOptionSyntax.orElseF") {
    assertEquals(List(Option(1)).orElseF(List(Option(0))), List(Option(1)))
    assertEquals(List(Option.empty[Int]).orElseF(List(Option(0))), List(Option(0)))
  }

  test("FOptionSyntax.traverseIn") {
    assertEquals(List(Option(1)).traverseIn(a => List(a * 2)), List(List(Option(2))))
    assertEquals(List.empty[Option[Int]].traverseIn(a => List(a * 2)), List.empty[List[Option[Int]]])
    assertEquals(List(Option.empty[Int]).traverseIn(a => List(a * 2)), List(List(Option.empty[Int])))
  }

  test("FOptionSyntax.traverseF") {
    assertEquals(List(Option(1)).traverseF(a => Option(a * 2)), Option(List(Option(2))))
    assertEquals(List.empty[Option[Int]].traverseF(a => Option(a * 2)), Option(List.empty[Option[Int]]))
    assertEquals(List(Option.empty[Int]).traverseF(a => Option(a * 2)), Option(List(Option.empty[Int])))
  }

  test("FOptionSyntax.liftOptionT") {
    assertEquals(List(Option(1)).liftOptionT, OptionT(List(Option(1))))
    assertEquals(List(Option.empty[Int]).liftOptionT, OptionT(List(Option.empty[Int])))
  }

  test("FOptionSyntax.liftEitherT") {
    assertEquals(List(Option(1)).liftEitherT("none"), EitherT(List(1.asRight[String])))
    assertEquals(List(Option.empty[Int]).liftEitherT("none"), EitherT(List("none".asLeft[Int])))
  }

  test("FOptionSyntax.noneF") {
    assertEquals(FOptionSyntax.noneF[List, Int], List(None))
  }

  test("FOptionSyntax.someF") {
    assertEquals(FOptionSyntax.someF[List, Int](42), List(Some(42)))
  }
}
