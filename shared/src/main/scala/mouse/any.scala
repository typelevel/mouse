package mouse

trait AnySyntax {
  implicit final def optionSyntaxMouse[A](oa: A): AnyOps[A] = new AnyOps(oa)
}

final class AnyOps[A](val oa: A) extends AnyVal {
  def |>[B] (f: A => B) = f(oa)
  def thrush[B] (f: A => B) = f(oa)
}
