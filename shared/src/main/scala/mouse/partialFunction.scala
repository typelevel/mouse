package mouse

trait PartialFunctionLift {

  def liftEither[A]: PartialFunctionLift.LiftEitherPartiallyApplied[A] = new PartialFunctionLift.LiftEitherPartiallyApplied()

}
object PartialFunctionLift {

  //https://typelevel.org/cats/guidelines.html#partially-applied-type-params
  private[mouse] final class LiftEitherPartiallyApplied[A](private val dummy: Boolean = true ) extends AnyVal {
    def apply[B, C](pf: PartialFunction[A, B], orElse: A => C): A => Either[C, B] =
      (a: A) => pf.lift(a).toRight(orElse(a))
  }

}

