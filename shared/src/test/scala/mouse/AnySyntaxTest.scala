/*
 * Copyright (c) 2022 Typelevel
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

class AnySyntaxTest extends MouseSuite with MouseFunctions {
  test("AnySyntax.|>") {
    assertEquals(true |> (!_), false)

    assertEquals(5 |> (_ + 44), 49)

    assertEquals(Some("thing") |> (_.getOrElse("that")), "thing")

    assertEquals(
      "This" |> Function.const("that") |> (_.capitalize) |> Function.const("at bat"),
      "at bat"
    )

    assertEquals(ignore(true), ())

    assertEquals(1200 |> (_ * 2) |> (_ - 5) |> (_ / 3), ((1200 * 2) - 5) / 3)

    assertEquals("anythingAtAll" |> ignore, ())
  }

  test("AnySyntax.someF") {
    assertEquals(42.someF[List], List(Option(42)))
  }

  test("AnySyntax.asLeftF") {
    assertEquals("".asLeftF[List, Int], List(Left("")))
  }

  test("AnySyntax.asRightF") {
    assertEquals(42.asRightF[List, String], List(Right(42)))
  }
}
