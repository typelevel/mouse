package mouse

import mouse.partialFunction._

class PartialFunctionLiftTest extends MouseSuite:

  val f = liftEither[Option[Int]]({case Some(n) => n}, a => s"Unexpected: $a")

  testEquals(f(Some(6)), Right(6))

  testEquals(f(None), Left("Unexpected: None"))
