/*
 * Copyright (c) 2016 Typelevel
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

import java.net.{MalformedURLException, URI, URISyntaxException, URL}
import cats.Eq
import cats.syntax.all._

import java.util.UUID

class StringJvmTests extends MouseSuite with StringJvmSyntax {
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
