package mouse


object any:
  extension [A](oa: A)
    @inline def <|(f: A => Unit): A =
      f(oa)
      oa

    @inline def unsafeTap(f: A => Unit): A =
      f(oa)
      oa

  extension [A, B](oa: A)
    @inline def |>(f: A => B) = f(oa)
    @inline def thrush(f: A => B) = f(oa)
