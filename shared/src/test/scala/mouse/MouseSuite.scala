package mouse

import cats.Eq
import cats.instances.AllInstances
import munit.FunSuite
import munit.ScalaCheckSuite

trait MouseSuite
  extends FunSuite
    with ScalaCheckSuite
    with AllSharedSyntax
    with AllInstances {
  implicit val eq0: Eq[NumberFormatException] =
    (x: NumberFormatException, y: NumberFormatException) => x.getMessage == y.getMessage

  implicit val eq1: Eq[IllegalArgumentException] =
    (x: IllegalArgumentException, y: IllegalArgumentException) => x.getMessage == y.getMessage
}
