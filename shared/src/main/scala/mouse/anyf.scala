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

import cats.data.EitherT
import cats.data.OptionT
import cats.~>
import cats.Functor

trait AnyFSyntax {
  implicit final def anyfSyntaxMouse[F[_], A](fa: F[A]): AnyFOps[F, A] = new AnyFOps(fa)
}

final class AnyFOps[F[_], A](private val fa: F[A]) extends AnyVal {
  @inline def ||>[G[_]](f: F ~> G): G[A] = f(fa)
  @inline def thrushK[G[_]](f: F ~> G): G[A] = f(fa)

  def mapAsRight[L](implicit F: Functor[F]): F[Either[L, A]] =
    Functor[F].map(fa)(Right(_))

  def mapAsLeft[R](implicit F: Functor[F]): F[Either[A, R]] =
    Functor[F].map(fa)(Left(_))

  def mapAsSome(implicit F: Functor[F]): F[Option[A]] =
    Functor[F].map(fa)(Some(_))

  def liftEitherT[E](implicit F: Functor[F]): EitherT[F, E, A] =
    EitherT.right[E](fa)

  def liftOptionT(implicit F: Functor[F]): OptionT[F, A] =
    OptionT.liftF(fa)

}
