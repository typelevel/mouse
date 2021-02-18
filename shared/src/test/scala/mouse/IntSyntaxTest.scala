package mouse

import mouse.int._

class IntSyntaxTest extends MouseSuite:

  testEquals(123456789.toByteArray, Array[Byte](7, 91, -51, 21))

  testEquals(123456789.toBase64, "B1vNFQ")

  testEquals(7.squared, 49)