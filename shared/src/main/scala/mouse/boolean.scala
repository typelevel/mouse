package mouse

trait BooleanSyntax {
  implicit final def booleanSyntaxMouse(b: Boolean): BooleanOps = new BooleanOps(b)
}

final class BooleanOps(val b: Boolean) extends AnyVal {

  def option[A](a: => A): Option[A] = if (b) Some(a) else None

  @deprecated("Use `either` instead", "0.6")
  def xor[L, R](l: =>L, r: =>R): Either[L, R] = either(l, r)

  def either[L, R](l: =>L, r: =>R): Either[L, R] = if (b) Right(r) else Left(l)

  def fold[A](t: => A, f: => A): A = if (b) t else f

}