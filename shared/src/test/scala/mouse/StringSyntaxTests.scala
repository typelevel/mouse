package mouse

import mouse.string._
import cats.syntax.all._

class StringSyntaxTests extends MouseSuite:

  testEquals("123".toIntEither, 123.asRight)
  testEquals("123".toIntValidated, 123.valid)
  testEquals("blah".toIntEither, "blah".asLeft)
  testEquals("blah".toIntValidated, "blah".invalid)
  
  testEquals("123".toLongEither, 123L.asRight)
  testEquals("123".toLongValidated, 123L.valid)
  testEquals("blah".toLongEither, "blah".asLeft)
  testEquals("blah".toLongValidated, "blah".invalid)
  
  testEquals("true".toBooleanEither, true.asRight)
  testEquals("true".toBooleanValidated, true.valid)
  testEquals("blah".toBooleanEither, "blah".asLeft)
  testEquals("blah".toBooleanValidated, "blah".invalid)
  
  testEquals("123".toShortEither, (123: Short).asRight)
  testEquals("123".toShortValidated, (123: Short).valid)
  testEquals("blah".toShortEither, "blah".asLeft)
  testEquals("blah".toShortValidated, "blah".invalid)
  
  testEquals("123".toByteEither, (123: Byte).asRight)
  testEquals("123".toByteValidated, (123: Byte).valid)
  testEquals("blah".toByteEither, "blah".asLeft)
  testEquals("blah".toByteValidated, "blah".invalid)
  
  testEquals("123.4".toFloatEither, 123.4f.asRight)
  testEquals("123.4".toFloatValidated, 123.4f.valid)
  testEquals("blah".toFloatEither, "blah".asLeft)
  testEquals("blah".toFloatValidated, "blah".invalid)
  
  testEquals("123.4".toDoubleEither, 123.4.asRight)
  testEquals("123.4".toDoubleValidated, 123.4.valid)
  testEquals("blah".toDoubleEither, "blah".asLeft)
  testEquals("blah".toDoubleValidated, "blah".invalid)
  
  testEquals("123.4".toBigDecimalEither, BigDecimal("123.4").asRight)
  testEquals("123.4".toBigDecimalValidated, BigDecimal("123.4").valid)
  testEquals("blah".toBigDecimalEither, "blah".asLeft)
  testEquals("blah".toBigDecimalValidated, "blah".invalid)
  
  testEquals("123".toBigIntEither, BigInt(123).asRight)
  testEquals("123".toBigIntValidated, BigInt(123).valid)
  testEquals("blah".toBigIntEither, "blah".asLeft)
  testEquals("blah".toBigIntValidated, "blah".invalid)