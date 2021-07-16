package mouse

class IntSyntaxTest extends MouseSuite {
  test("IntSyntax.toByteArray") {
    assert(123456789.toByteArray sameElements Array(7, 91, -51, 21))
  }

  test("IntSyntax.toBase64") {
    assertEquals(123456789.toBase64, "B1vNFQ")
  }

  test("IntSyntax.squared") {
    assertEquals(7.squared, 49)
  }
}
