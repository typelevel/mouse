package mouse

import java.net.{MalformedURLException, URI, URISyntaxException, URL}
import cats.Eq
import cats.syntax.all._
import mouse.string._

import java.util.UUID

class StringJvmTests extends MouseSuite {
  test("parseFloat") {
    assertEquals("123.1".parseFloat, 123.1f.asRight[NumberFormatException])
  }

  test("parseURL") {
    implicit val urlEq: Eq[URL] = Eq.fromUniversalEquals
    implicit val malformedURLExceptionEq: Eq[MalformedURLException] =
      new Eq[MalformedURLException] {
        override def eqv(x: MalformedURLException, y: MalformedURLException): Boolean =
          x.getMessage == y.getMessage
      }

    assertEquals(
      "http://example.com".parseURL,
      new URL("http://example.com").asRight[MalformedURLException]
    )

    assertEquals("blah".parseURL.leftMap(_.getMessage), "no protocol: blah".asLeft)
  }

  test("parseURI") {
    assertEquals("http://example.com".parseURI, new URI("http://example.com").asRight[URISyntaxException])

    assertEquals(
      "invalid uri".parseURI.leftMap(e => e.getInput -> e.getReason),
      ("invalid uri", "Illegal character in path").asLeft
    )
  }

  test("parseUUID") {
    val validUUIDStr = "00000000-0000-0000-0000-000000000000"
    val invalidUUIDStr = "invalid"

    assertEquals(validUUIDStr.parseUUID, UUID.fromString(validUUIDStr).asRight[IllegalArgumentException])
    assertEquals(validUUIDStr.parseUUID.toValidated, validUUIDStr.parseUUIDValidated)
    assertEquals(validUUIDStr.parseUUID.toOption, validUUIDStr.parseUUIDOption)

    assertEquals(
      invalidUUIDStr.parseUUID.leftMap(_.getMessage),
      "Invalid UUID string: invalid".asLeft[UUID]
    )

    assertEquals(
      invalidUUIDStr.parseUUID.toValidated.leftMap(_.getMessage),
      invalidUUIDStr.parseUUIDValidated.leftMap(_.getMessage)
    )

    assertEquals(invalidUUIDStr.parseUUID.toOption, None)
  }
}
