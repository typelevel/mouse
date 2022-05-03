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
import cats.data.Validated
import cats.syntax.either._

import java.util.UUID

trait StringJvmSyntax {
  implicit def stringJvmSyntaxMouse(s: String): JvmStringOps = new JvmStringOps(s)
}

final class JvmStringOps(private val s: String) extends AnyVal {

  @inline def parseURL: MalformedURLException Either URL = Either.catchOnly[MalformedURLException](new URL(s))

  @inline def parseURLValidated: Validated[MalformedURLException, URL] = parseURL.toValidated

  @inline def parseURLOption: Option[URL] = parseURL.toOption

  @inline def parseURI: URISyntaxException Either URI = Either.catchOnly[URISyntaxException](new URI(s))

  @inline def parseURIValidated: Validated[URISyntaxException, URI] = parseURI.toValidated

  @inline def parseURIOption: Option[URI] = parseURI.toOption

  @inline def parseUUID: IllegalArgumentException Either UUID =
    Either.catchOnly[IllegalArgumentException](UUID.fromString(s))

  @inline def parseUUIDValidated: Validated[IllegalArgumentException, UUID] = parseUUID.toValidated

  @inline def parseUUIDOption: Option[UUID] = parseUUID.toOption

}
