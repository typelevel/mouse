package mouse

import java.net.{MalformedURLException, URL}

import cats.data.Validated
import cats.syntax.either._

trait StringJvmSyntax {
  implicit def stringJvmSyntaxMouse(s: String): JvmStringOps = new JvmStringOps(s)
}

final class JvmStringOps(val s: String) extends AnyVal {

  @inline def parseURL: MalformedURLException Either URL = Either.catchOnly[MalformedURLException](new URL(s))

  @inline def parseURLValidated: Validated[MalformedURLException, URL] = parseURL.toValidated

  @inline def parseURLOption: Option[URL] = parseURL.toOption

}
