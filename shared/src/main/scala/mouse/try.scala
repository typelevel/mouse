package mouse

import cats.Applicative
import cats.data.EitherT

import scala.util.{Failure, Success, Try}

object `try`:
  extension [A, B] (ta: Try[A])
    @deprecated("Use `fold` instead", "1.0.0")
    @inline def cata(success: A => B, failure: Throwable => B): B = ta.fold(failure, success)

  //TODO migrate to extension method if partial application supported
  import scala.language.implicitConversions
  @inline implicit final def tryOps[A](ta: Try[A]): TryOps[A] = TryOps(ta)

  final class TryOps[A](private val ta: Try[A]) extends AnyVal:
    def toEitherT[F[_]: Applicative]: EitherT[F, Throwable, A] = EitherT.fromEither[F](ta.toEither)
