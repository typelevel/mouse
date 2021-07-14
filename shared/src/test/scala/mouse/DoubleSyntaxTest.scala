package mouse

class DoubleSyntaxTest extends MouseSuite {
  test("DoubleSyntax.toByteArray") {
    assertEquals(
      123456789.123456789.toByteArray,
      Array(65, -99, 111, 52, 84, 126, 107, 117): Array[Byte]
    )
  }

  test("DoubleSyntax.squared") {
    assertEquals(1.5.squared, 2.25)
  }
}
