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

import cats.Applicative
import cats.data.EitherT

import scala.util.{Failure, Success, Try}

trait TrySyntax {
  @inline implicit final def trySyntaxMouse[A](ta: Try[A]): TryOps[A] = new TryOps(ta)
}

final class TryOps[A](private val ta: Try[A]) extends AnyVal {

  @inline def cata[B](success: A => B, failure: Throwable => B): B = ta match {
    case Success(value) => success(value)
    case Failure(error) => failure(error)
  }

  @inline def toEither: Either[Throwable, A] = cata[Either[Throwable, A]](Right(_), Left(_))

  /**
   * Converts a `Try[A]` to a `EitherT[F, Throwable, A]`.
   */
  @inline def toEitherT[F[_]](implicit F: Applicative[F]): EitherT[F, Throwable, A] =
    EitherT.fromEither[F](toEither)
}
