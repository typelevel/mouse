package mouse

trait BooleanSyntax {
  implicit final def booleanSyntaxMouse(b: Boolean): BooleanOps = new BooleanOps(b)
}

final class BooleanOps(val b: Boolean) extends AnyVal {

  final def option[A](a: => A): Option[A] = fold(Some(a), None)

  @deprecated("Use `either` instead", "0.6")
  final def xor[L, R](l: =>L, r: =>R): Either[L, R] = either(l, r)

  final def either[L, R](l: =>L, r: =>R): Either[L, R] = fold(Right(r), Left(l))

  final def fold[A](t: => A, f: => A): A = if (b) t else f

}