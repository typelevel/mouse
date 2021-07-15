package mouse

import cats.data.{EitherNel, NonEmptyList, Validated, ValidatedNel}
import cats.{Applicative, ApplicativeError, Monoid}
import mouse.BooleanSyntax.LiftToPartiallyApplied

trait BooleanSyntax {
  implicit final def booleanSyntaxMouse(b: Boolean): BooleanOps = new BooleanOps(b)
}

class ApplyIfPartiallyApplied[A](b: Boolean, a: A) {
  @inline def apply[B >: A](f: B => B): B = if (b) f(a) else a
}

final class BooleanOps(private val b: Boolean) extends AnyVal {

  @inline def option[A](a: => A): Option[A] = fold(Some(a), None)

  @deprecated("Use `either` instead", "0.6")
  @inline def xor[L, R](l: => L, r: => R): Either[L, R] = either(l, r)

  @inline def either[L, R](l: => L, r: => R): Either[L, R] = fold(Right(r), Left(l))

  @inline def eitherNel[L, R](ifFalse: => L, ifTrue: => R): EitherNel[L, R] = either(NonEmptyList.one(ifFalse), ifTrue)

  @inline def validatedNel[L, R](ifFalse: => L, ifTrue: => R): ValidatedNel[L, R] =
    fold(Validated.validNel(ifTrue), Validated.invalidNel(ifFalse))

  @inline def fold[A](t: => A, f: => A): A = if (b) t else f

  @inline def valueOrZero[A](a: => A)(implicit M: Monoid[A]): A = if (b) a else M.empty

  @inline def zeroOrValue[A](a: => A)(implicit M: Monoid[A]): A = if (b) M.empty else a

  @inline def ??[A](a: => A)(implicit M: Monoid[A]): A = valueOrZero(a)

  @inline def !?[A](a: => A)(implicit M: Monoid[A]): A = zeroOrValue(a)

  @inline def valueOrPure[F[_], A](fa: => F[A])(a: => A)(implicit F: Applicative[F]) = if (b) fa else F.pure(a)

  @inline def applyIf[A](a: A): ApplyIfPartiallyApplied[A] = new ApplyIfPartiallyApplied[A](b, a)

  @inline def whenA[F[_], A](fa: F[A])(implicit F: Applicative[F]): F[Unit] = F.whenA(b)(fa)

  @inline def unlessA[F[_], A](fa: F[A])(implicit F: Applicative[F]): F[Unit] = F.unlessA(b)(fa)

  @inline def liftTo[F[_]]: LiftToPartiallyApplied[F] = new LiftToPartiallyApplied(b)

}

object BooleanSyntax {
  final private[mouse] class LiftToPartiallyApplied[F[_]](private val b: Boolean) extends AnyVal {
    def apply[E](ifFalse: => E)(implicit F: ApplicativeError[F, _ >: E]): F[Unit] =
      if (b) F.unit else F.raiseError(ifFalse)
  }
}
