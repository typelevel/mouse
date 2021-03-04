package mouse

import java.net.{MalformedURLException, URI, URISyntaxException, URL}
import cats.Eq
import cats.syntax.all._
import mouse.string._
import org.scalacheck.{Arbitrary, Gen}

import java.util.UUID
import scala.util.Try

class StringJvmTests extends MouseSuite {

  test("parseFloat") {
    "123.1".parseFloat should ===(123.1f.asRight[NumberFormatException])
  }

  test("parseURL") {
    implicit val urlEq: Eq[URL] = Eq.fromUniversalEquals
    implicit val malformedURLExceptionEq: Eq[MalformedURLException] =
      new Eq[MalformedURLException] {
        override def eqv(x: MalformedURLException, y: MalformedURLException): Boolean =
          x.getMessage == y.getMessage
      }

    "http://example.com".parseURL should ===(new URL("http://example.com").asRight[MalformedURLException])

    "blah".parseURL should ===(new MalformedURLException("no protocol: blah").asLeft)
  }

  test("parseURI") {
    implicit val urlEq: Eq[URI] = Eq.fromUniversalEquals
    implicit val malformedURIExceptionEq: Eq[URISyntaxException] =
      new Eq[URISyntaxException] {
        override def eqv(x: URISyntaxException, y: URISyntaxException): Boolean =
          x.getMessage == y.getMessage
      }

    "http://example.com".parseURI should ===(new URI("http://example.com").asRight[URISyntaxException])

    "invalid uri".parseURI should ===(new URISyntaxException("invalid uri", "Illegal character in path at index 7").asLeft)
  }

  test("parseUUID") {
    val validUUIDStr = "00000000-0000-0000-0000-000000000000"
    val invalidUUIDStr = "invalid"

    validUUIDStr.parseUUID should ===(UUID.fromString(validUUIDStr).asRight[IllegalArgumentException])
    validUUIDStr.parseUUID.toValidated should ===(validUUIDStr.parseUUIDValidated)
    validUUIDStr.parseUUID.toOption should ===(validUUIDStr.parseUUIDOption)

    invalidUUIDStr.parseUUID should ===(new IllegalArgumentException("Invalid UUID string: invalid").asLeft[UUID])
    invalidUUIDStr.parseUUID.toValidated should ===(invalidUUIDStr.parseUUIDValidated)
    invalidUUIDStr.parseUUID.toOption.isEmpty shouldBe true
  }

}
