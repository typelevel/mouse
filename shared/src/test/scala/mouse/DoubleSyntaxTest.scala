package mouse

import cats.Eq

import mouse.double._

class DoubleSyntaxTest extends MouseSuite:

  testEquals(123456789.123456789.toByteArray, Array[Byte](65, -99, 111, 52, 84, 126, 107, 117))

  testEquals(1.5.squared, 2.25)


