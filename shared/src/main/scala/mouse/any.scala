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

import cats.Applicative

trait AnySyntax {
  implicit final def anySyntaxMouse[A](oa: A): AnyOps[A] = new AnyOps(oa)
}

final class AnyOps[A](private val a: A) extends AnyVal {
  @inline def |>[B](f: A => B): B = f(a)

  @inline def thrush[B](f: A => B): B = f(a)

  @inline def <|(f: A => Unit): A = {
    f(a)
    a
  }

  @inline def unsafeTap(f: A => Unit): A = {
    f(a)
    a
  }

  @inline def someF[F[_]](implicit F: Applicative[F]): F[Option[A]] =
    FOptionSyntax.someF[F, A](a)

  @inline def asLeftF[F[_], R](implicit F: Applicative[F]): F[Either[A, R]] =
    FEitherSyntax.asLeftF[F, A, R](a)

  @inline def asRightF[F[_], L](implicit F: Applicative[F]): F[Either[L, A]] =
    FEitherSyntax.asRightF[F, L, A](a)
}
