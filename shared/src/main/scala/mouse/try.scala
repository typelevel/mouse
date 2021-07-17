package mouse

import cats.Applicative
import cats.data.EitherT

import scala.util.{Failure, Success, Try}

trait TrySyntax {
  @inline implicit final def trySyntaxMouse[A](ta: Try[A]): TryOps[A] = new TryOps(ta)
}

final class TryOps[A](private val ta: Try[A]) extends AnyVal {

  @inline def cata[B](success: A => B, failure: Throwable => B): B = ta match {
    case Success(value) => success(value)
    case Failure(error) => failure(error)
  }

  @inline def toEither: Either[Throwable, A] = cata[Either[Throwable, A]](Right(_), Left(_))

  /**
   * Converts a `Try[A]` to a `EitherT[F, Throwable, A]`.
   */
  @inline def toEitherT[F[_]](implicit F: Applicative[F]): EitherT[F, Throwable, A] =
    EitherT.fromEither[F](toEither)
}
