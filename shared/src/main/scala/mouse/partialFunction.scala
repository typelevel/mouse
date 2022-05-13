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

trait PartialFunctionLift {

  def liftEither[A]: PartialFunctionLift.LiftEitherPartiallyApplied[A] =
    new PartialFunctionLift.LiftEitherPartiallyApplied

}
object PartialFunctionLift {

  // https://typelevel.org/cats/guidelines.html#partially-applied-type-params
  final private[mouse] class LiftEitherPartiallyApplied[A](private val dummy: Boolean = true) extends AnyVal {
    def apply[B, C](pf: PartialFunction[A, B], orElse: A => C): A => Either[C, B] =
      (a: A) => pf.lift(a).toRight(orElse(a))
  }

}
