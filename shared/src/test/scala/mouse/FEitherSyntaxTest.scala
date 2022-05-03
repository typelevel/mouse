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
import cats.syntax.either._

import scala.util.{Failure, Success, Try}

class FEitherSyntaxTest extends MouseSuite {
  private val rightValue = List(42.asRight[String])
  private val leftValue = List("42".asLeft[Int])

  test("FEitherSyntax.cata") {
    assertEquals(rightValue.cata(_ => 0, _ => 1), List(1))
    assertEquals(leftValue.cata(_ => 0, _ => 1), List(0))
  }

  test("FEitherSyntax.cataF") {
    assertEquals(rightValue.cataF(_ => List(0), _ => List(1)), List(1))
    assertEquals(leftValue.cataF(_ => List(0), _ => List(1)), List(0))
  }

  test("FEitherSyntax.flatMapIn") {
    assertEquals(rightValue.flatMapIn(i => (i * 2).asRight[String]), List(84.asRight[String]))
    assertEquals(leftValue.flatMapIn(i => (i * 2).asRight[String]), leftValue)
  }

  test("FEitherSyntax.flatMapF") {
    assertEquals(rightValue.flatMapF(i => List((i * 2).asRight[String])), List(84.asRight[String]))
    assertEquals(leftValue.flatMapF(i => List((i * 2).asRight[String])), leftValue)
  }

  test("FEitherSyntax.foldIn") {
    assertEquals(rightValue.foldIn(_ => 0)(_ => 1), List(1))
    assertEquals(leftValue.foldIn(_ => 0)(_ => 1), List(0))
  }

  test("FEitherSyntax.foldF") {
    assertEquals(rightValue.foldF(_ => List(0))(_ => List(1)), List(1))
    assertEquals(leftValue.foldF(_ => List(0))(_ => List(1)), List(0))
  }

  test("FEitherSyntax.getOrElseIn") {
    assertEquals(rightValue.getOrElseIn(0), List(42))
    assertEquals(leftValue.getOrElseIn(0), List(0))
  }

  test("FEitherSyntax.getOrRaise") {
    val ex1 = new RuntimeException("BOOM 1!")
    val ex2 = new RuntimeException("BOOM 2!")

    assertEquals(Try(1.asRight).getOrRaise(ex1), Success(1))
    assertEquals(Try("ERROR".asLeft).getOrRaise(ex1), Failure(ex1))
    assertEquals(Try[Either[String, Int]](throw ex1).getOrRaise(ex2), Failure(ex1))
  }

  test("FEitherSyntax.getOrRaiseMsg") {
    val ex1 = new RuntimeException("BOOM 1!")
    assertEquals(Try(1.asRight).getOrRaiseMsg("BOOM!"), Success(1))
    assertEquals(Try("ERROR".asLeft).getOrRaiseMsg("BOOM!").failed.map(_.getMessage), Success("BOOM!"))
    assertEquals(Try[Either[String, Int]](throw ex1).getOrRaiseMsg("BOOM!"), Failure(ex1))
  }

  test("FEitherSyntax.getOrElseF") {
    assertEquals(rightValue.getOrElseF(List(0)), List(42))
    assertEquals(leftValue.getOrElseF(List(0)), List(0))
  }

  test("FEitherSyntax.leftFlatMapIn") {
    assertEquals(rightValue.leftFlatMapIn(_ => "".asLeft[Int]), rightValue)
    assertEquals(leftValue.leftFlatMapIn(_ => "".asLeft[Int]), List("".asLeft[Int]))
  }

  test("FEitherSyntax.leftFlatMapF") {
    assertEquals(rightValue.leftFlatMapF(_ => List("".asLeft[Int])), rightValue)
    assertEquals(leftValue.leftFlatMapF(_ => List("".asLeft[Int])), List("".asLeft[Int]))
  }

  test("FEitherSyntax.leftMapIn") {
    assertEquals(rightValue.leftMapIn(_ => ""), rightValue)
    assertEquals(leftValue.leftMapIn(_ => ""), List("".asLeft[Int]))
  }

  test("FEitherSyntax.leftTraverseIn") {
    assertEquals(rightValue.leftTraverseIn(_ => Option("")), List(Option(42.asRight[String])))
    assertEquals(leftValue.leftTraverseIn(_ => Option("")), List(Option("".asLeft[Int])))
  }

  test("FEitherSyntax.leftTraverseF") {
    assertEquals(rightValue.leftTraverseF(_ => Option("")), Option(List(42.asRight[String])))
    assertEquals(leftValue.leftTraverseF(_ => Option("")), Option(List("".asLeft[Int])))
  }

  test("FEitherSyntax.mapIn") {
    assertEquals(rightValue.mapIn(_ * 2), List(84.asRight[String]))
    assertEquals(leftValue.mapIn(_ * 2), leftValue)
  }

  test("FEitherSyntax.orElseIn") {
    assertEquals(rightValue.orElseIn(0.asRight[String]), rightValue)
    assertEquals(leftValue.orElseIn(0.asRight[String]), List(0.asRight[String]))
  }

  test("FEitherSyntax.orElseF") {
    assertEquals(rightValue.orElseF(List(0.asRight[String])), rightValue)
    assertEquals(leftValue.orElseF(List(0.asRight[String])), List(0.asRight[String]))
  }

  test("FEitherSyntax.traverseIn") {
    assertEquals(rightValue.traverseIn(_ => Option(1)), List(Option(1.asRight[String])))
    assertEquals(leftValue.traverseIn(_ => Option(0)), List(Option("42".asLeft[Int])))
  }

  test("FEitherSyntax.traverseF") {
    assertEquals(rightValue.traverseF(_ => Option(1)), Option(List(1.asRight[String])))
    assertEquals(leftValue.traverseF(_ => Option(0)), Option(List("42".asLeft[Int])))
  }

  test("FEitherSyntax.liftEitherT") {
    assertEquals(rightValue.liftEitherT, EitherT(rightValue))
    assertEquals(leftValue.liftEitherT, EitherT(leftValue))
  }

  test("FEitherSyntax.asLeftF") {
    assertEquals(FEitherSyntax.asLeftF[List, String, Int](""), List(Left("")))
  }

  test("FEitherSyntax.asRightF") {
    assertEquals(FEitherSyntax.asRightF[List, String, Int](42), List(Right(42)))
  }
}
