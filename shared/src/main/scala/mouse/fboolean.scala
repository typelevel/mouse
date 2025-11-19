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

import cats.{Functor, Monad}

trait FBooleanSyntax {
  implicit final def FBooleanSyntaxMouse[F[_]](fBoolean: F[Boolean]): FBooleanOps[F] =
    new FBooleanOps[F](fBoolean)
}

final class FBooleanOps[F[_]](private val fBoolean: F[Boolean]) extends AnyVal {

  /**
   * Transforms this `F[Boolean]` by negating the `Boolean`
   */
  def not(implicit F: Functor[F]): F[Boolean] =
    F.map(fBoolean)(b => !b)

  /**
   * Behaves like `&&` but inside the `F` context.
   *
   * Wont evaluate `other` unless this evaluates to `true`
   */
  def andM(other: => F[Boolean])(implicit F: Monad[F]): F[Boolean] =
    F.flatMap(fBoolean) {
      case false => F.pure(false)
      case true  => other
    }

  /**
   * Behaves like `||` but inside the `F` context.
   *
   * Wont evaluate `other` unless this evaluates to `false`
   */
  def orM(other: => F[Boolean])(implicit F: Monad[F]): F[Boolean] =
    F.flatMap(fBoolean) {
      case true  => F.pure(true)
      case false => other
    }

  /**
   * Evaluates the given effect if the boolean is `true`.
   *
   * Wont evaluate `f` unless this evaluates to `true`.
   */
  def whenA[A](f: => F[A])(implicit F: Monad[F]): F[Unit] = F.flatMap(fBoolean) {
    case true  => F.void(f)
    case false => F.unit
  }

  /**
   * Evaluates the given effect if the boolean is `false`.
   *
   * Wont evaluate `f` unless this evaluates to `false`.
   */
  def unlessA[A](f: => F[A])(implicit F: Monad[F]): F[Unit] = F.flatMap(fBoolean) {
    case true  => F.unit
    case false => F.void(f)
  }

}
