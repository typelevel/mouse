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

  test("Tuple2Syntax.head") {
    assertEquals((a1, a2).head, a1)
  }

  test("Tuple2Syntax.last") {
    assertEquals((a1, a2).last, a2)
  }

  test("Tuple2Syntax.prepend") {
    assertEquals(a3 *: (a1, a2), (a3, a1, a2))
  }

  test("Tuple2Syntax.append") {
    assertEquals((a1, a2) :* a3, (a1, a2, a3))
  }

  test("Tuple2Syntax.reverse") {
    assertEquals((a1, a2).reverse, (a2, a1))
  }

  test("Tuple3Syntax.init") {
    assertEquals((a1, a2, a3).init, (a1, a2))
  }

  test("Tuple3Syntax.head") {
    assertEquals((a1, a2, a3).head, a1)
  }

  test("Tuple3Syntax.prepend") {
    assertEquals(a4 *: (a1, a2, a3), (a4, a1, a2, a3))
  }

  test("Tuple3Syntax.append") {
    assertEquals((a1, a2, a3) :* a4, (a1, a2, a3, a4))
  }

  test("Tuple3Syntax.last") {
    assertEquals((a1, a2, a3).last, a3)
  }

  test("Tuple3Syntax.tail") {
    assertEquals((a1, a2, a3).tail, (a2, a3))
  }

  test("Tuple3Syntax.reverse") {
    assertEquals((a1, a2, a3).reverse, (a3, a2, a1))
  }

  test("Tuple4Syntax.init") {
    assertEquals((a1, a2, a3, a4).init, (a1, a2, a3))
  }

  test("Tuple4Syntax.head") {
    assertEquals((a1, a2, a3, a4).head, a1)
  }

  test("Tuple4Syntax.last") {
    assertEquals((a1, a2, a3, a4).last, a4)
  }

  test("Tuple4Syntax.tail") {
    assertEquals((a1, a2, a3, a4).tail, (a2, a3, a4))
  }

  test("Tuple4Syntax.prepend") {
    assertEquals(a5 *: (a1, a2, a3, a4), (a5, a1, a2, a3, a4))
  }

  test("Tuple4Syntax.append") {
    assertEquals((a1, a2, a3, a4) :* a5, (a1, a2, a3, a4, a5))
  }

  test("Tuple4Syntax.reverse") {
    assertEquals((a1, a2, a3, a4).reverse, (a4, a3, a2, a1))
  }

  test("Tuple5Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5).init, (a1, a2, a3, a4))
  }

  test("Tuple5Syntax.head") {
    assertEquals((a1, a2, a3, a4, a5).head, a1)
  }

  test("Tuple5Syntax.last") {
    assertEquals((a1, a2, a3, a4, a5).last, a5)
  }

  test("Tuple5Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5).tail, (a2, a3, a4, a5))
  }

  test("Tuple5Syntax.append") {
    assertEquals((a1, a2, a3, a4, a5) :* a6, (a1, a2, a3, a4, a5, a6))
  }

  test("Tuple5Syntax.prepend") {
    assertEquals(a6 *: (a1, a2, a3, a4, a5), (a6, a1, a2, a3, a4, a5))
  }

  test("Tuple5Syntax.reverse") {
    assertEquals((a1, a2, a3, a4, a5).reverse, (a5, a4, a3, a2, a1))
  }

  test("Tuple6Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6).init, (a1, a2, a3, a4, a5))
  }

  test("Tuple6Syntax.head") {
    assertEquals((a1, a2, a3, a4, a5, a6).head, a1)
  }

  test("Tuple6Syntax.last") {
    assertEquals((a1, a2, a3, a4, a5, a6).last, a6)
  }

  test("Tuple6Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6).tail, (a2, a3, a4, a5, a6))
  }

  test("Tuple6Syntax.append") {
    assertEquals((a1, a2, a3, a4, a5, a6) :* a7, (a1, a2, a3, a4, a5, a6, a7))
  }

  test("Tuple6Syntax.prepend") {
    assertEquals(a7 *: (a1, a2, a3, a4, a5, a6), (a7, a1, a2, a3, a4, a5, a6))
  }

  test("Tuple6Syntax.reverse") {
    assertEquals((a1, a2, a3, a4, a5, a6).reverse, (a6, a5, a4, a3, a2, a1))
  }

  test("Tuple7Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7).init, (a1, a2, a3, a4, a5, a6))
  }

  test("Tuple7Syntax.head") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7).head, a1)
  }

  test("Tuple7Syntax.last") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7).last, a7)
  }

  test("Tuple7Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7).tail, (a2, a3, a4, a5, a6, a7))
  }

  test("Tuple7Syntax.append") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7) :* a8, (a1, a2, a3, a4, a5, a6, a7, a8))
  }

  test("Tuple7Syntax.prepend") {
    assertEquals(a8 *: (a1, a2, a3, a4, a5, a6, a7), (a8, a1, a2, a3, a4, a5, a6, a7))
  }

  test("Tuple7Syntax.reverse") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7).reverse, (a7, a6, a5, a4, a3, a2, a1))
  }

  test("Tuple8Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8).init, (a1, a2, a3, a4, a5, a6, a7))
  }

  test("Tuple8Syntax.head") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8).head, a1)
  }

  test("Tuple8Syntax.last") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8).last, a8)
  }

  test("Tuple8Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8).tail, (a2, a3, a4, a5, a6, a7, a8))
  }

  test("Tuple8Syntax.append") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8) :* a9, (a1, a2, a3, a4, a5, a6, a7, a8, a9))
  }

  test("Tuple8Syntax.prepend") {
    assertEquals(a9 *: (a1, a2, a3, a4, a5, a6, a7, a8), (a9, a1, a2, a3, a4, a5, a6, a7, a8))
  }

  test("Tuple8Syntax.reverse") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8).reverse, (a8, a7, a6, a5, a4, a3, a2, a1))
  }

  test("Tuple9Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9).init, (a1, a2, a3, a4, a5, a6, a7, a8))
  }

  test("Tuple9Syntax.head") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9).head, a1)
  }

  test("Tuple9Syntax.last") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9).last, a9)
  }

  test("Tuple9Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9).tail, (a2, a3, a4, a5, a6, a7, a8, a9))
  }

  test("Tuple9Syntax.append") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9) :* a10, (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10))
  }

  test("Tuple9Syntax.prepend") {
    assertEquals(a10 *: (a1, a2, a3, a4, a5, a6, a7, a8, a9), (a10, a1, a2, a3, a4, a5, a6, a7, a8, a9))
  }

  test("Tuple9Syntax.reverse") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9).reverse, (a9, a8, a7, a6, a5, a4, a3, a2, a1))
  }

  test("Tuple10Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10).init, (a1, a2, a3, a4, a5, a6, a7, a8, a9))
  }

  test("Tuple10Syntax.head") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10).head, a1)
  }

  test("Tuple10Syntax.last") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10).last, a10)
  }

  test("Tuple10Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10).tail, (a2, a3, a4, a5, a6, a7, a8, a9, a10))
  }

  test("Tuple10Syntax.append") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10) :* a11, (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11))
  }

  test("Tuple10Syntax.prepend") {
    assertEquals(a11 *: (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10), (a11, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10))
  }

  test("Tuple10Syntax.reverse") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10).reverse, (a10, a9, a8, a7, a6, a5, a4, a3, a2, a1))
  }

  test("Tuple11Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11).init, (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10))
  }

  test("Tuple11Syntax.head") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11).head, a1)
  }

  test("Tuple11Syntax.last") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11).last, a11)
  }

  test("Tuple11Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11).tail, (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11))
  }

  test("Tuple11Syntax.append") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11) :* a12,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12)
    )
  }

  test("Tuple11Syntax.prepend") {
    assertEquals(a12 *: (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11),
                 (a12, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)
    )
  }

  test("Tuple11Syntax.reverse") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11).reverse,
      (a11, a10, a9, a8, a7, a6, a5, a4, a3, a2, a1)
    )
  }

  test("Tuple12Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12).init,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)
    )
  }

  test("Tuple12Syntax.head") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12).head, a1)
  }

  test("Tuple12Syntax.last") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12).last, a12)
  }

  test("Tuple12Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12).tail,
                 (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12)
    )
  }

  test("Tuple12Syntax.append") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12) :* a13,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13)
    )
  }

  test("Tuple12Syntax.prepend") {
    assertEquals(a13 *: (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12),
                 (a13, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12)
    )
  }

  test("Tuple12Syntax.reverse") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12).reverse,
      (a12, a11, a10, a9, a8, a7, a6, a5, a4, a3, a2, a1)
    )
  }

  test("Tuple13Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13).init,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12)
    )
  }

  test("Tuple13Syntax.head") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13).head, a1)
  }

  test("Tuple13Syntax.last") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13).last, a13)
  }

  test("Tuple13Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13).tail,
                 (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13)
    )
  }

  test("Tuple13Syntax.append") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13) :* a14,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14)
    )
  }

  test("Tuple13Syntax.prepend") {
    assertEquals(a14 *: (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13),
                 (a14, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13)
    )
  }

  test("Tuple13Syntax.reverse") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13).reverse,
      (a13, a12, a11, a10, a9, a8, a7, a6, a5, a4, a3, a2, a1)
    )
  }

  test("Tuple14Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14).init,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13)
    )
  }

  test("Tuple14Syntax.head") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14).head, a1)
  }

  test("Tuple14Syntax.last") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14).last, a14)
  }

  test("Tuple14Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14).tail,
                 (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14)
    )
  }

  test("Tuple14Syntax.append") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14) :* a15,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15)
    )
  }

  test("Tuple14Syntax.prepend") {
    assertEquals(a15 *: (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14),
                 (a15, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14)
    )
  }

  test("Tuple14Syntax.reverse") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14).reverse,
      (a14, a13, a12, a11, a10, a9, a8, a7, a6, a5, a4, a3, a2, a1)
    )
  }

  test("Tuple15Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15).init,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14)
    )
  }

  test("Tuple15Syntax.head") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15).head, a1)
  }

  test("Tuple15Syntax.last") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15).last, a15)
  }

  test("Tuple15Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15).tail,
                 (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15)
    )
  }

  test("Tuple15Syntax.append") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15) :* a16,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16)
    )
  }

  test("Tuple15Syntax.prepend") {
    assertEquals(a16 *: (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15),
                 (a16, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15)
    )
  }

  test("Tuple15Syntax.reverse") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15).reverse,
      (a15, a14, a13, a12, a11, a10, a9, a8, a7, a6, a5, a4, a3, a2, a1)
    )
  }

  test("Tuple16Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16).init,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15)
    )
  }

  test("Tuple16Syntax.head") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16).head, a1)
  }

  test("Tuple16Syntax.last") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16).last, a16)
  }

  test("Tuple16Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16).tail,
                 (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16)
    )
  }

  test("Tuple16Syntax.append") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16) :* a17,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17)
    )
  }

  test("Tuple16Syntax.prepend") {
    assertEquals(a17 *: (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16),
                 (a17, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16)
    )
  }

  test("Tuple16Syntax.reverse") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16).reverse,
      (a16, a15, a14, a13, a12, a11, a10, a9, a8, a7, a6, a5, a4, a3, a2, a1)
    )
  }

  test("Tuple17Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17).init,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16)
    )
  }

  test("Tuple17Syntax.head") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17).head, a1)
  }

  test("Tuple17Syntax.last") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17).last, a17)
  }

  test("Tuple17Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17).tail,
                 (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17)
    )
  }

  test("Tuple17Syntax.append") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17) :* a18,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18)
    )
  }

  test("Tuple17Syntax.prepend") {
    assertEquals(a18 *: (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17),
                 (a18, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17)
    )
  }

  test("Tuple17Syntax.reverse") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17).reverse,
      (a17, a16, a15, a14, a13, a12, a11, a10, a9, a8, a7, a6, a5, a4, a3, a2, a1)
    )
  }

  test("Tuple18Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18).init,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17)
    )
  }

  test("Tuple18Syntax.head") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18).head, a1)
  }

  test("Tuple18Syntax.last") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18).last, a18)
  }

  test("Tuple18Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18).tail,
                 (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18)
    )
  }

  test("Tuple18Syntax.append") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18) :* a19,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19)
    )
  }

  test("Tuple18Syntax.prepend") {
    assertEquals(a19 *: (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18),
                 (a19, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18)
    )
  }

  test("Tuple18Syntax.reverse") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18).reverse,
      (a18, a17, a16, a15, a14, a13, a12, a11, a10, a9, a8, a7, a6, a5, a4, a3, a2, a1)
    )
  }

  test("Tuple19Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19).init,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18)
    )
  }

  test("Tuple19Syntax.head") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19).head, a1)
  }

  test("Tuple19Syntax.last") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19).last, a19)
  }

  test("Tuple19Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19).tail,
                 (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19)
    )
  }

  test("Tuple19Syntax.append") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19) :* a20,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20)
    )
  }

  test("Tuple19Syntax.prepend") {
    assertEquals(a20 *: (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19),
                 (a20, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19)
    )
  }

  test("Tuple19Syntax.reverse") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19).reverse,
      (a19, a18, a17, a16, a15, a14, a13, a12, a11, a10, a9, a8, a7, a6, a5, a4, a3, a2, a1)
    )
  }

  test("Tuple20Syntax.init") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20).init,
                 (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19)
    )
  }

  test("Tuple20Syntax.head") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20).head, a1)
  }

  test("Tuple20Syntax.last") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20).last, a20)
  }

  test("Tuple20Syntax.tail") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20).tail,
                 (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20)
    )
  }

  test("Tuple20Syntax.append") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20) :* a21,
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21)
    )
  }

  test("Tuple20Syntax.prepend") {
    assertEquals(
      a21 *: (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20),
      (a21, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20)
    )
  }

  test("Tuple20Syntax.reverse") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20).reverse,
      (a20, a19, a18, a17, a16, a15, a14, a13, a12, a11, a10, a9, a8, a7, a6, a5, a4, a3, a2, a1)
    )
  }

  test("Tuple21Syntax.init") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21).init,
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20)
    )
  }

  test("Tuple21Syntax.head") {
    assertEquals((a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21).head,
                 a1
    )
  }

  test("Tuple21Syntax.last") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21).last,
      a21
    )
  }

  test("Tuple21Syntax.tail") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21).tail,
      (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21)
    )
  }

  test("Tuple21Syntax.append") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21) :* a22,
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22)
    )
  }

  test("Tuple21Syntax.prepend") {
    assertEquals(
      a22 *: (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21),
      (a22, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21)
    )
  }

  test("Tuple21Syntax.reverse") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21).reverse,
      (a21, a20, a19, a18, a17, a16, a15, a14, a13, a12, a11, a10, a9, a8, a7, a6, a5, a4, a3, a2, a1)
    )
  }

  test("Tuple22Syntax.init") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22).init,
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21)
    )
  }

  test("Tuple22Syntax.head") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22).head,
      a1
    )
  }

  test("Tuple22Syntax.last") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22).last,
      a22
    )
  }

  test("Tuple22Syntax.tail") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22).tail,
      (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22)
    )
  }

  test("Tuple22Syntax.reverse") {
    assertEquals(
      (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22).reverse,
      (a22, a21, a20, a19, a18, a17, a16, a15, a14, a13, a12, a11, a10, a9, a8, a7, a6, a5, a4, a3, a2, a1)
    )
  }
}
