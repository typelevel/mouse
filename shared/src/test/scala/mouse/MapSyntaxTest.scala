package mouse

class MapSyntaxTest extends MouseSuite {
  test("MapSyntax.mapKeys") {
    assertEquals(Map(1 -> 2, 3 -> 4).mapKeys(_ * 2), Map(2 -> 2, 6 -> 4))
    assertEquals(Map(1 -> 2, 3 -> 4).mapKeys(identity), Map(1 -> 2, 3 -> 4))
    assertEquals(Map[Int, Int]().mapKeys(identity), Map[Int, Int]())
  }

  test("MapSyntax.updateAtKey") {
    assertEquals(Map(1 -> 2, 3 -> 4).updateAtKey(3, _ * 2), Map(1 -> 2, 3 -> 8))
    assertEquals(Map(1 -> 2, 3 -> 4).updateAtKey(42, _ * 2), Map(1 -> 2, 3 -> 4))
    assertEquals(Map(1 -> 2, 3 -> 4).updateAtKey(3, identity), Map(1 -> 2, 3 -> 4))
  }

  test("MapSyntax.updateAtKeyCombine") {
    assertEquals(Map(1 -> 2, 3 -> 4).updateAtKeyCombine(3, 5), Map(1 -> 2, 3 -> 9))
    assertEquals(Map(1 -> 2, 3 -> 4).updateAtKeyCombine(42, 5), Map(1 -> 2, 3 -> 4, 42 -> 5))
  }

  test("MapSyntax.updateAtKeyF") {
    assertEquals(Map(1 -> 2, 3 -> 4).updateAtKeyF(3, Option(_)), Some(Map(1 -> 2, 3 -> 4)))
    assertEquals(Map(1 -> 2, 3 -> 4).updateAtKeyF(3, i => Option(i * 2)), Some(Map(1 -> 2, 3 -> 8)))
    assertEquals(Map(1 -> 2, 3 -> 4).updateAtKeyF(42, Option(_)), Some(Map(1 -> 2, 3 -> 4)))
  }
}
