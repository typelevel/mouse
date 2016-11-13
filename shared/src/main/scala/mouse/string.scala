package mouse

import cats.data.{Validated}
import cats.syntax.either._

trait StringSyntax {
  implicit def stringSyntaxMouse(s: String): StringOps = new StringOps(s)
}

final class StringOps(val s: String) extends AnyVal {

  def parseBoolean: IllegalArgumentException Either Boolean = Either.catchOnly[IllegalArgumentException](s.toBoolean)

  def parseBooleanValidated: Validated[IllegalArgumentException, Boolean] = parseBoolean.toValidated

  def parseBooleanOption: Option[Boolean] = parseBoolean.toOption

  def parseByte: NumberFormatException Either Byte = parse[Byte](_.toByte)

  def parseByteValidated: Validated[NumberFormatException, Byte] = parseByte.toValidated

  def parseByteOption: Option[Byte] = parseByte.toOption

  def parseDouble: NumberFormatException Either Double = parse[Double](_.toDouble)

  def parseDoubleValidated: Validated[NumberFormatException, Double] = parseDouble.toValidated

  def parseDoubleOption: Option[Double] = parseDouble.toOption

  def parseFloat: NumberFormatException Either Float = parse[Float](_.toFloat)

  def parseFloatValidated: Validated[NumberFormatException, Float] = parseFloat.toValidated

  def parseFloatOption: Option[Float] = parseFloat.toOption

  def parseInt: NumberFormatException Either Int = parse[Int](_.toInt)

  def parseIntValidated: Validated[NumberFormatException, Int] = parseInt.toValidated

  def parseIntOption: Option[Int] = parseInt.toOption

  def parseLong: NumberFormatException Either Long = parse[Long](_.toLong)

  def parseLongValidated: Validated[NumberFormatException, Long] = parseLong.toValidated

  def parseLongOption: Option[Long] = parseLong.toOption

  def parseShort: NumberFormatException Either Short = parse[Short](_.toShort)

  def parseShortValidated: Validated[NumberFormatException, Short] = parseShort.toValidated

  def parseShortOption: Option[Short] = parseShort.toOption

  private def parse[A](f: String => A): NumberFormatException Either A = Either.catchOnly[NumberFormatException](f(s))

}
