package mouse

import java.net.{MalformedURLException, URI, URISyntaxException, URL}

import cats.Eq
import cats.syntax.all._
import mouse.stringJvm._

class StringJvmTests extends MouseSuite:
  
  given Eq[URL] = Eq.fromUniversalEquals
  given Eq[URI] = Eq.fromUniversalEquals

  testEquals("http://example.com".parseURL, URL("http://example.com").asRight[MalformedURLException])
  testEquals("blah".parseURL, new MalformedURLException("no protocol: blah").asLeft)
  testEquals("http://example.com".parseURI, new URI("http://example.com").asRight[URISyntaxException])
  testEquals("invalid uri".parseURI, new URISyntaxException("invalid uri", "Illegal character in path at index 7").asLeft)
