package mouse

import java.net.{MalformedURLException, URL}

import cats.Eq
import cats.syntax.all._
import mouse.string._

class StringJvmTests extends MouseSuite {

  test("parseFloat") {
    "123.1".parseFloat should ===(123.1f.asRight[NumberFormatException])
  }

  test("parseURL") {
    implicit val urlEq: Eq[URL] = Eq.fromUniversalEquals
    implicit val malformedURLExceptionEq: Eq[MalformedURLException] = _.getMessage == _.getMessage

    "http://example.com".parseURL should ===(new URL("http://example.com").asRight[MalformedURLException])

    "blah".parseURL should ===(new MalformedURLException("no protocol: blah").asLeft)
  }

}
