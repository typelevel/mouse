package mouse

class LongSyntaxTest extends MouseSuite {

  123456789123456789L.toByteArray shouldEqual Array(1, -74, -101, 75, -84, -48, 95, 21)

  123456789123456789L.toBase64 shouldEqual "AbabS6zQXxU"

  7L.squared shouldEqual 49L

}
