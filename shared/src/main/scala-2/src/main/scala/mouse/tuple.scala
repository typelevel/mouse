/*
 * Copyright (c) 2016 Typelevel
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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
  ): Tuple17SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17] =
    new Tuple17SyntaxOps(t)

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

  /**
   * Return a new tuple by prepending the element to `this` tuple.
   *
   * @example
   *   {{{0 *: (1, 2) // the result is (0, 1, 2)}}}
   */
  def *:[A0](elem: A0): (A0, A1, A2) = (elem, t._1, t._2)

  /**
   * Return a copy of `this` tuple with the element appended.
   *
   * @example
   *   {{{(1, 2) :* 3 // the result is (1, 2, 3)}}}
   */
  def :*[A3](elem: A3): (A1, A2, A3) = (t._1, t._2, elem)

  @inline def head: A1 = t._1

  @inline def last: A2 = t._2

  def reverse: (A2, A1) = (t._2, t._1)
}

final class Tuple3SyntaxOps[A1, A2, A3](private val t: (A1, A2, A3)) extends AnyVal {

  /**
   * Return a new tuple by prepending the element to `this` tuple.
   *
   * @example
   *   {{{0 *: (1, 2, 3) // the result is (0, 1, 2, 3)}}}
   */
  def *:[A0](elem: A0): (A0, A1, A2, A3) = (elem, t._1, t._2, t._3)

  /**
   * Return a copy of `this` tuple with the element appended.
   *
   * @example
   *   {{{(1, 2, 3) :* 4 // the result is (1, 2, 3, 4)}}}
   */
  def :*[A4](elem: A4): (A1, A2, A3, A4) = (t._1, t._2, t._3, elem)

  @inline def head: A1 = t._1

  def init: (A1, A2) = (t._1, t._2)

  @inline def last: A3 = t._3

  def reverse: (A3, A2, A1) = (t._3, t._2, t._1)

  def tail: (A2, A3) = (t._2, t._3)
}

final class Tuple4SyntaxOps[A1, A2, A3, A4](private val t: (A1, A2, A3, A4)) extends AnyVal {

  /**
   * Return a new tuple by prepending the element to `this` tuple.
   *
   * @example
   *   {{{0 *: (1, 2, 3, 4) // the result is (0, 1, 2, 3, 4)}}}
   */
  def *:[A0](elem: A0): (A0, A1, A2, A3, A4) = (elem, t._1, t._2, t._3, t._4)

  /**
   * Return a copy of `this` tuple with the element appended.
   *
   * @example
   *   {{{(1, 2, 3, 4) :* 5 // the result is (1, 2, 3, 4, 5)}}}
   */
  def :*[A5](elem: A5): (A1, A2, A3, A4, A5) = (t._1, t._2, t._3, t._4, elem)

  @inline def head: A1 = t._1

  def init: (A1, A2, A3) = (t._1, t._2, t._3)

  @inline def last: A4 = t._4

  def reverse: (A4, A3, A2, A1) = (t._4, t._3, t._2, t._1)

  def tail: (A2, A3, A4) = (t._2, t._3, t._4)
}

final class Tuple5SyntaxOps[A1, A2, A3, A4, A5](private val t: (A1, A2, A3, A4, A5)) extends AnyVal {

  /**
   * Return a new tuple by prepending the element to `this` tuple.
   *
   * @example
   *   {{{0 *: (1, 2, 3, 4, 5) // the result is (0, 1, 2, 3, 4, 5)}}}
   */
  def *:[A0](elem: A0): (A0, A1, A2, A3, A4, A5) = (elem, t._1, t._2, t._3, t._4, t._5)

  /**
   * Return a copy of `this` tuple with the element appended.
   *
   * @example
   *   {{{(1, 2, 3, 4, 5) :* 6 // the result is (1, 2, 3, 4, 5, 6)}}}
   */
  def :*[A6](elem: A6): (A1, A2, A3, A4, A5, A6) = (t._1, t._2, t._3, t._4, t._5, elem)

  @inline def head: A1 = t._1

  def init: (A1, A2, A3, A4) = (t._1, t._2, t._3, t._4)

  @inline def last: A5 = t._5

  def reverse: (A5, A4, A3, A2, A1) = (t._5, t._4, t._3, t._2, t._1)

  def tail: (A2, A3, A4, A5) = (t._2, t._3, t._4, t._5)
}

final class Tuple6SyntaxOps[A1, A2, A3, A4, A5, A6](private val t: (A1, A2, A3, A4, A5, A6)) extends AnyVal {

  /**
   * Return a new tuple by prepending the element to `this` tuple.
   *
   * @example
   *   {{{0 *: (1, 2, 3, 4, 5, 6) // the result is (0, 1, 2, 3, 4, 5, 6)}}}
   */
  def *:[A0](elem: A0): (A0, A1, A2, A3, A4, A5, A6) = (elem, t._1, t._2, t._3, t._4, t._5, t._6)

  /**
   * Return a copy of `this` tuple with the element appended.
   *
   * @example
   *   {{{(1, 2, 3, 4, 5, 6) :* 7 // the result is (1, 2, 3, 4, 5, 6, 7)}}}
   */
  def :*[A7](elem: A7): (A1, A2, A3, A4, A5, A6, A7) = (t._1, t._2, t._3, t._4, t._5, t._6, elem)

  @inline def head: A1 = t._1

  def init: (A1, A2, A3, A4, A5) = (t._1, t._2, t._3, t._4, t._5)

  @inline def last: A6 = t._6

  def reverse: (A6, A5, A4, A3, A2, A1) = (t._6, t._5, t._4, t._3, t._2, t._1)

  def tail: (A2, A3, A4, A5, A6) = (t._2, t._3, t._4, t._5, t._6)
}

final class Tuple7SyntaxOps[A1, A2, A3, A4, A5, A6, A7](private val t: (A1, A2, A3, A4, A5, A6, A7)) extends AnyVal {

  /**
   * Return a new tuple by prepending the element to `this` tuple.
   *
   * @example
   *   {{{0 *: (1, 2, 3, 4, 5, 6, 7) // the result is (0, 1, 2, 3, 4, 5, 6, 7)}}}
   */
  def *:[A0](elem: A0): (A0, A1, A2, A3, A4, A5, A6, A7) = (elem, t._1, t._2, t._3, t._4, t._5, t._6, t._7)

  /**
   * Return a copy of `this` tuple with the element appended.
   *
   * @example
   *   {{{(1, 2, 3, 4, 5, 6, 7) :* 8 // the result is (1, 2, 3, 4, 5, 6, 7, 8)}}}
   */
  def :*[A8](elem: A8): (A1, A2, A3, A4, A5, A6, A7, A8) = (t._1, t._2, t._3, t._4, t._5, t._6, t._7, elem)

  @inline def head: A1 = t._1

  def init: (A1, A2, A3, A4, A5, A6) = (t._1, t._2, t._3, t._4, t._5, t._6)

  @inline def last: A7 = t._7

  def reverse: (A7, A6, A5, A4, A3, A2, A1) = (t._7, t._6, t._5, t._4, t._3, t._2, t._1)

  def tail: (A2, A3, A4, A5, A6, A7) = (t._2, t._3, t._4, t._5, t._6, t._7)
}

final class Tuple8SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8](private val t: (A1, A2, A3, A4, A5, A6, A7, A8))
    extends AnyVal {

  /**
   * Return a new tuple by prepending the element to `this` tuple.
   *
   * @example
   *   {{{0 *: (1, 2, 3, 4, 5, 6, 7, 8) // the result is (0, 1, 2, 3, 4, 5, 6, 7, 8)}}}
   */
  def *:[A0](elem: A0): (A0, A1, A2, A3, A4, A5, A6, A7, A8) = (elem, t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8)

  /**
   * Return a copy of `this` tuple with the element appended.
   *
   * @example
   *   {{{(1, 2, 3, 4, 5, 6, 7, 8) :* 9 // the result is (1, 2, 3, 4, 5, 6, 7, 8, 9)}}}
   */
  def :*[A9](elem: A9): (A1, A2, A3, A4, A5, A6, A7, A8, A9) = (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, elem)

  @inline def head: A1 = t._1

  def init: (A1, A2, A3, A4, A5, A6, A7) = (t._1, t._2, t._3, t._4, t._5, t._6, t._7)

  @inline def last: A8 = t._8

  def reverse: (A8, A7, A6, A5, A4, A3, A2, A1) = (t._8, t._7, t._6, t._5, t._4, t._3, t._2, t._1)

  def tail: (A2, A3, A4, A5, A6, A7, A8) = (t._2, t._3, t._4, t._5, t._6, t._7, t._8)
}

final class Tuple9SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9](private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9))
    extends AnyVal {

  /**
   * Return a new tuple by prepending the element to `this` tuple.
   *
   * @example
   *   {{{0 *: (1, 2, 3, 4, 5, 6, 7, 8, 9) // the result is (0, 1, 2, 3, 4, 5, 6, 7, 8, 9)}}}
   */
  def *:[A0](elem: A0): (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9) =
    (elem, t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9)

  /**
   * Return a copy of `this` tuple with the element appended.
   *
   * @example
   *   {{{(1, 2, 3, 4, 5, 6, 7, 8, 9) :* 10 // the result is (1, 2, 3, 4, 5, 6, 7, 8, 9, 10)}}}
   */
  def :*[A10](elem: A10): (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, elem)

  @inline def head: A1 = t._1

  def init: (A1, A2, A3, A4, A5, A6, A7, A8) = (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8)

  @inline def last: A9 = t._9

  def reverse: (A9, A8, A7, A6, A5, A4, A3, A2, A1) = (t._9, t._8, t._7, t._6, t._5, t._4, t._3, t._2, t._1)

  def tail: (A2, A3, A4, A5, A6, A7, A8, A9) = (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9)
}

final class Tuple10SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)
) extends AnyVal {

  /**
   * Return a new tuple by prepending the element to `this` tuple.
   *
   * @example
   *   {{{0 *: (1, 2, 3, 4, 5, 6, 7, 8, 9, 10) // the result is (0, 1, 2, 3, 4, 5, 6, 7, 8, 10)}}}
   */
  def *:[A0](elem: A0): (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) =
    (elem, t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10)

  /**
   * Return a copy of `this` tuple with the element appended.
   *
   * @example
   *   {{{(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) :* 11 // the result is (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)}}}
   */
  def :*[A11](elem: A11): (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, elem)

  @inline def head: A1 = t._1

  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9) = (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9)

  @inline def last: A10 = t._10

  def reverse: (A10, A9, A8, A7, A6, A5, A4, A3, A2, A1) =
    (t._10, t._9, t._8, t._7, t._6, t._5, t._4, t._3, t._2, t._1)

  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10) = (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10)
}

final class Tuple11SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)
) extends AnyVal {

  /**
   * Return a new tuple by prepending the element to `this` tuple.
   */
  def *:[A0](elem: A0): (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) =
    (elem, t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11)

  /**
   * Return a copy of `this` tuple with the element appended.
   */
  def :*[A12](elem: A12): (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, elem)

  @inline def head: A1 = t._1

  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) = (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10)

  @inline def last: A11 = t._11

  def reverse: (A11, A10, A9, A8, A7, A6, A5, A4, A3, A2, A1) =
    (t._11, t._10, t._9, t._8, t._7, t._6, t._5, t._4, t._3, t._2, t._1)

  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) = (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11)
}

final class Tuple12SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)
) extends AnyVal {

  /**
   * Return a new tuple by prepending the element to `this` tuple.
   */
  def *:[A0](elem: A0): (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) =
    (elem, t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12)

  /**
   * Return a copy of `this` tuple with the element appended.
   */
  def :*[A13](elem: A13): (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, elem)

  @inline def head: A1 = t._1

  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11)

  @inline def last: A12 = t._12

  def reverse: (A12, A11, A10, A9, A8, A7, A6, A5, A4, A3, A2, A1) =
    (t._12, t._11, t._10, t._9, t._8, t._7, t._6, t._5, t._4, t._3, t._2, t._1)

  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) =
    (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12)
}

final class Tuple13SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)
) extends AnyVal {

  /**
   * Return a new tuple by prepending the element to `this` tuple.
   */
  def *:[A0](elem: A0): (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) =
    (elem, t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13)

  /**
   * Return a copy of `this` tuple with the element appended.
   */
  def :*[A14](elem: A14): (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, elem)

  @inline def head: A1 = t._1

  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12)

  @inline def last: A13 = t._13

  def reverse: (A13, A12, A11, A10, A9, A8, A7, A6, A5, A4, A3, A2, A1) =
    (t._13, t._12, t._11, t._10, t._9, t._8, t._7, t._6, t._5, t._4, t._3, t._2, t._1)

  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) =
    (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13)
}

final class Tuple14SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)
) extends AnyVal {

  /**
   * Return a new tuple by prepending the element to `this` tuple.
   */
  def *:[A0](elem: A0): (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) =
    (elem, t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14)

  /**
   * Return a copy of `this` tuple with the element appended.
   */
  def :*[A15](elem: A15): (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, elem)

  @inline def head: A1 = t._1

  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13)

  @inline def last: A14 = t._14

  def reverse: (A14, A13, A12, A11, A10, A9, A8, A7, A6, A5, A4, A3, A2, A1) =
    (t._14, t._13, t._12, t._11, t._10, t._9, t._8, t._7, t._6, t._5, t._4, t._3, t._2, t._1)

  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) =
    (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14)
}

final class Tuple15SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)
) extends AnyVal {

  /**
   * Return a new tuple by prepending the element to `this` tuple.
   */
  def *:[A0](elem: A0): (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) =
    (elem, t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15)

  /**
   * Return a copy of `this` tuple with the element appended.
   */
  def :*[A16](elem: A16): (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, elem)

  @inline def head: A1 = t._1

  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14)

  @inline def last: A15 = t._15

  def reverse: (A15, A14, A13, A12, A11, A10, A9, A8, A7, A6, A5, A4, A3, A2, A1) =
    (t._15, t._14, t._13, t._12, t._11, t._10, t._9, t._8, t._7, t._6, t._5, t._4, t._3, t._2, t._1)

  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) =
    (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15)
}

final class Tuple16SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)
) extends AnyVal {

  /**
   * Return a new tuple by prepending the element to `this` tuple.
   */
  def *:[A0](elem: A0): (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) =
    (elem, t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16)

  /**
   * Return a copy of `this` tuple with the element appended.
   */
  def :*[A17](elem: A17): (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16, elem)

  @inline def head: A1 = t._1

  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15)

  @inline def last: A16 = t._16

  def reverse: (A16, A15, A14, A13, A12, A11, A10, A9, A8, A7, A6, A5, A4, A3, A2, A1) =
    (t._16, t._15, t._14, t._13, t._12, t._11, t._10, t._9, t._8, t._7, t._6, t._5, t._4, t._3, t._2, t._1)

  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) =
    (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16)
}

final class Tuple17SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)
) extends AnyVal {

  /**
   * Return a new tuple by prepending the element to `this` tuple.
   */
  def *:[A0](elem: A0): (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) =
    (elem, t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16, t._17)

  /**
   * Return a copy of `this` tuple with the element appended.
   */
  def :*[A18](elem: A18): (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16, t._17, elem)

  @inline def head: A1 = t._1

  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16)

  @inline def last: A17 = t._17

  def reverse: (A17, A16, A15, A14, A13, A12, A11, A10, A9, A8, A7, A6, A5, A4, A3, A2, A1) =
    (t._17, t._16, t._15, t._14, t._13, t._12, t._11, t._10, t._9, t._8, t._7, t._6, t._5, t._4, t._3, t._2, t._1)

  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) =
    (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16, t._17)
}

// format: off
final class Tuple18SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)
) extends AnyVal {

  /**
   * Return a new tuple by prepending the element to `this` tuple.
   */
  def *:[A0](elem: A0): (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) =
    (elem, t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8,
      t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18)

  /**
   * Return a copy of `this` tuple with the element appended.
   */
  def :*[A19](elem: A19): (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9,
      t._10, t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18, elem)

  @inline def head: A1 = t._1

  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16, t._17)

  @inline def last: A18 = t._18

  def reverse: (A18, A17, A16, A15, A14, A13, A12, A11, A10, A9, A8, A7, A6, A5, A4, A3, A2, A1) =
    (t._18, t._17, t._16, t._15, t._14, t._13, t._12, t._11,
      t._10, t._9, t._8, t._7, t._6, t._5, t._4, t._3, t._2, t._1)

  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) =
    (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18)
}

final class Tuple19SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)
) extends AnyVal {

  /**
   * Return a new tuple by prepending the element to `this` tuple.
   */
  def *:[A0](elem: A0): (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) =
    (elem, t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9,
      t._10, t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18, t._19)

  /**
   * Return a copy of `this` tuple with the element appended.
   */
  def :*[A20](elem: A20): (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10,
      t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18, t._19, elem)

  @inline def head: A1 = t._1

  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18)

  @inline def last: A19 = t._19

  def reverse: (A19, A18, A17, A16, A15, A14, A13, A12, A11, A10, A9, A8, A7, A6, A5, A4, A3, A2, A1) =
    (t._19, t._18, t._17, t._16, t._15, t._14, t._13, t._12, t._11,
      t._10, t._9, t._8, t._7, t._6, t._5, t._4, t._3, t._2, t._1)

  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) =
    (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18, t._19)
}

final class Tuple20SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)
) extends AnyVal {

  /**
   * Return a new tuple by prepending the element to `this` tuple.
   */
  def *:[A0](elem: A0): (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) =
    (elem, t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10,
      t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18, t._19, t._20)

  /**
   * Return a copy of `this` tuple with the element appended.
   */
  def :*[A21](elem: A21): (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10,
      t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18, t._19, t._20, elem)

  @inline def head: A1 = t._1

  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10,
      t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18, t._19)

  @inline def last: A20 = t._20

  def reverse: (A20, A19, A18, A17, A16, A15, A14, A13, A12, A11, A10, A9, A8, A7, A6, A5, A4, A3, A2, A1) =
    (t._20, t._19, t._18, t._17, t._16, t._15, t._14, t._13, t._12,
      t._11, t._10, t._9, t._8, t._7, t._6, t._5, t._4, t._3, t._2, t._1)

  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) =
    (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10,
      t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18, t._19, t._20)
}

final class Tuple21SyntaxOps[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](
  private val t: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)
) extends AnyVal {

  /**
   * Return a new tuple by prepending the element to `this` tuple.
   */
  def *:[A0](elem: A0): (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) =
    (elem, t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10,
      t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18, t._19, t._20, t._21)

  /**
   * Return a copy of `this` tuple with the element appended.
   */
  def :*[A22](elem: A22): (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10,
      t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18, t._19, t._20, t._21, elem)

  @inline def head: A1 = t._1

  def init: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) =
    (t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10,
      t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18, t._19, t._20)

  @inline def last: A21 = t._21

  def reverse: (A21, A20, A19, A18, A17, A16, A15, A14, A13, A12, A11, A10, A9, A8, A7, A6, A5, A4, A3, A2, A1) =
    (t._21, t._20, t._19, t._18, t._17, t._16, t._15, t._14, t._13, t._12,
      t._11, t._10, t._9, t._8, t._7, t._6, t._5, t._4, t._3, t._2, t._1)

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

  def reverse: (A22, A21, A20, A19, A18, A17, A16, A15, A14, A13, A12, A11, A10, A9, A8, A7, A6, A5, A4, A3, A2, A1) =
    (t._22, t._21, t._20, t._19, t._18, t._17, t._16, t._15, t._14, t._13,
      t._12, t._11, t._10, t._9, t._8, t._7, t._6, t._5, t._4, t._3, t._2, t._1)

  def tail: (A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22) =
    (t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10,
      t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18, t._19, t._20, t._21, t._22)
}
