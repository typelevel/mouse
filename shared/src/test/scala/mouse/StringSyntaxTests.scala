package mouse

import org.scalacheck.Arbitrary._
import org.scalacheck.{Arbitrary, Gen}
import cats.syntax.all._

class StringSyntaxTests extends MouseSuite {

  //FIXME fixed in master, remove post 0.8.2
  implicit def catsSyntaxEitherId[A](a: A): EitherIdOps[A] = new EitherIdOps(a)

  test("parseInt") {
    "123".parseInt should ===(123.asRight[NumberFormatException])

    "blah".parseInt should ===(new NumberFormatException("For input string: \"blah\"").asLeft)

    forAll { i: Int =>
      i.toString.parseInt should ===(i.asRight[NumberFormatException])
    }

    forAll { i: Int =>
      i.toString.parseInt.toOption should ===(i.toString.parseIntOption)
    }

    forAll { i: Int =>
      i.toString.parseInt.toValidated should ===(i.toString.parseIntValidated)
    }

  }

  test("parseLong") {
    "123".parseLong should ===(123L.asRight[NumberFormatException])

    "blah".parseLong should ===(new NumberFormatException("For input string: \"blah\"").asLeft)

    forAll { i: Long =>
      i.toString.parseLong should ===(i.asRight[NumberFormatException])
    }

    forAll { i: Long =>
      i.toString.parseLong.toOption should ===(i.toString.parseLongOption)
    }

    forAll { i: Long =>
      i.toString.parseLong.toValidated should ===(i.toString.parseLongValidated)
    }

  }

  test("parseShort") {
    "123".parseShort should ===(123.toShort.asRight[NumberFormatException])

    "blah".parseShort should ===(new NumberFormatException("For input string: \"blah\"").asLeft)

    forAll { i: Short =>
      i.toString.parseShort should ===(i.asRight[NumberFormatException])
    }

    forAll { i: Short =>
      i.toString.parseShort.toOption should ===(i.toString.parseShortOption)
    }

    forAll { i: Short =>
      i.toString.parseShort.toValidated should ===(i.toString.parseShortValidated)
    }

  }

  test("parseDouble") {
    "123.1".parseDouble should ===(123.1.asRight[NumberFormatException])

    "blah".parseDouble should ===(new NumberFormatException("For input string: \"blah\"").asLeft)

    forAll { i: Double =>
      i.toString.parseDouble should ===(i.asRight[NumberFormatException])
    }

    forAll { i: Double =>
      i.toString.parseDouble.toOption should ===(i.toString.parseDoubleOption)
    }

    forAll { i: Double =>
      i.toString.parseDouble.toValidated should ===(i.toString.parseDoubleValidated)
    }
  }

  test("parseFloat") {
    "blah".parseFloat should ===(new NumberFormatException("For input string: \"blah\"").asLeft)

    forAll { i: Float =>
      i.toString.parseFloat should ===(i.asRight[NumberFormatException])
    }

    forAll { i: Float =>
      i.toString.parseFloat.toOption should ===(i.toString.parseFloatOption)
    }

    forAll { i: Float =>
      i.toString.parseFloat.toValidated should ===(i.toString.parseFloatValidated)
    }
  }

  test("parseByte") {
    "123".parseByte should ===(123.toByte.asRight[NumberFormatException])

    "blah".parseByte should ===(new NumberFormatException("For input string: \"blah\"").asLeft)

    forAll { i: Byte =>
      i.toString.parseByte should ===(i.asRight[NumberFormatException])
    }

    forAll { i: Byte =>
      i.toString.parseByte.toOption should ===(i.toString.parseByteOption)
    }

    forAll { i: Byte =>
      i.toString.parseByte.toValidated should ===(i.toString.parseByteValidated)
    }
  }

  test("parseBigInt") {
    "123".parseBigInt should ===(BigInt("123").asRight[NumberFormatException])

    "blah".parseBigInt should ===(new NumberFormatException("For input string: \"blah\"").asLeft)

    forAll { i: BigInt =>
      i.toString.parseBigInt should ===(i.asRight[NumberFormatException])
    }

    forAll { i: BigInt =>
      i.toString.parseBigInt.toOption should ===(i.toString.parseBigIntOption)
    }

    forAll { i: BigInt =>
      i.toString.parseBigInt.toValidated should ===(i.toString.parseBigIntValidated)
    }
  }

  test("parseBigDecimal") {
    "123.45".parseBigDecimal should ===(BigDecimal("123.45").asRight[NumberFormatException])

    // We assert the class of the exception because the error message differs between the JVM and JS
    "blah".parseBigDecimal.leftMap(_.getClass) should ===(classOf[NumberFormatException].asLeft)

    forAll { i: BigDecimal =>
      i.toString.parseBigDecimal should ===(i.asRight[NumberFormatException])
    }

    forAll { i: BigDecimal =>
      i.toString.parseBigDecimal.toOption should ===(i.toString.parseBigDecimalOption)
    }

    forAll { i: BigDecimal =>
      i.toString.parseBigDecimal.toValidated should ===(i.toString.parseBigDecimalValidated)
    }
  }

  test("parseBoolean") {
    "true".parseBoolean should ===(true.asRight[IllegalArgumentException])
    "true".parseBoolean.toOption should ===("true".parseBooleanOption)
    "true".parseBoolean.toValidated should ===("true".parseBooleanValidated)
    "false".parseBoolean should ===(false.asRight[IllegalArgumentException])
    "false".parseBoolean.toOption should ===("false".parseBooleanOption)
    "false".parseBoolean.toValidated should ===("false".parseBooleanValidated)

    "TRUE".parseBoolean should ===("true".parseBoolean)
    "FALSE".parseBoolean should ===("false".parseBoolean)

    val stringGen: Gen[String] = Arbitrary.arbString.arbitrary.filter(s => !s.equalsIgnoreCase("true") && !s.equalsIgnoreCase("false"))

    forAll(stringGen) { s: String =>
      s.parseBoolean should ===(new IllegalArgumentException("For input string: \"" + s + "\"").asLeft)
    }
  }

}

final class EitherIdOps[A](val obj: A) extends AnyVal {
  /** Wrap a value in `Left`. */
  def asLeft[B]: Either[A, B] = Left(obj)

  /** Wrap a value in `Right`. */
  def asRight[B]: Either[B, A] = Right(obj)
}
