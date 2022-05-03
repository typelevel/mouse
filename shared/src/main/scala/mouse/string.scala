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

import cats.data.Validated
import cats.syntax.either._

trait StringSyntax {
  implicit def stringSyntaxMouse(s: String): StringOps = new StringOps(s)
}

final class StringOps(private val s: String) extends AnyVal {

  @inline def parseBoolean: IllegalArgumentException Either Boolean =
    Either.catchOnly[IllegalArgumentException](s.toBoolean)

  @inline def parseBooleanValidated: Validated[IllegalArgumentException, Boolean] = parseBoolean.toValidated

  @inline def parseBooleanOption: Option[Boolean] = parseBoolean.toOption

  @inline def parseByte: NumberFormatException Either Byte = parse[Byte](_.toByte)

  @inline def parseByteValidated: Validated[NumberFormatException, Byte] = parseByte.toValidated

  @inline def parseByteOption: Option[Byte] = parseByte.toOption

  @inline def parseDouble: NumberFormatException Either Double = parse[Double](_.toDouble)

  @inline def parseDoubleValidated: Validated[NumberFormatException, Double] = parseDouble.toValidated

  @inline def parseDoubleOption: Option[Double] = parseDouble.toOption

  @inline def parseFloat: NumberFormatException Either Float = parse[Float](_.toFloat)

  @inline def parseFloatValidated: Validated[NumberFormatException, Float] = parseFloat.toValidated

  @inline def parseFloatOption: Option[Float] = parseFloat.toOption

  @inline def parseInt: NumberFormatException Either Int = parse[Int](_.toInt)

  @inline def parseIntValidated: Validated[NumberFormatException, Int] = parseInt.toValidated

  @inline def parseIntOption: Option[Int] = parseInt.toOption

  @inline def parseLong: NumberFormatException Either Long = parse[Long](_.toLong)

  @inline def parseLongValidated: Validated[NumberFormatException, Long] = parseLong.toValidated

  @inline def parseLongOption: Option[Long] = parseLong.toOption

  @inline def parseShort: NumberFormatException Either Short = parse[Short](_.toShort)

  @inline def parseShortValidated: Validated[NumberFormatException, Short] = parseShort.toValidated

  @inline def parseShortOption: Option[Short] = parseShort.toOption

  @inline def parseBigInt: NumberFormatException Either BigInt = parse(BigInt.apply)

  @inline def parseBigIntValidated: Validated[NumberFormatException, BigInt] = parseBigInt.toValidated

  @inline def parseBigIntOption: Option[BigInt] = parseBigInt.toOption

  @inline def parseBigDecimal: NumberFormatException Either BigDecimal = parse(BigDecimal.apply)

  @inline def parseBigDecimalValidated: Validated[NumberFormatException, BigDecimal] = parseBigDecimal.toValidated

  @inline def parseBigDecimalOption: Option[BigDecimal] = parseBigDecimal.toOption

  private def parse[A](f: String => A): NumberFormatException Either A = Either.catchOnly[NumberFormatException](f(s))

  /**
   * Wraps a `String` in `Throwable`.
   */
  @inline def asThrowable: Throwable = new Throwable(s)

  /**
   * Wraps a `String` in `Error`.
   */
  @inline def asError: Error = new Error(s)

  /**
   * Wraps a `String` in `Exception`.
   */
  @inline def asException: Exception = new Exception(s)
}
