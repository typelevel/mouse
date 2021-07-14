package mouse

class LongSyntaxTest extends MouseSuite {
  test("LongSyntax.toByteArray") {
    assertEquals(
      123456789123456789L.toByteArray,
      Array(1, -74, -101, 75, -84, -48, 95, 21): Array[Byte]
    )
  }

  test("LongSyntax.toBase64") {
    assertEquals(123456789123456789L.toBase64, "AbabS6zQXxU")
  }

  test("LongSyntax.squared") {
    assertEquals(7L.squared, 49L)
  }
}
