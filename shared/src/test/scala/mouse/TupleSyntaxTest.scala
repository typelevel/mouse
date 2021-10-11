package mouse

class TupleSyntaxTest extends MouseSuite {
  private class A1()
  private class A2()
  private class A3()
  private class A4()
  private class A5()
  private class A6()
  private class A7()
  private class A8()
  private class A9()
  private class A10()
  private class A11()
  private class A12()
  private class A13()
  private class A14()
  private class A15()
  private class A16()
  private class A17()
  private class A18()
  private class A19()
  private class A20()
  private class A21()
  private class A22()

  private val a1 = new A1()
  private val a2 = new A2()
  private val a3 = new A3()
  private val a4 = new A4()
  private val a5 = new A5()
  private val a6 = new A6()
  private val a7 = new A7()
  private val a8 = new A8()
  private val a9 = new A9()
  private val a10 = new A10()
  private val a11 = new A11()
  private val a12 = new A12()
  private val a13 = new A13()
  private val a14 = new A14()
  private val a15 = new A15()
  private val a16 = new A16()
  private val a17 = new A17()
  private val a18 = new A18()
  private val a19 = new A19()
  private val a20 = new A20()
  private val a21 = new A21()
  private val a22 = new A22()

  test("Tuple2Syntax.init") {
    assertEquals((a1, a2).init, a1)
  }

  test("Tuple2Syntax.tail") {
    assertEquals((a1, a2).tail, a2)
  }

  test("Tuple3Syntax.init") {
    assertEquals((a1, a2, a3).init, (a1, a2))
  }

  test("Tuple3Syntax.tail") {
    assertEquals((a1, a2, a3).tail, (a2, a3))
  }

  test("Tuple4Syntax.init") {
    assertEquals((a1, a2, a3, a4).init, (a1, a2, a3))
  }

  test("Tuple4Syntax.tail") {
    assertEquals((a1, a2, a3, a4).tail, (a2, a3, a4))
  }

  test("Tuple5Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5).init, (a1, a2, a3, a4))
  }

  test("Tuple5Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5).tail, (a2, a3, a4, a5))
  }

  test("Tuple6Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6).init, (a1, a2, a3, a4, a5))
  }

  test("Tuple6Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6).tail, (a2, a3, a4, a5, a6))
  }

  test("Tuple7Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7).init, (a1, a2, a3, a4, a5, a6))
  }

  test("Tuple7Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7).tail, (a2, a3, a4, a5, a6, a7))
  }

  test("Tuple8Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8).init, (a1, a2, a3, a4, a5, a6, a7))
  }

  test("Tuple8Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8).tail, (a2, a3, a4, a5, a6, a7, a8))
  }

  test("Tuple9Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9).init, (a1, a2, a3, a4, a5, a6, a7, a8))
  }

  test("Tuple9Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9).tail, (a2, a3, a4, a5, a6, a7, a8, a9))
  }

  test("Tuple10Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10).init, (a1, a2, a3, a4, a5, a6, a7, a8, a9))
  }

  test("Tuple10Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10).tail, (a2, a3, a4, a5, a6, a7, a8, a9, a10))
  }

  test("Tuple11Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11).init, (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10))
  }

  test("Tuple11Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11).tail, (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11))
  }

  test("Tuple12Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12).init,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)
    )
  }

  test("Tuple12Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12).tail,
                 (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12)
    )
  }

  test("Tuple13Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13).init,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12)
    )
  }

  test("Tuple13Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13).tail,
                 (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13)
    )
  }

  test("Tuple14Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14).init,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13)
    )
  }

  test("Tuple14Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14).tail,
                 (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14)
    )
  }

  test("Tuple15Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15).init,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14)
    )

  }

  test("Tuple15Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15).tail,
                 (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15)
    )
  }

  test("Tuple16Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16).init,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15)
    )
  }

  test("Tuple16Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16).tail,
                 (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16)
    )
  }

  test("Tuple17Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17).init,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16)
    )
  }

  test("Tuple17Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17).tail,
                 (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17)
    )
  }

  test("Tuple18Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18).init,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17)
    )
  }

  test("Tuple18Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18).tail,
                 (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18)
    )
  }

  test("Tuple19Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19).init,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18)
    )
  }

  test("Tuple19Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19).tail,
                 (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19)
    )
  }

  test("Tuple20Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20).init,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19)
    )
  }

  test("Tuple20Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20).tail,
                 (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20)
    )
  }

  test("Tuple21Syntax.init") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21).init,
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20)
    )
  }

  test("Tuple21Syntax.tail") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21).tail,
      (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21)
    )
  }

  test("Tuple22Syntax.init") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22).init,
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21)
    )
  }

  test("Tuple22Syntax.tail") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22).tail,
      (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22)
    )
  }
}
