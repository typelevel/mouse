package mouse

trait AnySyntax {
  implicit final def anySyntaxMouse[A](oa: A): AnyOps[A] = new AnyOps(oa)
}

final class AnyOps[A](private val oa: A) extends AnyVal {
  @inline def |>[B] (f: A => B) = f(oa)
  @inline def thrush[B] (f: A => B) = f(oa)
  @inline def <|(f: A => Unit): A = {
    f(oa)
    oa
  }
  @inline def unsafeTap(f: A => Unit): A = {
    f(oa)
    oa
  }
}
