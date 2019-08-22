package mouse

import cats.data.Validated
import cats.syntax.either._

trait StringSyntax {
  implicit def stringSyntaxMouse(s: String): StringOps = new StringOps(s)
}

final class StringOps(val s: String) extends AnyVal {

  @inline def parseBoolean: IllegalArgumentException Either Boolean = Either.catchOnly[IllegalArgumentException](s.toBoolean)

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

}
