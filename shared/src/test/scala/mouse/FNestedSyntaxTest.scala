/*
 * Copyright (c) 2016 Typelevel
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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
