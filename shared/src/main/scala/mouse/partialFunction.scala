package mouse

object partialFunction:
  def liftEither[A]: LiftEitherPartiallyApplied[A] = new LiftEitherPartiallyApplied()

  //https://typelevel.org/cats/guidelines.html#partially-applied-type-params
  private[mouse] final class LiftEitherPartiallyApplied[A](private val dummy: Boolean = true) extends AnyVal:
    def apply[B, C](pf: PartialFunction[A, B], orElse: A => C): A => Either[C, B] =
      (a: A) => pf.lift(a).toRight(orElse(a))

