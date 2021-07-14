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

   assert("blah".parseURL === new MalformedURLException("no protocol: blah").asLeft)
  }

  test("parseURI") {
    implicit val urlEq: Eq[URI] = Eq.fromUniversalEquals
    implicit val malformedURIExceptionEq: Eq[URISyntaxException] =
      new Eq[URISyntaxException] {
        override def eqv(x: URISyntaxException, y: URISyntaxException): Boolean =
          x.getMessage == y.getMessage
      }

    assertEquals("http://example.com".parseURI, new URI("http://example.com").asRight[URISyntaxException])

    assert(
      "invalid uri".parseURI === new URISyntaxException("invalid uri", "Illegal character in path at index 7").asLeft
    )
  }

  test("parseUUID") {
    val validUUIDStr = "00000000-0000-0000-0000-000000000000"
    val invalidUUIDStr = "invalid"

    assertEquals(validUUIDStr.parseUUID, UUID.fromString(validUUIDStr).asRight[IllegalArgumentException])
    assertEquals(validUUIDStr.parseUUID.toValidated, validUUIDStr.parseUUIDValidated)
    assertEquals(validUUIDStr.parseUUID.toOption, validUUIDStr.parseUUIDOption)

    assert(
      invalidUUIDStr.parseUUID === new IllegalArgumentException("Invalid UUID string: invalid").asLeft[UUID]
    )

    assert(invalidUUIDStr.parseUUID.toValidated === invalidUUIDStr.parseUUIDValidated)
    assert(invalidUUIDStr.parseUUID.toOption.isEmpty)
  }
}
