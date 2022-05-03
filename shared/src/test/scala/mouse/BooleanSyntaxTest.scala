/*
 * Copyright (c) 2022 Typelevel
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

  test("BooleanSyntax.validated") {
    assertEquals(true.validated("error", 1), Validated.valid(1))
    assertEquals(false.validated("error", 1), Validated.invalid("error"))
  }

  test("BooleanSyntax.validatedNec") {
    assertEquals(true.validatedNec("error", 1), Validated.validNec(1))
    assertEquals(false.validatedNec("error", 1), Validated.invalidNec("error"))
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

  test("BooleanSyntax.whenAL") {
    var lazinessChecker: Int = 0

    assertEquals(true.whenAL("foo".asLeft[Int]), Left("foo"))
    assertEquals(
      false.whenAL(Either.left {
        lazinessChecker = 1
        "foo"
      }),
      Right(())
    )
    assertEquals(lazinessChecker, 0)
  }

  test("BooleanSyntax.unlessAL") {
    var lazinessChecker: Int = 0

    assertEquals(false.unlessAL("foo".asLeft[Int]), Left("foo"))
    assertEquals(
      true.unlessAL(Either.left {
        lazinessChecker = 1
        "foo"
      }),
      Right(())
    )
    assertEquals(lazinessChecker, 0)
  }
}
