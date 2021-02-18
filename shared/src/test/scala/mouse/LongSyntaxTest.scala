package mouse

import mouse.long._

class LongSyntaxTest extends MouseSuite:

  testEquals(123456789123456789L.toByteArray, Array[Byte](1, -74, -101, 75, -84, -48, 95, 21))

  testEquals(123456789123456789L.toBase64, "AbabS6zQXxU")

  testEquals(7L.squared, 49L)
