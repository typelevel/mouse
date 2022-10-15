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
import cats.instances.either._
import cats.{Applicative, FlatMap, Functor, Monad, MonadError, MonadThrow, Traverse}

trait FEitherSyntax {
  implicit final def FEitherSyntaxMouse[F[_], L, R](felr: F[Either[L, R]]): FEitherOps[F, L, R] =
    new FEitherOps(felr)

  def asLeftF[F[_], L, R](left: => L)(implicit F: Applicative[F]): F[Either[L, R]] =
    F.pure(Left(left))

  def asRightF[F[_], L, R](right: => R)(implicit F: Applicative[F]): F[Either[L, R]] =
    F.pure(Right(right))
}

private[mouse] object FEitherSyntax extends FEitherSyntax

final class FEitherOps[F[_], L, R](private val felr: F[Either[L, R]]) extends AnyVal {
  def cata[A](left: L => A, right: R => A)(implicit F: Functor[F]): F[A] =
    F.map(felr)(_.fold(left, right))

  def cataF[A](left: L => F[A], right: R => F[A])(implicit F: FlatMap[F]): F[A] =
    F.flatMap(felr)(_.fold(left, right))

  def flatMapIn[A >: L, B](f: R => Either[A, B])(implicit F: Functor[F]): F[Either[A, B]] =
    F.map(felr)(_.flatMap(f))

  def flatMapF[A >: L, B](f: R => F[Either[A, B]])(implicit F: Monad[F]): F[Either[A, B]] =
    F.flatMap(felr) {
      case l @ Left(_)  => F.pure(l.asInstanceOf[Left[A, B]])
      case Right(value) => f(value)
    }

  def foldIn[A](left: L => A)(right: R => A)(implicit F: Functor[F]): F[A] =
    cata(left, right)

  def foldF[A](left: L => F[A])(right: R => F[A])(implicit F: FlatMap[F]): F[A] =
    cataF(left, right)

  def getOrElseIn[A >: R](right: => A)(implicit F: Functor[F]): F[A] =
    F.map(felr)(_.fold(_ => right, identity))

  def getOrRaise[E](e: => E)(implicit F: MonadError[F, _ >: E]): F[R] =
    getOrElseF(F.raiseError(e))

  def getOrRaiseMsg(msg: => String)(implicit F: MonadThrow[F]): F[R] =
    getOrRaise[Throwable](new RuntimeException(msg))

  def getOrElseF[A >: R](right: => F[A])(implicit F: Monad[F]): F[A] =
    F.flatMap(felr)(_.fold(_ => right, F.pure))

  def leftFlatMapIn[A, B >: R](f: L => Either[A, B])(implicit F: Functor[F]): F[Either[A, B]] =
    F.map(felr) {
      case Left(value)  => f(value)
      case r @ Right(_) => r.asInstanceOf[Right[A, B]]
    }

  def leftFlatMapF[A, B >: R](f: L => F[Either[A, B]])(implicit F: Monad[F]): F[Either[A, B]] =
    F.flatMap(felr) {
      case Left(left)   => f(left)
      case r @ Right(_) => F.pure(r.asInstanceOf[Right[A, B]])
    }

  def leftMapIn[A](f: L => A)(implicit F: Functor[F]): F[Either[A, R]] =
    F.map(felr) {
      case Left(value)  => Left(f(value))
      case r @ Right(_) => r.asInstanceOf[Right[A, R]]
    }

  def leftWidenIn[A >: L](implicit F: Functor[F]): F[Either[A, R]] =
    F.map(felr) {
      case l @ Left(_)  => l.asInstanceOf[Left[A, R]]
      case r @ Right(_) => r.asInstanceOf[Right[A, R]]
    }

  def leftTraverseIn[G[_], A](f: L => G[A])(implicit F: Functor[F], G: Applicative[G]): F[G[Either[A, R]]] =
    F.map(felr) {
      case Left(left)   => G.map(f(left))(Left(_))
      case r @ Right(_) => G.pure(r.asInstanceOf[Right[A, R]])
    }

  def leftTraverseF[G[_], A](f: L => G[A])(implicit F: Traverse[F], G: Applicative[G]): G[F[Either[A, R]]] =
    F.traverse(felr) {
      case Left(left)   => G.map(f(left))(Left(_))
      case r @ Right(_) => G.pure(r.asInstanceOf[Right[A, R]])
    }

  def mapIn[A](f: R => A)(implicit F: Functor[F]): F[Either[L, A]] =
    F.map(felr)(_.map(f))

  def bimapIn[A, B](left: L => A, right: R => B)(implicit F: Functor[F]): F[Either[A, B]] =
    F.map(felr) {
      case Left(value)  => Left(left(value))
      case Right(value) => Right(right(value))
    }

  def swapIn(implicit F: Functor[F]): F[Either[R, L]] =
    F.map(felr)(_.swap)

  def mergeIn[A >: L](implicit ev: R <:< A, F: Functor[F]): F[A] =
    F.map(felr)(_.fold(identity, ev))

  def orElseIn[A >: L, B >: R](f: => Either[A, B])(implicit F: Functor[F]): F[Either[A, B]] =
    F.map(felr) {
      case r: Right[L, R] => r: Either[A, B]
      case _              => f
    }

  def orElseF[A >: L, B >: R](f: => F[Either[A, B]])(implicit F: Monad[F]): F[Either[A, B]] =
    F.flatMap(felr) {
      case r: Right[L, R] => F.pure[Either[A, B]](r)
      case _              => f
    }

  def toOptionIn(implicit F: Functor[F]): F[Option[R]] =
    F.map(felr)(_.toOption)

  def traverseIn[G[_]: Applicative, A](f: R => G[A])(implicit F: Functor[F]): F[G[Either[L, A]]] =
    F.map(felr)(elr => catsStdInstancesForEither[L].traverse(elr)(f))

  def traverseF[G[_]: Applicative, A](f: R => G[A])(implicit F: Traverse[F]): G[F[Either[L, A]]] =
    F.traverse(felr)(elr => catsStdInstancesForEither[L].traverse(elr)(f))

  def liftEitherT: EitherT[F, L, R] =
    EitherT(felr)

  def widenIn[A >: R](implicit F: Functor[F]): F[Either[L, A]] =
    F.map(felr) {
      case l @ Left(_)  => l.asInstanceOf[Left[L, A]]
      case r @ Right(_) => r.asInstanceOf[Right[L, A]]
    }
}
