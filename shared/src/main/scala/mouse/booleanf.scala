package mouse

import cats.{Applicative, Functor, Monad}

trait BooleanFSyntax {

  implicit final def booleanfSyntaxMouse[F[_]](fa: F[Boolean]): BooleanFOps[F] = new BooleanFOps(fa)
}

final class BooleanFOps[F[_]](private val fa: F[Boolean]) extends AnyVal {

  def &&(fb: => F[Boolean])(implicit F: Monad[F]): F[Boolean] =
    F.flatMap(fa) {
      case true => fb
      case false => F.pure(false)
    }

  def &&(b: => Boolean)(implicit F: Functor[F]): F[Boolean] =
    F.map(fa) {
      case true => b
      case false => false
    }

  def ||(fb: => F[Boolean])(implicit F: Monad[F]): F[Boolean] =
    F.flatMap(fa) {
      case true => F.pure(true)
      case false => fb
    }

  def ||(b: => Boolean)(implicit F: Functor[F]): F[Boolean] =
    F.map(fa) {
      case true => true
      case false => b
    }

  def &(fb: F[Boolean])(implicit F: Applicative[F]): F[Boolean] =
    F.ap(F.map(fa)(a => b => a && b))(fb)

  def &(b: Boolean)(implicit F: Functor[F]): F[Boolean] =
    F.map(fa)(_ && b)

  def |(fb: F[Boolean])(implicit F: Applicative[F]): F[Boolean] =
    F.ap(F.map(fa)(a => b => a || b))(fb)

  def |(b: Boolean)(implicit F: Functor[F]): F[Boolean] =
    F.map(fa)(_ || b)

  def ^(fb: F[Boolean])(implicit F: Monad[F]): F[Boolean] =
    F.flatMap(fa) { a =>
      F.flatMap(fb) { b => F.pure(a ^ b) }
    }

  def ^(b: Boolean)(implicit F: Functor[F]): F[Boolean] =
    F.map(fa) { _ ^ b }

  def unary_!(implicit F: Functor[F]): F[Boolean] =
    F.map(fa)(!_)
}
