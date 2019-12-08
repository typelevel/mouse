package mouse

import cats._
import cats.instances.AllInstances
import org.scalactic.TripleEqualsSupport.BToAEquivalenceConstraint
import org.scalactic.{CanEqual, Equivalence}
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

trait MouseSuite
  extends AnyFunSuite
    with Matchers
    with ScalaCheckDrivenPropertyChecks
    with AllSharedSyntax
    with AllInstances {
  implicit val eq0 = new Eq[NumberFormatException] {
    override def eqv(x: NumberFormatException, y: NumberFormatException): Boolean =
      x.getMessage == y.getMessage
  }

  implicit val eq1 = new Eq[IllegalArgumentException] {
    override def eqv(x: IllegalArgumentException, y: IllegalArgumentException): Boolean =
      x.getMessage == y.getMessage
  }

  final class MouseEquivalence[T](T: Eq[T]) extends Equivalence[T] {
    def areEquivalent(a: T, b: T): Boolean = T.eqv(a, b)
  }

  implicit def mouseCanEqual[A, B](implicit A: Eq[A], ev: B <:< A): CanEqual[A, B] =
    new BToAEquivalenceConstraint[A, B](new MouseEquivalence(A), ev)
}
