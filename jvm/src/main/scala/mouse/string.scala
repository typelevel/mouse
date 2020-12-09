package mouse

import java.net.{MalformedURLException, URI, URISyntaxException, URL}

import cats.data.Validated
import cats.syntax.either._

object stringJvm:
  extension (s: String):

    @inline def parseURL: Either[MalformedURLException, URL] = Either.catchOnly[MalformedURLException](new URL(s))

    @inline def parseURLValidated: Validated[MalformedURLException, URL] = parseURL.toValidated

    @inline def parseURLOption: Option[URL] = parseURL.toOption

    @inline def parseURI: Either[URISyntaxException, URI] = Either.catchOnly[URISyntaxException](new URI(s))

    @inline def parseURIValidated: Validated[URISyntaxException, URI] = parseURI.toValidated

    @inline def parseURIOption: Option[URI] = parseURI.toOption

