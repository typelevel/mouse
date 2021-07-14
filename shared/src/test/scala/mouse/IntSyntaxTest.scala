package mouse

class IntSyntaxTest extends MouseSuite {
  test("IntSyntax.toByteArray") {
    assertEquals(123456789.toByteArray, Array(7, 91, -51, 21): Array[Byte])
  }

  test("IntSyntax.toBase64") {
    assertEquals(123456789.toBase64, "B1vNFQ")
  }

  test("IntSyntax.squared") {
    assertEquals(7.squared, 49)
  }
}
