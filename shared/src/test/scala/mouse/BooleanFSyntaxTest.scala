package mouse

import cats.instances.either._
import cats.syntax.either._

class BooleanFSyntaxTest extends MouseSuite {

  test("BooleanFSyntax.&&.F") {
    assertEquals(true.asRight[Int] && true.asRight[Int], Right(true))
    assertEquals(true.asRight[Int] && false.asRight[Int], Right(false))
    assertEquals(false.asRight[Int] && true.asRight[Int], Right(false))
    assertEquals(false.asRight[Int] && false.asRight[Int], Right(false))
    assertEquals(true.asRight[Unit] && ().asLeft[Boolean], Left(()))
    assertEquals(().asLeft[Boolean] && false.asRight[Unit], Left(()))
  }

  test("BooleanFSyntax.&&") {
    assertEquals(true.asRight[Int] && true, Right(true))
    assertEquals(true.asRight[Int] && false, Right(false))
    assertEquals(false.asRight[Int] && true, Right(false))
    assertEquals(false.asRight[Int] && false, Right(false))
    assertEquals(().asLeft[Boolean] && false, Left(()))
  }

  test("BooleanFSyntax.||.F") {
    assertEquals(true.asRight[Int] || true.asRight[Int], Right(true))
    assertEquals(true.asRight[Int] || false.asRight[Int], Right(true))
    assertEquals(false.asRight[Int] || true.asRight[Int], Right(true))
    assertEquals(false.asRight[Int] || false.asRight[Int], Right(false))
    assertEquals(true.asRight[Unit] || ().asLeft[Boolean], Right(true))
    assertEquals(().asLeft[Boolean] || false.asRight[Unit], Left(()))
  }

  test("BooleanFSyntax.||") {
    assertEquals(true.asRight[Int] || true, Right(true))
    assertEquals(true.asRight[Int] || false, Right(true))
    assertEquals(false.asRight[Int] || true, Right(true))
    assertEquals(false.asRight[Int] || false, Right(false))
    assertEquals(().asLeft[Boolean] || false, Left(()))
  }

  test("BooleanFSyntax.^.F") {
    assertEquals(true.asRight[Int] ^ true.asRight[Int], Right(false))
    assertEquals(true.asRight[Int] ^ false.asRight[Int], Right(true))
    assertEquals(false.asRight[Int] ^ true.asRight[Int], Right(true))
    assertEquals(false.asRight[Int] ^ false.asRight[Int], Right(false))
    assertEquals(true.asRight[Unit] ^ ().asLeft[Boolean], Left(()))
    assertEquals(().asLeft[Boolean] ^ false.asRight[Unit], Left(()))
  }

  test("BooleanFSyntax.^") {
    assertEquals(true.asRight[Int] ^ true, Right(false))
    assertEquals(true.asRight[Int] ^ false, Right(true))
    assertEquals(false.asRight[Int] ^ true, Right(true))
    assertEquals(false.asRight[Int] ^ false, Right(false))
    assertEquals(().asLeft[Boolean] ^ false, Left(()))
  }

  test("BooleanFSyntax.!") {
    assertEquals(!true.asRight[Int], Right(false))
    assertEquals(!false.asRight[Int], Right(true))
    assertEquals(!().asLeft[Boolean], Left(()))
  }
}
