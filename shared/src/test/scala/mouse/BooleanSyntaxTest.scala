package mouse

import cats.syntax.either._

import mouse.boolean._

class BooleanSyntaxTest extends MouseSuite:

  testEquals(true.option(1), Option(1))

  testEquals(false.option(1), Option.empty[Int])

  testEquals(true.either("error", 1), Either.right(1))

  testEquals(false.either("error", 1), Either.left("error"))

  testEquals(true.fold("t", "f"), "t")

  testEquals(false.fold("t", "f"), "f")

  testEquals(true.valueOrZero(Option(())), Option(()))

  testEquals(false.valueOrZero(Option(())), Option.empty[Unit])

  testEquals(true.valueOrZero("Yellow"), "Yellow")

  testEquals(false.valueOrZero("Yellow"), "")

  testEquals(true.zeroOrValue("Yellow"), "")

  testEquals(false.zeroOrValue("Yellow"), "Yellow")

  testEquals(true.??("Yellow"), "Yellow")

  testEquals(true.!?("Yellow"), "")

  testEquals(true.valueOrPure(Option(1))(2), Some(1))

  testEquals(false.valueOrPure(Option(1))(2), Some(2))

  def mutilate(x: String): String = x.substring(1, 2)
  testEquals(true.applyIf("foo")(mutilate), "o")
  testEquals(false.applyIf("foo")(mutilate), "foo")

  true.whenA("foo".asLeft[Int]) shouldEqual Left("foo")
  false.whenA("foo".asLeft[Int]) shouldEqual Right(())

  true.unlessA("foo".asLeft[Int]) shouldEqual Right(())
  false.unlessA("foo".asLeft[Int]) shouldEqual Left("foo")
