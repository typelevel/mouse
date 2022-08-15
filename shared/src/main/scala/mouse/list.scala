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

import cats.data.NonEmptyList

trait ListSyntax {
  implicit final def listSyntaxMouse[A](list: List[A]): ListOps[A] = new ListOps[A](list)
}

final class ListOps[A](private val list: List[A]) extends AnyVal {

  /**
   * A safe counterpart to [[List.tail]] that returns `Nil` for an empty list.
   */
  @inline def tailOrEmpty: List[A] = list.drop(1)

  /**
   * Returns `Some` if the tail is non-empty, otherwise `None`.
   */
  @inline def tailOption: Option[NonEmptyList[A]] = NonEmptyList.fromList(list.drop(1))

}
