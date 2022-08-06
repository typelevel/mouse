package mouse

class SetSyntaxTest extends MouseSuite {
  test("SetSyntax.tailOrEmpty") {
    assertEquals(Set.empty[Int].tailOrEmpty, Set.empty[Int])
    assertEquals(Set(0).tailOrEmpty, Set.empty[Int])
    assertEquals(Set(0, 1, 2).tailOrEmpty, Set(1, 2))
  }

  test("SetSyntax.tailOption") {
    assertEquals(Set.empty[Int].tailOption, Option.empty[Set[Int]])
    assertEquals(Set(0).tailOption, Option.empty[Set[Int]])
    assertEquals(Set(0, 1, 2).tailOption, Some(Set(1, 2)))
  }
}
