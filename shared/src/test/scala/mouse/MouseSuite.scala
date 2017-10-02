package mouse

import cats._
import cats.instances.AllInstances
import org.scalactic.TripleEqualsSupport.BToAEquivalenceConstraint
import org.scalactic.{CanEqual, Equivalence}
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{Matchers, FunSuite}

trait MouseSuite
  extends FunSuite
    with Matchers
    with GeneratorDrivenPropertyChecks
    with AllSyntax
    with AllInstances {
  implicit val eq0: Eq[NumberFormatException] =
    (x: NumberFormatException, y: NumberFormatException) => x.getMessage == y.getMessage

  implicit val eq1: Eq[IllegalArgumentException] =
    (x: IllegalArgumentException, y: IllegalArgumentException) => x.getMessage == y.getMessage

  final class MouseEquivalence[T](T: Eq[T]) extends Equivalence[T] {
    def areEquivalent(a: T, b: T): Boolean = T.eqv(a, b)
  }

  implicit def mouseCanEqual[A, B](implicit A: Eq[A], ev: B <:< A): CanEqual[A, B] =
    new BToAEquivalenceConstraint[A, B](new MouseEquivalence(A), ev)
}
