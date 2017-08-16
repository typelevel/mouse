package mouse

trait BooleanSyntax {
  implicit final def booleanSyntaxMouse(b: Boolean): BooleanOps = new BooleanOps(b)
}

final class BooleanOps(val b: Boolean) extends AnyVal {

  @inline final def option[A](a: => A): Option[A] = fold(Some(a), None)

  @deprecated("Use `either` instead", "0.6")
  @inline final def xor[L, R](l: =>L, r: =>R): Either[L, R] = either(l, r)

  @inline final def either[L, R](l: =>L, r: =>R): Either[L, R] = fold(Right(r), Left(l))

  @inline final def fold[A](t: => A, f: => A): A = if (b) t else f

}
