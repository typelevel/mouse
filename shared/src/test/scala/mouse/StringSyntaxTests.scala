/*
 * Copyright (c) 2022 Typelevel
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

import cats.syntax.all._
import org.scalacheck.Arbitrary._
import org.scalacheck.Prop._
import org.scalacheck.{Arbitrary, Gen}

class StringSyntaxTests extends MouseSuite {
  test("StringOps.parseInt") {
    assertEquals("123".parseInt, 123.asRight[NumberFormatException])
    assertEquals("blah".parseInt.leftMap(_.getMessage), "For input string: \"blah\"".asLeft)
  }

  property("scalacheck-suite: StringOps.parseInt") {
    forAll { (i: Int) =>
      assertEquals(i.toString.parseInt, i.asRight[NumberFormatException])
    }

    forAll { (i: Int) =>
      assertEquals(i.toString.parseInt.toOption, i.toString.parseIntOption)
    }

    forAll { (i: Int) =>
      assertEquals(i.toString.parseInt.toValidated, i.toString.parseIntValidated)
    }
  }

  test("StringOps.parseLong") {
    assertEquals("123".parseLong, 123L.asRight[NumberFormatException])
    assertEquals("blah".parseLong.leftMap(_.getMessage), "For input string: \"blah\"".asLeft)
  }

  property("scalacheck-suite: StringOps.parseLong") {
    forAll { (i: Long) =>
      assertEquals(i.toString.parseLong, i.asRight[NumberFormatException])
    }

    forAll { (i: Long) =>
      assertEquals(i.toString.parseLong.toOption, i.toString.parseLongOption)
    }

    forAll { (i: Long) =>
      assertEquals(i.toString.parseLong.toValidated, i.toString.parseLongValidated)
    }
  }

  test("StringOps.parseShort") {
    assertEquals("123".parseShort, 123.toShort.asRight[NumberFormatException])
    assertEquals("blah".parseShort.leftMap(_.getMessage), "For input string: \"blah\"".asLeft)
  }

  property("scalacheck-suite: StringOps.parseShort") {
    forAll { (i: Short) =>
      assertEquals(i.toString.parseShort, i.asRight[NumberFormatException])
    }

    forAll { (i: Short) =>
      assertEquals(i.toString.parseShort.toOption, i.toString.parseShortOption)
    }

    forAll { (i: Short) =>
      assertEquals(i.toString.parseShort.toValidated, i.toString.parseShortValidated)
    }
  }

  test("StringOps.parseDouble") {
    assertEquals("123.1".parseDouble, 123.1.asRight[NumberFormatException])
    assertEquals("blah".parseDouble.leftMap(_.getMessage), "For input string: \"blah\"".asLeft)
  }

  property("scalacheck-suite: StringOps.parseDouble") {
    forAll { (i: Double) =>
      assertEquals(i.toString.parseDouble, i.asRight[NumberFormatException])
    }

    forAll { (i: Double) =>
      assertEquals(i.toString.parseDouble.toOption, i.toString.parseDoubleOption)
    }

    forAll { (i: Double) =>
      assertEquals(i.toString.parseDouble.toValidated, i.toString.parseDoubleValidated)
    }
  }

  test("StringOps.parseFloat") {
    assertEquals("blah".parseFloat.leftMap(_.getMessage), "For input string: \"blah\"".asLeft)
  }

  property("scalacheck-suite: StringOps.parseFloat") {
    forAll { (i: Float) =>
      assertEquals(i.toString.parseFloat, i.asRight[NumberFormatException])
    }

    forAll { (i: Float) =>
      assertEquals(i.toString.parseFloat.toOption, i.toString.parseFloatOption)
    }

    forAll { (i: Float) =>
      assertEquals(i.toString.parseFloat.toValidated, i.toString.parseFloatValidated)
    }
  }

  test("StringOps.parseByte") {
    assertEquals("123".parseByte, 123.toByte.asRight[NumberFormatException])
    assertEquals("blah".parseByte.leftMap(_.getMessage), "For input string: \"blah\"".asLeft)
  }

  property("scalacheck-suite: StringOps.parseByte") {
    forAll { (i: Byte) =>
      assertEquals(i.toString.parseByte, i.asRight[NumberFormatException])
    }

    forAll { (i: Byte) =>
      assertEquals(i.toString.parseByte.toOption, i.toString.parseByteOption)
    }

    forAll { (i: Byte) =>
      assertEquals(i.toString.parseByte.toValidated, i.toString.parseByteValidated)
    }
  }

  test("StringOps.parseBigInt") {
    assertEquals("123".parseBigInt, BigInt("123").asRight[NumberFormatException])
    assertEquals("blah".parseBigInt.leftMap(_.getMessage), "For input string: \"blah\"".asLeft)
  }

  property("scalacheck-suite: StringOps.parseBigInt") {
    forAll { (i: BigInt) =>
      assertEquals(i.toString.parseBigInt, i.asRight[NumberFormatException])
    }

    forAll { (i: BigInt) =>
      assertEquals(i.toString.parseBigInt.toOption, i.toString.parseBigIntOption)
    }

    forAll { (i: BigInt) =>
      assertEquals(i.toString.parseBigInt.toValidated, i.toString.parseBigIntValidated)
    }
  }

  test("StringOps.parseBigDecimal") {
    assertEquals("123.45".parseBigDecimal, BigDecimal("123.45").asRight[NumberFormatException])

    // We assert the class of the exception because the error message differs between the JVM and JS
    assertEquals("blah".parseBigDecimal.leftMap(_.getClass.toString), classOf[NumberFormatException].toString.asLeft)
  }

  property("scalacheck-suite: StringOps.parseBigDecimal") {
    forAll { (i: BigDecimal) =>
      assertEquals(i.toString.parseBigDecimal, i.asRight[NumberFormatException])
    }

    forAll { (i: BigDecimal) =>
      assertEquals(i.toString.parseBigDecimal.toOption, i.toString.parseBigDecimalOption)
    }

    forAll { (i: BigDecimal) =>
      assertEquals(i.toString.parseBigDecimal.toValidated, i.toString.parseBigDecimalValidated)
    }
  }

  test("StringOps.parseBoolean") {
    assertEquals("true".parseBoolean, true.asRight[IllegalArgumentException])
    assertEquals("true".parseBoolean.toOption, "true".parseBooleanOption)
    assertEquals("true".parseBoolean.toValidated, "true".parseBooleanValidated)
    assertEquals("false".parseBoolean, false.asRight[IllegalArgumentException])
    assertEquals("false".parseBoolean.toOption, "false".parseBooleanOption)
    assertEquals("false".parseBoolean.toValidated, "false".parseBooleanValidated)
    assertEquals("TRUE".parseBoolean, "true".parseBoolean)
    assertEquals("FALSE".parseBoolean, "false".parseBoolean)
  }

  property("scalacheck-suite: StringOps.parseBoolean") {
    val stringGen: Gen[String] =
      Arbitrary.arbString.arbitrary.filter(s => !s.equalsIgnoreCase("true") && !s.equalsIgnoreCase("false"))

    forAll(stringGen) { (s: String) =>
      assertEquals(s.parseBoolean.leftMap(_.getMessage), ("For input string: \"" + s + "\"").asLeft)
    }
  }

  property("asThrowable, asError and asException") {
    forAll { (s: String) =>
      assertEquals(s.asThrowable.toString, new Throwable(s).toString)
      assertEquals(s.asError.toString, new Error(s).toString)
      assertEquals(s.asException.toString, new java.lang.Exception(s).toString)
    }
  }
}

final class EitherIdOps[A](val obj: A) extends AnyVal {

  /**
   * Wrap a value in `Left`.
   */
  def asLeft[B]: Either[A, B] = Left(obj)

  /**
   * Wrap a value in `Right`.
   */
  def asRight[B]: Either[B, A] = Right(obj)
}
