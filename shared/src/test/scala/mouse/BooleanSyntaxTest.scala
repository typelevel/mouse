package mouse

import cats.syntax.either._

class BooleanSyntaxTest extends MouseSuite {

  true.option(1) shouldEqual Option(1)

  false.option(1) shouldEqual Option.empty[Int]

  true.either("error", 1) shouldEqual Either.right(1)

  false.either("error", 1) shouldEqual Either.left("error")

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
}
