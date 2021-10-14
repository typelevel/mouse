package mouse

trait TupleSyntax {
  implicit final def Tuple2SyntaxMouse[A1, A2](t: (A1, A2)): Tuple2SyntaxOps[A1, A2] =
    new Tuple2SyntaxOps(t)

  implicit final def Tuple3SyntaxMouse[A1, A2, A3](t: (A1, A2, A3)): Tuple3SyntaxOps[A1, A2, A3] =
    new Tuple3SyntaxOps(t)

  implicit final def Tuple4SyntaxMouse[A1, A2, A3, A4](t: (A1, A2, A3, A4)): Tuple4SyntaxOps[A1, A2, A3, A4] =
    new Tuple4SyntaxOps(t)

  implicit final def Tuple5SyntaxMouse[A1, A2, A3, A4, A5](
    t: (A1, A2, A3, A4, A5)
  ): Tuple5SyntaxOps[A1, A2, A3, A4, A5] = new Tuple5SyntaxOps(t)

  implicit final def Tuple6SyntaxMouse[A1, A2, A3, A4, A5, A6](
    t: (A1, A2, A3, A4, A5, A6)
  ): Tuple6SyntaxOps[A1, A2, A3, A4, A5, A6] = new Tuple6SyntaxOps(t)

  implicit final def Tuple7SyntaxMouse[A1, A2, A3, A4, A5, A6, A7](
    t: (A1, A2, A3, A4, A5, A6, A7)
  ): Tuple7SyntaxOps[A1, A2, A3, A4, A5, A6, A7] = new Tuple7SyntaxOps(t)

  implicit final def Tuple8SyntaxMouse[A1, A2, A3, A4, A5, A6, A7, A8](
    t: (A1, A2, A3, A4, A5, A6, A7, A8)
  ): Tuple8SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8] = new Tuple8SyntaxOps(t)

  implicit final def Tuple9SyntaxMouse[A1, A2, A3, A4, A5, A6, A7, A8, A9](
    t: (A1, A2, A3, A4, A5, A6, A7, A8, A9)
  ): Tuple9SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9] = new Tuple9SyntaxOps(t)

  implicit final def Tuple10SyntaxMouse[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](
    t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)
  ): Tuple10SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10] = new Tuple10SyntaxOps(t)

  implicit final def Tuple11SyntaxMouse[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](
    t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)
  ): Tuple11SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11] = new Tuple11SyntaxOps(t)

  implicit final def Tuple12SyntaxMouse[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](
    t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)
  ): Tuple12SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12] = new Tuple12SyntaxOps(t)

  implicit final def Tuple13SyntaxMouse[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](
    t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)
  ): Tuple13SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13] = new Tuple13SyntaxOps(t)

  implicit final def Tuple14SyntaxMouse[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](
    t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)
  ): Tuple14SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14] = new Tuple14SyntaxOps(t)

  implicit final def Tuple15SyntaxMouse[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](
    t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)
  ): Tuple15SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15] = new Tuple15SyntaxOps(t)

  implicit final def Tuple16SyntaxMouse[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](
    t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)
  ): Tuple16SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16] = new Tuple16SyntaxOps(t)

  implicit final def Tuple17SyntaxMouse[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](
    t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)
  ): Tuple17SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17] = new Tuple17SyntaxOps(t)

  // format: off
  implicit final def Tuple18SyntaxMouse[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](
    t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)
  ): Tuple18SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18] = new Tuple18SyntaxOps(t)

  implicit final def Tuple19SyntaxMouse[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](
    t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)
  ): Tuple19SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19] = new Tuple19SyntaxOps(t)

  implicit final def Tuple20SyntaxMouse[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](
    t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)
  ): Tuple20SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20] = new Tuple20SyntaxOps(t)

  implicit final def Tuple21SyntaxMouse[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](
    t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)
  ): Tuple21SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21] = new Tuple21SyntaxOps(t)

  implicit final def Tuple22SyntaxMouse[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22](
    t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22)
  ): Tuple22SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22] = new Tuple22SyntaxOps(t)
  // format: on
}

final class Tuple2SyntaxOps[A1, A2](private val t: (A1, A2)) extends AnyVal {
  @inline def head: A1 = t._1
  @inline def last: A2 = t._2
}

final class Tuple3SyntaxOps[A1, A2, A3](private val t: (A1, A2, A3)) extends AnyVal {
  @inline def head: A1 = t._1
  def init: (A1, A2) = (t._1, t._2)
  @inline def last: A3 = t._3
  def tail: (A2, A3) = (t._2, t._3)
}

final class Tuple4SyntaxOps[A1, A2, A3, A4](private val t: (A1, A2, A3, A4)) extends AnyVal {
  @inline def head: A1 = t._1
  def init: (A1, A2, A3) = (t._1, t._2, t._3)
  @inline def last: A4 = t._4
  def tail: (A2, A3, A4) = (t._2, t._3, t._4)
}

final class Tuple5SyntaxOps[A1, A2, A3, A4, A5](private val t: (A1, A2, A3, A4, A5)) extends AnyVal {
  @inline def head: A1 = t._1
  def init: (A1, A2, A3, A4) = (t._1, t._2, t._3, t._4)
  @inline def last: A5 = t._5
  def tail: (A2, A3, A4, A5) = (t._2, t._3, t._4, t._5)
}

final class Tuple6SyntaxOps[A1, A2, A3, A4, A5, A6](private val t: (A1, A2, A3, A4, A5, A6)) extends AnyVal {
  @inline def head: A1 = t._1
  def init: (A1, A2, A3, A4, A5) = (t._1, t._2, t._3, t._4, t._5)
  @inline def last: A6 = t._6
  def tail: (A2, A3, A4, A5, A6) = (t._2, t._3, t._4, t._5, t._6)
}

final class Tuple7SyntaxOps[A1, A2, A3, A4, A5, A6, A7](private val t: (A1, A2, A3, A4, A5, A6, A7)) extends AnyVal {
  @inline def head: A1 = t._1
  def init: (A1, A2, A3, A4, A5, A6) = (t._1, t._2, t._3, t._4, t._5, t._6)
  @inline def last: A7 = t._7
  def tail: (A2, A3, A4, A5, A6, A7) = (t._2, t._3, t._4, t._5, t._6, t._7)
}

final class Tuple8SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8](private val t: (A1, A2, A3, A4, A5, A6, A7, A8))
    extends AnyVal {
  @inline def head: A1 = t._1
  def init: (A1, A2, A3, A4, A5, A6, A7) = (t._1, t._2, t._3, t._4, t._5, t._6, t._7)
  @inline def last: A8 = t._8
  def tail: (A2, A3, A4, A5, A6, A7, A8) = (t._2, t._3, t._4, t._5, t._6, t._7, t._8)
}

final class Tuple9SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9](private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9))
    extends AnyVal {
  @inline def head: A1 = t._1
  def init: (A1, A2, A3, A4, A5, A6, A7, A8) = (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8)
  @inline def last: A9 = t._9
  def tail: (A2, A3, A4, A5, A6, A7, A8, A9) = (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9)
}

final class Tuple10SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)
) extends AnyVal {
  @inline def head: A1 = t._1
  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9) = (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9)
  @inline def last: A10 = t._10
  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10) = (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10)
}

final class Tuple11SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)
) extends AnyVal {
  @inline def head: A1 = t._1
  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) = (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10)
  @inline def last: A11 = t._11
  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) = (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11)
}

final class Tuple12SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)
) extends AnyVal {
  @inline def head: A1 = t._1
  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11)
  @inline def last: A12 = t._12
  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) =
    (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12)
}

final class Tuple13SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)
) extends AnyVal {
  @inline def head: A1 = t._1
  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12)
  @inline def last: A13 = t._13
  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) =
    (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13)
}

final class Tuple14SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)
) extends AnyVal {
  @inline def head: A1 = t._1
  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13)
  @inline def last: A14 = t._14
  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) =
    (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14)
}

final class Tuple15SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)
) extends AnyVal {
  @inline def head: A1 = t._1
  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14)
  @inline def last: A15 = t._15
  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) =
    (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15)
}

final class Tuple16SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)
) extends AnyVal {
  @inline def head: A1 = t._1
  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15)
  @inline def last: A16 = t._16
  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) =
    (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16)
}

final class Tuple17SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)
) extends AnyVal {
  @inline def head: A1 = t._1
  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16)
  @inline def last: A17 = t._17
  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) =
    (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16, t._17)
}

final class Tuple18SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)
) extends AnyVal {
  @inline def head: A1 = t._1
  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16, t._17)
  @inline def last: A18 = t._18
  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) =
    (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18)
}

// format: off
final class Tuple19SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)
) extends AnyVal {
  @inline def head: A1 = t._1
  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18)
  @inline def last: A19 = t._19
  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) =
    (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18, t._19)
}

final class Tuple20SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)
) extends AnyVal {
  @inline def head: A1 = t._1
  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10,
      t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18, t._19)
  @inline def last: A20 = t._20
  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) =
    (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10,
      t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18, t._19, t._20)
}

final class Tuple21SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)
) extends AnyVal {
  @inline def head: A1 = t._1
  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10,
      t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18, t._19, t._20)
  @inline def last: A21 = t._21
  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) =
    (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10,
      t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18, t._19, t._20, t._21)
}

final class Tuple22SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22)
) extends AnyVal {
  @inline def head: A1 = t._1
  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10,
      t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18, t._19, t._20, t._21)
  @inline def last: A22 = t._22
  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22) =
    (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10,
      t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18, t._19, t._20, t._21, t._22)
}
