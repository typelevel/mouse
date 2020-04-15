package mouse

import java.net.{MalformedURLException, URI, URISyntaxException, URL}

import cats.data.Validated
import cats.syntax.either._

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

}
