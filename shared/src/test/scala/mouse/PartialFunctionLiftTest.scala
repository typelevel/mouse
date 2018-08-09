package mouse

class PartialFunctionLiftTest extends MouseSuite {

  val f = liftEither[Option[Int]]({case Some(n) => n}, a => s"Unexpected: $a")

  f(Some(6)) shouldEqual Right(6)

  f(None) shouldEqual Left("Unexpected: None")

}
