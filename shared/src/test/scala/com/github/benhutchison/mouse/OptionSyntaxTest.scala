package com.github.benhutchison.mouse

import org.scalatest.{FunSuite, Matchers}

import option._

class OptionSyntaxTest extends FunSuite with Matchers {

  Option(1).cata(_.toString, "") shouldEqual "1"

  Option.empty[Int].cata(_.toString, "") shouldEqual ""

}
