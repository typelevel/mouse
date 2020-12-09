package mouse

import cats._
import cats.syntax.all._
import cats.instances.AllInstances

import munit._

import munit.internal.console.{Lines, Printers, StackTraces}
import munit.internal.difflib.Diffs

import scala.reflect.ClassTag
import scala.util.control.NonFatal
import scala.collection.mutable
import munit.internal.console.AnsiColors
import org.junit.AssumptionViolatedException
import munit.internal.MacroCompat

trait MouseSuite extends munit.FunSuite:

  given Eq[Array[Byte]] = Eq.instance(_ sameElements _)

  given [T <: Throwable] as Eq[T] = Eq.instance(_.getMessage == _.getMessage)
  
  def testEquals[T: Eq](obtained: T, expected: T): Unit =
    test(getClass.getSimpleName)(assertEq(obtained, expected))

  def assertEq[T: Eq](
                       obtained: T,
                       expected: T,
                       clue: => Any = "values are not the same"
                     )(implicit loc: munit.Location): Unit = {
    StackTraces.dropInside {
      if (obtained =!= expected) {
        Diffs.assertNoDiff(
          munitPrint(obtained),
          munitPrint(expected),
          message => fail(message),
          munitPrint(clue),
          printObtainedAsStripMargin = false
        )
        // try with `.toString` in case `munitPrint()` produces identical formatting for both values.
        Diffs.assertNoDiff(
          obtained.toString(),
          expected.toString(),
          message => fail(message),
          munitPrint(clue),
          printObtainedAsStripMargin = false
        )
        fail(
          s"values are not equal even if they have the same `toString()`: $obtained"
        )
      }
    }
  }