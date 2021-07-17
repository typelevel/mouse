package mouse

import cats.data.{NonEmptyList, Validated}
import cats.syntax.either._

class BooleanSyntaxTest extends MouseSuite {
  test("BooleanSyntax.option") {
    assertEquals(true.option(1), Option(1))
    assertEquals(false.option(1), Option.empty[Int])
  }

  test("BooleanSyntax.either") {
    assertEquals(true.either("error", 1), Either.right(1))
    assertEquals(false.either("error", 1), Either.left("error"))
  }

  test("BooleanSyntax.eitherNel") {
    assertEquals(true.eitherNel("error", 1), Either.right(1))
    assertEquals(false.eitherNel("error", 1), Either.left(NonEmptyList.one("error")))
  }

  test("BooleanSyntax.validatedNel") {
    assertEquals(true.validatedNel("error", 1), Validated.validNel(1))
    assertEquals(false.validatedNel("error", 1), Validated.invalidNel("error"))
  }

  test("BooleanSyntax.liftTo") {
    type F[A] = Either[String, A]

    assertEquals(true.liftTo[F]("error"), Either.right(()))
    assertEquals(false.liftTo[F]("error"), Either.left("error"))
  }

  test("BooleanSyntax.fold") {
    assertEquals(true.fold("t", "f"), "t")
    assertEquals(false.fold("t", "f"), "f")
  }

  test("BooleanSyntax.valueOrZero") {
    assertEquals(true.valueOrZero(Option(())), Option(()))
    assertEquals(false.valueOrZero(Option(())), Option.empty[Unit])
    assertEquals(true.valueOrZero("Yellow"), "Yellow")
    assertEquals(false.valueOrZero("Yellow"), "")
  }

  test("BooleanSyntax.zeroOrValue") {
    assertEquals(true.zeroOrValue("Yellow"), "")
    assertEquals(false.zeroOrValue("Yellow"), "Yellow")
  }

  test("BooleanSyntax.??") {
    assertEquals(true.??("Yellow"), "Yellow")
  }

  test("BooleanSyntax.!?") {
    assertEquals(true.!?("Yellow"), "")
  }

  test("BooleanSyntax.valueOrPure") {
    assertEquals(true.valueOrPure(Option(1))(2), Some(1))
    assertEquals(false.valueOrPure(Option(1))(2), Some(2))
  }

  test("BooleanSyntax.applyIf") {
    def mutilate(x: CharSequence): CharSequence = x.subSequence(1, 2)

    assertEquals(true.applyIf("foo")(mutilate), "o")
    assertEquals(false.applyIf("foo")(mutilate), "foo")
  }

  test("BooleanSyntax.whenA") {
    assertEquals(true.whenA("foo".asLeft[Int]), Left("foo"))
    assertEquals(false.whenA("foo".asLeft[Int]), Right(()))
  }

  test("BooleanSyntax.unlessA") {
    assertEquals(true.unlessA("foo".asLeft[Int]), Right(()))
    assertEquals(false.unlessA("foo".asLeft[Int]), Left("foo"))
  }
}
