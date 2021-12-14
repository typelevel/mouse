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

  @inline def noneF[F[_]](implicit F: Applicative[F]): F[Option[A]] =
    FOptionSyntax.noneF[F, A]

  @inline def someF[F[_]](implicit F: Applicative[F]): F[Option[A]] =
    FOptionSyntax.someF[F, A](a)

  @inline def asLeftF[F[_], R](implicit F: Applicative[F]): F[Either[A, R]] =
    FEitherSyntax.asLeftF[F, A, R](a)

  @inline def asRightF[F[_], L](implicit F: Applicative[F]): F[Either[L, A]] =
    FEitherSyntax.asRightF[F, L, A](a)
}
