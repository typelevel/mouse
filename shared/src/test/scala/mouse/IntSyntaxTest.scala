package mouse

class IntSyntaxTest extends MouseSuite {

  123456789.toByteArray shouldEqual Array(7, 91, -51, 21)

  123456789.toBase64 shouldEqual "B1vNFQ"

  7.squared shouldEqual 49

}
