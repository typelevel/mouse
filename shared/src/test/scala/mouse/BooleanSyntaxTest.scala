package mouse

import cats.data.{NonEmptyList, Validated}
import cats.syntax.either._

class BooleanSyntaxTest extends MouseSuite {

  true.option(1) shouldEqual Option(1)

  false.option(1) shouldEqual Option.empty[Int]

  true.either("error", 1) shouldEqual Either.right(1)

  false.either("error", 1) shouldEqual Either.left("error")

  true.eitherNel("error", 1) shouldEqual Either.right(1)

  false.eitherNel("error", 1) shouldEqual Either.left(NonEmptyList.one("error"))

  true.validatedNel("error", 1) shouldEqual Validated.validNel(1)

  false.validatedNel("error", 1) shouldEqual Validated.invalidNel("error")

  type F[A] = Either[String, A]

  true.liftTo[F]("error") shouldEqual Either.right(())

  false.liftTo[F]("error") shouldEqual Either.left("error")

  true.fold("t", "f") shouldEqual "t"
  
  false.fold("t", "f") shouldEqual "f"

  true.valueOrZero(Option(())) shouldEqual Option(())

  false.valueOrZero(Option(())) shouldEqual Option.empty[Unit]

  true.valueOrZero("Yellow") shouldEqual "Yellow"

  false.valueOrZero("Yellow") shouldEqual ""

  true.zeroOrValue("Yellow") shouldEqual ""

  false.zeroOrValue("Yellow") shouldEqual "Yellow"

  true.??("Yellow") shouldEqual "Yellow"

  true.!?("Yellow") shouldEqual ""

  true.valueOrPure(Option(1))(2) shouldEqual Some(1)

  false.valueOrPure(Option(1))(2) shouldEqual Some(2)
  
  def mutilate(x: CharSequence): CharSequence = x.subSequence(1, 2)
  true.applyIf("foo")(mutilate) shouldEqual "o"
  false.applyIf("foo")(mutilate) shouldEqual "foo"

  true.whenA("foo".asLeft[Int]) shouldEqual Left("foo")
  false.whenA("foo".asLeft[Int]) shouldEqual Right(())

  true.unlessA("foo".asLeft[Int]) shouldEqual Right(())
  false.unlessA("foo".asLeft[Int]) shouldEqual Left("foo")
}
