package mouse

import org.scalacheck.Arbitrary._
import org.scalacheck.{Arbitrary, Gen}
import cats.syntax.all._

class StringSyntaxTests extends MouseSuite {

  test("parseInt") {
    "123".parseInt should ===(123.right[NumberFormatException])

    "blah".parseInt should ===(new NumberFormatException("For input string: \"blah\"").left)

    forAll { i: Int =>
      i.toString.parseInt should ===(i.right[NumberFormatException])
    }

    forAll { i: Int =>
      i.toString.parseInt.toOption should ===(i.toString.parseIntOption)
    }

    forAll { i: Int =>
      i.toString.parseInt.toValidated should ===(i.toString.parseIntValidated)
    }

  }

  test("parseLong") {
    "123".parseLong should ===(123L.right[NumberFormatException])

    "blah".parseLong should ===(new NumberFormatException("For input string: \"blah\"").left)

    forAll { i: Long =>
      i.toString.parseLong should ===(i.right[NumberFormatException])
    }

    forAll { i: Long =>
      i.toString.parseLong.toOption should ===(i.toString.parseLongOption)
    }

    forAll { i: Long =>
      i.toString.parseLong.toValidated should ===(i.toString.parseLongValidated)
    }

  }

  test("parseShort") {
    "123".parseShort should ===(123.toShort.right[NumberFormatException])

    "blah".parseShort should ===(new NumberFormatException("For input string: \"blah\"").left)

    forAll { i: Short =>
      i.toString.parseShort should ===(i.right[NumberFormatException])
    }

    forAll { i: Short =>
      i.toString.parseShort.toOption should ===(i.toString.parseShortOption)
    }

    forAll { i: Short =>
      i.toString.parseShort.toValidated should ===(i.toString.parseShortValidated)
    }

  }

  test("parseDouble") {
    "123.1".parseDouble should ===(123.1.right[NumberFormatException])

    "blah".parseDouble should ===(new NumberFormatException("For input string: \"blah\"").left)

    forAll { i: Double =>
      i.toString.parseDouble should ===(i.right[NumberFormatException])
    }

    forAll { i: Double =>
      i.toString.parseDouble.toOption should ===(i.toString.parseDoubleOption)
    }

    forAll { i: Double =>
      i.toString.parseDouble.toValidated should ===(i.toString.parseDoubleValidated)
    }
  }

  test("parseFloat") {
    "blah".parseFloat should ===(new NumberFormatException("For input string: \"blah\"").left)

    forAll { i: Float =>
      i.toString.parseFloat should ===(i.right[NumberFormatException])
    }

    forAll { i: Float =>
      i.toString.parseFloat.toOption should ===(i.toString.parseFloatOption)
    }

    forAll { i: Float =>
      i.toString.parseFloat.toValidated should ===(i.toString.parseFloatValidated)
    }
  }

  test("parseByte") {
    "123".parseByte should ===(123.toByte.right[NumberFormatException])

    "blah".parseByte should ===(new NumberFormatException("For input string: \"blah\"").left)

    forAll { i: Byte =>
      i.toString.parseByte should ===(i.right[NumberFormatException])
    }

    forAll { i: Byte =>
      i.toString.parseByte.toOption should ===(i.toString.parseByteOption)
    }

    forAll { i: Byte =>
      i.toString.parseByte.toValidated should ===(i.toString.parseByteValidated)
    }
  }

  test("parseBoolean") {
    "true".parseBoolean should ===(true.right[IllegalArgumentException])
    "true".parseBoolean.toOption should ===("true".parseBooleanOption)
    "true".parseBoolean.toValidated should ===("true".parseBooleanValidated)
    "false".parseBoolean should ===(false.right[IllegalArgumentException])
    "false".parseBoolean.toOption should ===("false".parseBooleanOption)
    "false".parseBoolean.toValidated should ===("false".parseBooleanValidated)

    "TRUE".parseBoolean should ===("true".parseBoolean)
    "FALSE".parseBoolean should ===("false".parseBoolean)

    val stringGen: Gen[String] = Arbitrary.arbString.arbitrary.filter(s => !s.equalsIgnoreCase("true") && !s.equalsIgnoreCase("false"))

    forAll(stringGen) { s: String =>
      s.parseBoolean should ===(new IllegalArgumentException("For input string: \"" + s + "\"").left)
    }
  }

}
