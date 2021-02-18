package mouse

import mouse.`try`._
import scala.util.{Failure, Success, Try}
import cats.data.EitherT

class TrySyntaxTest extends MouseSuite:

  testEquals(Try("foo").toEitherT[Option], EitherT.fromEither[Option](Try("foo").toEither))