package mouse

import cats.data.EitherT
import cats.data.OptionT
import cats.{Applicative, FlatMap, Functor, Monad, Traverse}

trait FOptionSyntax {
  implicit final def FOptionSyntaxMouse[F[_], A](foa: F[Option[A]]): FOptionOps[F, A] = new FOptionOps(foa)
}

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

  def getOrElseF[B >: A](fa: => F[B])(implicit F: Monad[F]): F[B] =
    F.flatMap(foa)(_.fold(fa)(F.pure))

  def mapIn[B](f: A => B)(implicit F: Functor[F]): F[Option[B]] =
    F.map(foa)(_.map(f))

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

  def traverseIn[G[_]: Applicative, B](f: A => G[B])(implicit F: Functor[F]): F[G[Option[B]]] =
    F.map(foa)(a => Traverse[Option].traverse(a)(f))

  def traverseF[G[_]: Applicative, B](f: A => G[B])(implicit F: Traverse[F]): G[F[Option[B]]] =
    F.traverse(foa)(a => Traverse[Option].traverse(a)(f))

  def liftOptionT: OptionT[F, A] =
    OptionT(foa)

  def liftEitherT[E](ifNone: => E)(implicit F: Functor[F]): EitherT[F, E, A] =
    EitherT.fromOptionF(foa, ifNone)
}
