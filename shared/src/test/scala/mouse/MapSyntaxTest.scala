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
