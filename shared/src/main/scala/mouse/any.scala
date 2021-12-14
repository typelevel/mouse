package mouse

import cats.Applicative

trait AnySyntax {
  implicit final def anySyntaxMouse[A](oa: A): AnyOps[A] = new AnyOps(oa)
}

final class AnyOps[A](private val oa: A) extends AnyVal {
  @inline def |>[B](f: A => B) = f(oa)

  @inline def thrush[B](f: A => B) = f(oa)

  @inline def <|(f: A => Unit): A = {
    f(oa)
    oa
  }

  @inline def unsafeTap(f: A => Unit): A = {
    f(oa)
    oa
  }

  @inline def noneF[F[_]](implicit F: Applicative[F]): F[Option[A]] =
    FOptionSyntax.noneF[F, A]

  @inline def someF[F[_]](implicit F: Applicative[F]): F[Option[A]] =
    FOptionSyntax.someF[F, A](oa)
}
