package com.github.benhutchison.mouse

class OptionSyntaxTest extends MouseSuite {

  Option(1).cata(_.toString, "") shouldEqual "1"

  Option.empty[Int].cata(_.toString, "") shouldEqual ""

}
