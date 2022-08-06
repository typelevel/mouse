package mouse

class ListSyntaxTest extends MouseSuite {
  test("ListSyntax.tailOrEmpty") {
    assertEquals(List.empty[Int].tailOrEmpty, List.empty[Int])
    assertEquals(List(0).tailOrEmpty, List.empty[Int])
    assertEquals(List(0, 1, 2).tailOrEmpty, List(1, 2))
  }

  test("ListSyntax.tailOption") {
    assertEquals(List.empty[Int].tailOption, Option.empty[List[Int]])
    assertEquals(List(0).tailOption, Option.empty[List[Int]])
    assertEquals(List(0, 1, 2).tailOption, Some(List(1, 2)))
  }
}
