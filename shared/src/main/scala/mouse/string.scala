package mouse

import cats.data.Validated
import cats.syntax.all._

object string:
  extension (s: String)

    @inline def toBooleanEither: Either[String, Boolean] = s.toBooleanOption.toRight(s)
    @inline def toBooleanValidated: Validated[String, Boolean] = s.toBooleanOption.toValid(s)

    @deprecated("Use `toBooleanOption` from the std lib instead", "1.0.0")
    @inline def parseBooleanOption: Option[Boolean] = s.toBooleanOption

    @deprecated("Use `toBooleanEither` instead", "1.0.0")
    @inline def parseBoolean: Either[IllegalArgumentException, Boolean] =
      Either.catchOnly[IllegalArgumentException](s.toBoolean)

    @deprecated("Use `toBooleanValidated` instead", "1.0.0")
    @inline def parseBooleanValidated: Validated[IllegalArgumentException, Boolean] = parseBoolean.toValidated


    @inline def toByteEither: Either[String, Byte] = s.toByteOption.toRight(s)
    @inline def toByteValidated: Validated[String, Byte] = s.toByteOption.toValid(s)

    @deprecated("Use `toByteOption` from the std lib instead", "1.0.0")
    @inline def parseByteOption: Option[Byte] = parseByte.toOption

    @deprecated("Use `toByteEither` instead", "1.0.0")
    @inline def parseByte: Either[NumberFormatException, Byte] = parse[Byte](_.toByte, s)

    @deprecated("Use `toByteValidated` instead", "1.0.0")
    @inline def parseByteValidated: Validated[NumberFormatException, Byte] = parseByte.toValidated


    @inline def toDoubleEither: Either[String, Double] = s.toDoubleOption.toRight(s)
    @inline def toDoubleValidated: Validated[String, Double] = s.toDoubleOption.toValid(s)

    @deprecated("Use `toDoubleOption` from the std lib instead", "1.0.0")
    @inline def parseDoubleOption: Option[Double] = parseDouble.toOption

    @deprecated("Use `toDoubleEither` instead", "1.0.0")
    @inline def parseDouble: Either[NumberFormatException, Double] = parse[Double](_.toDouble, s)

    @deprecated("Use `toDoubleValidated` instead", "1.0.0")
    @inline def parseDoubleValidated: Validated[NumberFormatException, Double] = parseDouble.toValidated



    @inline def toFloatEither: Either[String, Float] = s.toFloatOption.toRight(s)
    @inline def toFloatValidated: Validated[String, Float] = s.toFloatOption.toValid(s)
    
    @deprecated("Use `toFloatOption` from the std lib instead", "1.0.0")
    @inline def parseFloatOption: Option[Float] = parseFloat.toOption
    
    @deprecated("Use `toFloatEither` instead", "1.0.0")
    @inline def parseFloat: Either[NumberFormatException, Float] = parse[Float](_.toFloat, s)
    
    @deprecated("Use `toFloatValidated` instead", "1.0.0")
    @inline def parseFloatValidated: Validated[NumberFormatException, Float] = parseFloat.toValidated

    
    @inline def toIntEither: Either[String, Int] = s.toIntOption.toRight(s)
    @inline def toIntValidated: Validated[String, Int] = s.toIntOption.toValid(s)
    
    @deprecated("Use `toIntOption` from the std lib instead", "1.0.0")
    @inline def parseIntOption: Option[Int] = parseInt.toOption
    
    @deprecated("Use `toIntEither` instead", "1.0.0")
    @inline def parseInt: Either[NumberFormatException, Int] = parse[Int](_.toInt, s)
    
    @deprecated("Use `toIntValidated` instead", "1.0.0")
    @inline def parseIntValidated: Validated[NumberFormatException, Int] = parseInt.toValidated


    @inline def toLongEither: Either[String, Long] = s.toLongOption.toRight(s)
    @inline def toLongValidated: Validated[String, Long] = s.toLongOption.toValid(s)
    
    @deprecated("Use `toLongOption` from the std lib instead", "1.0.0")
    @inline def parseLongOption: Option[Long] = parseLong.toOption
    
    @deprecated("Use `toLongEither` instead", "1.0.0")
    @inline def parseLong: Either[NumberFormatException, Long] = parse[Long](_.toLong, s)
    
    @deprecated("Use `toLongValidated` instead", "1.0.0")
    @inline def parseLongValidated: Validated[NumberFormatException, Long] = parseLong.toValidated


    @inline def toShortEither: Either[String, Short] = s.toShortOption.toRight(s)
    @inline def toShortValidated: Validated[String, Short] = s.toShortOption.toValid(s)
    
    @deprecated("Use `toShortOption` from the std lib instead", "1.0.0")
    @inline def parseShortOption: Option[Short] = parseShort.toOption
    
    @deprecated("Use `toShortEither` instead", "1.0.0")
    @inline def parseShort: Either[NumberFormatException, Short] = parse[Short](_.toShort, s)
    
    @deprecated("Use `toShortValidated` instead", "1.0.0")
    @inline def parseShortValidated: Validated[NumberFormatException, Short] = parseShort.toValidated


    @inline def toBigIntOption: Option[BigInt] = parse[BigInt](BigInt.apply, s).toOption
    @inline def toBigIntEither: Either[String, BigInt] = s.toBigIntOption.toRight(s)
    @inline def toBigIntValidated: Validated[String, BigInt] = s.toBigIntOption.toValid(s)

    @deprecated("Use `toBigIntOption` from the std lib instead", "1.0.0")
    @inline def parseBigIntOption: Option[BigInt] = parseBigInt.toOption

    @deprecated("Use `toBigIntEither` instead", "1.0.0")
    @inline def parseBigInt: Either[NumberFormatException, BigInt] = parse[BigInt](BigInt.apply, s)

    @deprecated("Use `toBigIntValidated` instead", "1.0.0")
    @inline def parseBigIntValidated: Validated[NumberFormatException, BigInt] = parseBigInt.toValidated


    @inline def toBigDecimalOption: Option[BigDecimal] = parse[BigDecimal](BigDecimal.apply, s).toOption
    @inline def toBigDecimalEither: Either[String, BigDecimal] = s.toBigDecimalOption.toRight(s)
    @inline def toBigDecimalValidated: Validated[String, BigDecimal] = s.toBigDecimalOption.toValid(s)
    
    @deprecated("Use `toBigDecimalOption` aligning with the std lib instead", "1.0.0")
    @inline def parseBigDecimalOption: Option[BigDecimal] = s.toBigDecimalOption
    
    @deprecated("Use `toBigDecimalEither` instead", "1.0.0")
    @inline def parseBigDecimal: Either[NumberFormatException, BigDecimal] = parse[BigDecimal](BigDecimal.apply, s)
    
    @deprecated("Use `toBigDecimalValidated` instead", "1.0.0")
    @inline def parseBigDecimalValidated: Validated[NumberFormatException, BigDecimal] = parseBigDecimal.toValidated

  private def parse[A](f: String => A, s: String): NumberFormatException Either A = Either.catchOnly[NumberFormatException](f(s))
