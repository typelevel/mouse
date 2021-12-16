package mouse

import cats.data.EitherT
import cats.syntax.either._

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
