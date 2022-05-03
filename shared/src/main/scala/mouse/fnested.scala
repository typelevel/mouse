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

import cats.{FlatMap, Functor}

trait FNestedSyntax {
  implicit final def fnested2SyntaxMouse[F[_], G[_], A](fga: F[G[A]]): FNested2SyntaxOps[F, G, A] =
    new FNested2SyntaxOps[F, G, A](fga)

  implicit final def fnested3SyntaxMouse[F[_], G[_], H[_], A](fgha: F[G[H[A]]]): FNested3SyntaxOps[F, G, H, A] =
    new FNested3SyntaxOps[F, G, H, A](fgha)
}

final class FNested2SyntaxOps[F[_], G[_], A](private val fga: F[G[A]]) extends AnyVal {
  def mapNested2[B](f: A => B)(implicit F: Functor[F], G: Functor[G]): F[G[B]] =
    F.map(fga)(ga => G.map(ga)(f))

  def flatMapNested2[B](f: A => G[B])(implicit F: Functor[F], G: FlatMap[G]): F[G[B]] =
    F.map(fga)(ga => G.flatMap(ga)(f))
}

final class FNested3SyntaxOps[F[_], G[_], H[_], A](private val fgha: F[G[H[A]]]) extends AnyVal {
  def mapNested3[B](f: A => B)(implicit F: Functor[F], G: Functor[G], H: Functor[H]): F[G[H[B]]] =
    F.map(fgha)(gha => G.map(gha)(ha => H.map(ha)(f)))

  def flatMapNested3[B](f: A => H[B])(implicit F: Functor[F], G: Functor[G], H: FlatMap[H]): F[G[H[B]]] =
    F.map(fgha)(gha => G.map(gha)(ha => H.flatMap(ha)(f)))
}
