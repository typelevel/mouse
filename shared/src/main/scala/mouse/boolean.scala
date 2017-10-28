package mouse

import cats.Monoid

trait BooleanSyntax {
  implicit final def booleanSyntaxMouse(b: Boolean): BooleanOps = new BooleanOps(b)
}

final class BooleanOps(val b: Boolean) extends AnyVal {

  @inline final def option[A](a: => A): Option[A] = fold(Some(a), None)

  @deprecated("Use `either` instead", "0.6")
  @inline final def xor[L, R](l: =>L, r: =>R): Either[L, R] = either(l, r)

  @inline final def either[L, R](l: =>L, r: =>R): Either[L, R] = fold(Right(r), Left(l))

  @inline final def fold[A](t: => A, f: => A): A = if (b) t else f

  @inline final def valueOrZero[A](a: => A)(implicit M: Monoid[A]): A = if (b) a else M.empty

  @inline final def zeroOrValue[A](a: => A)(implicit M: Monoid[A]): A = if (b) M.empty else a

  @inline final def ??[A](a: => A)(implicit M: Monoid[A]): A = valueOrZero(a)

  @inline final def !?[A](a: => A)(implicit M: Monoid[A]): A = zeroOrValue(a)
}
