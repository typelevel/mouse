package mouse

import cats.{ Applicative, Monoid }

trait BooleanSyntax {
  implicit final def booleanSyntaxMouse(b: Boolean): BooleanOps = new BooleanOps(b)
}

class ApplyIfPartiallyApplied[A](b: Boolean, a: A) {
  @inline def apply[B >: A](f: B => B): B = if (b) f(a) else a
}

final class BooleanOps(private val b: Boolean) extends AnyVal {

  @inline def option[A](a: => A): Option[A] = fold(Some(a), None)

  @deprecated("Use `either` instead", "0.6")
  @inline def xor[L, R](l: =>L, r: =>R): Either[L, R] = either(l, r)

  @inline def either[L, R](l: =>L, r: =>R): Either[L, R] = fold(Right(r), Left(l))

  @inline def fold[A](t: => A, f: => A): A = if (b) t else f

  @inline def valueOrZero[A](a: => A)(implicit M: Monoid[A]): A = if (b) a else M.empty

  @inline def zeroOrValue[A](a: => A)(implicit M: Monoid[A]): A = if (b) M.empty else a

  @inline def ??[A](a: => A)(implicit M: Monoid[A]): A = valueOrZero(a)

  @inline def !?[A](a: => A)(implicit M: Monoid[A]): A = zeroOrValue(a)

  @inline def valueOrPure[F[_], A](fa: =>F[A])(a: =>A)(implicit F: Applicative[F]) = if (b) fa else F.pure(a)
  
  @inline def applyIf[A](a: A): ApplyIfPartiallyApplied[A] = new ApplyIfPartiallyApplied[A](b, a)
}
