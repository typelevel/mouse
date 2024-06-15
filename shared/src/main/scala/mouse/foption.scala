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
import cats.{Applicative, FlatMap, Functor, Monad, MonadError, MonadThrow, Traverse}

trait FOptionSyntax {
  implicit final def FOptionSyntaxMouse[F[_], A](foa: F[Option[A]]): FOptionOps[F, A] = new FOptionOps(foa)

  def noneF[F[_], A](implicit F: Applicative[F]): F[Option[A]] =
    F.pure(None)

  def someF[F[_], A](a: => A)(implicit F: Applicative[F]): F[Option[A]] =
    F.pure(Some(a))
}

private[mouse] object FOptionSyntax extends FOptionSyntax

final class FOptionOps[F[_], A](private val foa: F[Option[A]]) extends AnyVal {

  def cata[B](default: => B, f: A => B)(implicit F: Functor[F]): F[B] =
    F.map(foa)(_.fold(default)(f))

  def cataF[B](default: => F[B], f: A => F[B])(implicit F: FlatMap[F]): F[B] =
    F.flatMap(foa)(_.fold(default)(f))

  def existsIn(f: A => Boolean)(implicit F: Functor[F]): F[Boolean] =
    F.map(foa)(_.exists(f))

  def existsF(f: A => F[Boolean])(implicit F: Monad[F]): F[Boolean] =
    F.flatMap(foa) {
      case None    => F.pure(false)
      case Some(a) => f(a)
    }

  def filterIn(f: A => Boolean)(implicit F: Functor[F]): F[Option[A]] =
    F.map(foa)(_.filter(f))

  def filterF(f: A => F[Boolean])(implicit F: Monad[F]): F[Option[A]] =
    F.flatMap(foa) {
      case None => F.pure(None)
      case s @ Some(v) =>
        F.map(f(v)) {
          case true => s
          case _    => None
        }
    }

  def flatMapIn[B](f: A => Option[B])(implicit F: Functor[F]): F[Option[B]] =
    F.map(foa)(_.flatMap(f))

  def flatMapF[B](f: A => F[Option[B]])(implicit F: Monad[F]): F[Option[B]] =
    F.flatMap(foa)(_.fold(F.pure(Option.empty[B]))(f))

  def foldIn[B](default: => B)(f: A => B)(implicit F: Functor[F]): F[B] =
    cata(default, f)

  def foldF[B](default: => F[B])(f: A => F[B])(implicit F: FlatMap[F]): F[B] =
    cataF(default, f)

  def forallIn(f: A => Boolean)(implicit F: Functor[F]): F[Boolean] =
    F.map(foa)(_.forall(f))

  def forallF(f: A => F[Boolean])(implicit F: Monad[F]): F[Boolean] =
    F.flatMap(foa) {
      case None    => F.pure(true)
      case Some(a) => f(a)
    }

  def getOrElse[B >: A](a: => B)(implicit F: Functor[F]): F[B] =
    F.map(foa)(_.fold(a)(identity))

  def getOrRaise[E](e: => E)(implicit F: MonadError[F, _ >: E]): F[A] =
    getOrElseF(F.raiseError(e))

  def getOrRaiseMsg(msg: => String)(implicit F: MonadThrow[F]): F[A] =
    getOrRaise(new RuntimeException(msg))

  def getOrElseF[B >: A](fa: => F[B])(implicit F: Monad[F]): F[B] =
    F.flatMap(foa)(_.fold(fa)(F.pure))

  def mapIn[B](f: A => B)(implicit F: Functor[F]): F[Option[B]] =
    F.map(foa)(_.map(f))

  def mapOrKeepIn[B >: A](pf: PartialFunction[A, B])(implicit F: Functor[F]): F[Option[B]] =
    F.map(foa)(_.map(a => pf.applyOrElse(a, identity[B])))

  def asIn[B](b: => B)(implicit F: Functor[F]): F[Option[B]] =
    mapIn(_ => b)

  def voidIn(implicit F: Functor[F]): F[Option[Unit]] =
    asIn(())

  def orElseIn(default: Option[A])(implicit F: Functor[F]): F[Option[A]] =
    F.map(foa) {
      case None => default
      case x    => x
    }

  def orElseF(defaultF: => F[Option[A]])(implicit F: Monad[F]): F[Option[A]] =
    F.flatMap(foa) {
      case None => defaultF
      case x    => F.pure(x)
    }

  def toLeftIn[R](right: => R)(implicit F: Functor[F]): F[Either[A, R]] =
    F.map(foa) {
      case None    => Right(right)
      case Some(a) => Left(a)
    }

  def toLeftInF[R](right: => F[R])(implicit F: Monad[F]): F[Either[A, R]] =
    F.flatMap(foa) {
      case None    => F.map(right)(Right(_))
      case Some(a) => F.pure(Left(a))
    }

  def toRightIn[L](left: => L)(implicit F: Functor[F]): F[Either[L, A]] =
    F.map(foa) {
      case None    => Left(left)
      case Some(a) => Right(a)
    }

  def toRightInF[L](left: => F[L])(implicit F: Monad[F]): F[Either[L, A]] =
    F.flatMap(foa) {
      case None    => F.map(left)(Left(_))
      case Some(a) => F.pure(Right(a))
    }

  def traverseIn[G[_]: Applicative, B](f: A => G[B])(implicit F: Functor[F]): F[G[Option[B]]] =
    F.map(foa)(a => Traverse[Option].traverse(a)(f))

  def traverseF[G[_]: Applicative, B](f: A => G[B])(implicit F: Traverse[F]): G[F[Option[B]]] =
    F.traverse(foa)(a => Traverse[Option].traverse(a)(f))

  def liftOptionT: OptionT[F, A] =
    OptionT(foa)

  def liftEitherT[E](ifNone: => E)(implicit F: Functor[F]): EitherT[F, E, A] =
    EitherT.fromOptionF(foa, ifNone)
}
