package mouse

import cats.data.Xor

class BooleanSyntaxTest extends MouseSuite {

  true.option(1) shouldEqual Option(1)

  false.option(1) shouldEqual Option.empty[Int]

  true.xor("error", 1) shouldEqual Xor.right(1)

  false.xor("error", 1) shouldEqual Xor.left("error")

}
