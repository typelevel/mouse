package mouse

import cats.data.{Validated}
import cats.syntax.either._

trait StringSyntax {
  implicit def stringSyntaxMouse(s: String): StringOps = new StringOps(s)
}

final class StringOps(val s: String) extends AnyVal {

  @inline final def parseBoolean: IllegalArgumentException Either Boolean = Either.catchOnly[IllegalArgumentException](s.toBoolean)

  @inline final def parseBooleanValidated: Validated[IllegalArgumentException, Boolean] = parseBoolean.toValidated

  @inline final def parseBooleanOption: Option[Boolean] = parseBoolean.toOption

  @inline final def parseByte: NumberFormatException Either Byte = parse[Byte](_.toByte)

  @inline final def parseByteValidated: Validated[NumberFormatException, Byte] = parseByte.toValidated

  @inline final def parseByteOption: Option[Byte] = parseByte.toOption

  @inline final def parseDouble: NumberFormatException Either Double = parse[Double](_.toDouble)

  @inline final def parseDoubleValidated: Validated[NumberFormatException, Double] = parseDouble.toValidated

  @inline final def parseDoubleOption: Option[Double] = parseDouble.toOption

  @inline final def parseFloat: NumberFormatException Either Float = parse[Float](_.toFloat)

  @inline final def parseFloatValidated: Validated[NumberFormatException, Float] = parseFloat.toValidated

  @inline final def parseFloatOption: Option[Float] = parseFloat.toOption

  @inline final def parseInt: NumberFormatException Either Int = parse[Int](_.toInt)

  @inline final def parseIntValidated: Validated[NumberFormatException, Int] = parseInt.toValidated

  @inline final def parseIntOption: Option[Int] = parseInt.toOption

  @inline final def parseLong: NumberFormatException Either Long = parse[Long](_.toLong)

  @inline final def parseLongValidated: Validated[NumberFormatException, Long] = parseLong.toValidated

  @inline final def parseLongOption: Option[Long] = parseLong.toOption

  @inline final def parseShort: NumberFormatException Either Short = parse[Short](_.toShort)

  @inline final def parseShortValidated: Validated[NumberFormatException, Short] = parseShort.toValidated

  @inline final def parseShortOption: Option[Short] = parseShort.toOption

  private def parse[A](f: String => A): NumberFormatException Either A = Either.catchOnly[NumberFormatException](f(s))

}
