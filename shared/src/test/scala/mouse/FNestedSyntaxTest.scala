package mouse

class FNestedSyntaxTest extends MouseSuite {
  private val listOption: List[Option[Int]] =
    List(Option(0), Option(1), Option(2))

  private val listListOption: List[List[Option[Int]]] =
    List(List(Option(0), Option(1), Option(2)), List.empty[Option[Int]])

  test("FNestedSyntax.mapNested2") {
    assertEquals(
      listOption.mapNested2(_ * 2),
      List(Option(0), Option(2), Option(4))
    )

    assertEquals(
      List.empty[Option[Int]].mapNested2(_ * 2),
      List.empty[Option[Int]]
    )

    assertEquals(
      listListOption.mapNested2(_.toList),
      List(List(List(0), List(1), List(2)), List.empty[List[Int]])
    )
  }

  test("FNestedSyntax.flatMapNested2") {
    assertEquals(
      listOption.flatMapNested2(x => Option(x * 2)),
      List(Option(0), Option(2), Option(4))
    )

    assertEquals(
      List.empty[Option[Int]].flatMapNested2(x => Option(x * 2)),
      List.empty[Option[Int]]
    )

    assertEquals(
      listListOption.flatMapNested2(x => List(x.toList)),
      List(List(List(0), List(1), List(2)), List.empty[List[Int]])
    )
  }

  test("FNestedSyntax.mapNested3") {
    val expected: List[List[Option[Int]]] =
      List(List(Option(0), Option(2), Option(4)), List.empty[Option[Int]])

    assertEquals(
      listListOption.mapNested3(_ * 2),
      expected
    )

    assertEquals(
      List.empty[List[Option[Int]]].mapNested3(_ * 2),
      List.empty[List[Option[Int]]]
    )
  }

  test("FNestedSyntax.flatMapNested3") {
    val expected: List[List[Option[Int]]] =
      List(List(Option(0), Option(2), Option(4)), List.empty[Option[Int]])

    assertEquals(
      listListOption.flatMapNested3(x => Option(x * 2)),
      expected
    )

    assertEquals(
      List.empty[List[Option[Int]]].flatMapNested3(x => Option(x * 2)),
      List.empty[List[Option[Int]]]
    )
  }
}
