package com.github.benhutchison.mouse

import cats.data.Xor
import com.github.benhutchison.mouse.boolean._

import org.scalatest.{FunSuite, Matchers}

class BooleanSyntaxTest extends FunSuite with Matchers {

  true.option(1) shouldEqual Option(1)

  false.option(1) shouldEqual Option.empty[Int]

  true.xor("error", 1) shouldEqual Xor.right(1)

  false.xor("error", 1) shouldEqual Xor.left("error")

}
