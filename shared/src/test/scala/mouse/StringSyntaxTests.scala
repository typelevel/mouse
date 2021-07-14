package mouse

import cats.syntax.all._
import org.scalacheck.Arbitrary._
import org.scalacheck.Prop._
import org.scalacheck.{Arbitrary, Gen}

class StringSyntaxTests extends MouseSuite {
  test("StringOps.parseInt") {
    assertEquals("123".parseInt, 123.asRight[NumberFormatException])
    assert("blah".parseInt === new NumberFormatException("For input string: \"blah\"").asLeft)
  }

  property("scalacheck-suite: StringOps.parseInt") {
    forAll { i: Int =>
      i.toString.parseInt === i.asRight[NumberFormatException]
    }

    forAll { i: Int =>
      i.toString.parseInt.toOption === i.toString.parseIntOption
    }

    forAll { i: Int =>
      i.toString.parseInt.toValidated === i.toString.parseIntValidated
    }
  }

  test("StringOps.parseLong") {
    assertEquals("123".parseLong, 123L.asRight[NumberFormatException])
    assert("blah".parseLong === new NumberFormatException("For input string: \"blah\"").asLeft)
  }

  property("scalacheck-suite: StringOps.parseLong") {
    forAll { i: Long =>
      i.toString.parseLong === i.asRight[NumberFormatException]
    }

    forAll { i: Long =>
      i.toString.parseLong.toOption === i.toString.parseLongOption
    }

    forAll { i: Long =>
      i.toString.parseLong.toValidated === i.toString.parseLongValidated
    }
  }

  test("StringOps.parseShort") {
    assertEquals("123".parseShort, 123.toShort.asRight[NumberFormatException])
    assert("blah".parseShort === new NumberFormatException("For input string: \"blah\"").asLeft)
  }

  property("scalacheck-suite: StringOps.parseShort") {
    forAll { i: Short =>
      i.toString.parseShort === i.asRight[NumberFormatException]
    }

    forAll { i: Short =>
      i.toString.parseShort.toOption === i.toString.parseShortOption
    }

    forAll { i: Short =>
      i.toString.parseShort.toValidated === i.toString.parseShortValidated
    }
  }

  test("StringOps.parseDouble") {
    assertEquals("123.1".parseDouble, 123.1.asRight[NumberFormatException])
    assert("blah".parseDouble === new NumberFormatException("For input string: \"blah\"").asLeft)
  }

  property("scalacheck-suite: StringOps.parseDouble") {
    forAll { i: Double =>
      i.toString.parseDouble === i.asRight[NumberFormatException]
    }

    forAll { i: Double =>
      i.toString.parseDouble.toOption === i.toString.parseDoubleOption
    }

    forAll { i: Double =>
      i.toString.parseDouble.toValidated === i.toString.parseDoubleValidated
    }
  }

  test("StringOps.parseFloat") {
    assert("blah".parseFloat === new NumberFormatException("For input string: \"blah\"").asLeft)
  }

  property("scalacheck-suite: StringOps.parseFloat") {
    forAll { i: Float =>
      i.toString.parseFloat === i.asRight[NumberFormatException]
    }

    forAll { i: Float =>
      i.toString.parseFloat.toOption === i.toString.parseFloatOption
    }

    forAll { i: Float =>
      i.toString.parseFloat.toValidated === i.toString.parseFloatValidated
    }
  }

  test("StringOps.parseByte") {
    assertEquals("123".parseByte, 123.toByte.asRight[NumberFormatException])
    assert("blah".parseByte === new NumberFormatException("For input string: \"blah\"").asLeft)
  }

  property("scalacheck-suite: StringOps.parseByte") {
    forAll { i: Byte =>
      i.toString.parseByte === i.asRight[NumberFormatException]
    }

    forAll { i: Byte =>
      i.toString.parseByte.toOption === i.toString.parseByteOption
    }

    forAll { i: Byte =>
      i.toString.parseByte.toValidated === i.toString.parseByteValidated
    }
  }

  test("StringOps.parseBigInt") {
    assertEquals("123".parseBigInt, BigInt("123").asRight[NumberFormatException])
    assert("blah".parseBigInt === new NumberFormatException("For input string: \"blah\"").asLeft)
  }

  property("scalacheck-suite: StringOps.parseBigInt") {
    forAll { i: BigInt =>
      i.toString.parseBigInt === i.asRight[NumberFormatException]
    }

    forAll { i: BigInt =>
      i.toString.parseBigInt.toOption === i.toString.parseBigIntOption
    }

    forAll { i: BigInt =>
      i.toString.parseBigInt.toValidated === i.toString.parseBigIntValidated
    }
  }

  test("StringOps.parseBigDecimal") {
    assert("123.45".parseBigDecimal === BigDecimal("123.45").asRight[NumberFormatException])

    // We assert the class of the exception because the error message differs between the JVM and JS
    assert("blah".parseBigDecimal.leftMap(_.getClass) == classOf[NumberFormatException].asLeft)
  }

  property("scalacheck-suite: StringOps.parseBigDecimal") {
    forAll { i: BigDecimal =>
      i.toString.parseBigDecimal === i.asRight[NumberFormatException]
    }

    forAll { i: BigDecimal =>
      i.toString.parseBigDecimal.toOption === i.toString.parseBigDecimalOption
    }

    forAll { i: BigDecimal =>
      i.toString.parseBigDecimal.toValidated === i.toString.parseBigDecimalValidated
    }
  }

  test("StringOps.parseBoolean") {
    assert("true".parseBoolean === true.asRight[IllegalArgumentException])
    assertEquals("true".parseBoolean.toOption, "true".parseBooleanOption)
    assertEquals("true".parseBoolean.toValidated, "true".parseBooleanValidated)
    assert("false".parseBoolean === false.asRight[IllegalArgumentException])
    assertEquals("false".parseBoolean.toOption, "false".parseBooleanOption)
    assertEquals("false".parseBoolean.toValidated, "false".parseBooleanValidated)
    assertEquals("TRUE".parseBoolean, "true".parseBoolean)
    assertEquals("FALSE".parseBoolean, "false".parseBoolean)
  }

  property("scalacheck-suite: StringOps.parseBoolean") {
    val stringGen: Gen[String] =
      Arbitrary.arbString.arbitrary.filter(s => !s.equalsIgnoreCase("true") && !s.equalsIgnoreCase("false"))

    forAll(stringGen) { s: String =>
      s.parseBoolean === new IllegalArgumentException("For input string: \"" + s + "\"").asLeft
    }
  }

  property("asThrowable, asError and asException") {
    forAll { s: String =>
      assert(s.asThrowable.toString === new Throwable(s).toString)
      assert(s.asError.toString === new Error(s).toString)
      assert(s.asException.toString === new java.lang.Exception(s).toString)
    }
  }
}

final class EitherIdOps[A](val obj: A) extends AnyVal {
  /** Wrap a value in `Left`. */
  def asLeft[B]: Either[A, B] = Left(obj)

  /** Wrap a value in `Right`. */
  def asRight[B]: Either[B, A] = Right(obj)
}
