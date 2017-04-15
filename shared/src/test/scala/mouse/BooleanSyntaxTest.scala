package mouse

import cats.syntax.either._

class BooleanSyntaxTest extends MouseSuite {

  true.option(1) shouldEqual Option(1)

  false.option(1) shouldEqual Option.empty[Int]

  true.either("error", 1) shouldEqual Either.right(1)

  false.either("error", 1) shouldEqual Either.left("error")

  true.fold("t", "f") shouldEqual "t"
  
  false.fold("t", "f") shouldEqual "f"

}
