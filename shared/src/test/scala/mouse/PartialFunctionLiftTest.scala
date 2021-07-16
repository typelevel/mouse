package mouse

class PartialFunctionLiftTest extends MouseSuite {
  private val f = liftEither[Option[Int]]({case Some(n) => n}, a => s"Unexpected: $a")

  test("PartialFunctionLift.liftEither") {
    assertEquals(f(Some(6)), Right(6))
    assertEquals(f(None), Left("Unexpected: None"))
  }
}
