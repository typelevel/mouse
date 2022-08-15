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

import scala.util.{Failure, Success, Try}

trait OptionSyntax {
  implicit final def optionSyntaxMouse[A](oa: Option[A]): OptionOps[A] = new OptionOps(oa)
}

final class OptionOps[A](private val oa: Option[A]) extends AnyVal {

  @inline def cata[B](some: A => B, none: => B): B = oa.fold[B](none)(some)

  @inline def toTry(ex: => Throwable): Try[A] = cata(Success(_), Failure(ex))

  @inline def toTryMsg(msg: => String): Try[A] = toTry(new RuntimeException(msg))

  /**
   * Same as oa.toRight except that it fixes the type to Either[B, A] On Scala prior to 2.12, toRight returns
   * `Serializable with Product with Either[B, A]`
   */
  @deprecated("Use toRight instead", "1.2.0")
  @inline def right[B](b: => B): Either[B, A] = oa.toRight(b)

  /**
   * Same as oa.toLeft except that it fixes the type to Either[A, B] On Scala prior to 2.12, toLeft returns
   * `Serializable with Product with Either[A, B]`
   */
  @deprecated("Use toLeft instead", "1.2.0")
  @inline def left[B](b: => B): Either[A, B] = oa.toLeft(b)
}
