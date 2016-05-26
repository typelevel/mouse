package com.github.benhutchison.mouse

class OptionSyntaxTest extends MouseSuite {

  test("cata") {

    Option(1).cata(_.toString, "") shouldEqual "1"

    Option.empty[Int].cata(_.toString, "") shouldEqual ""
  }

  test("getOrEmpty") {

    Option(1).getOrEmpty shouldEqual 1

    Option.empty[String].getOrEmpty shouldEqual ""
  }

}
