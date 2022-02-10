import sbt._

import Boilerplate._
import Boilerplate.{Template, TemplateVals}
import sbt.File

object GenFTupleNSyntax extends Template {
  // we generate syntax for Tuple3..22 because already there is [[cats.syntax.FunctorTuple2Ops]].
  override def range = 3 to maxArity
  override def filename(root: sbt.File): File =
    root / "mouse" / "FTupleNSyntax.scala"

  override def content(tv: TemplateVals): String = {
    import tv._

    val generatedFunctions: String =
      (1 to arity)
        .map { n =>
          s"""
          -  /**
          -   * Lifts [[Tuple$arity._$n]] into `F[_]`.
          -   */
          -  def _${n}F(implicit F: Functor[F]): F[A${n - 1}] = F.map(ftuple)(_._$n)
          -
          """
        }
        .mkString("\n")

    block"""
    |
    |import cats.Functor
    |
    |trait FTupleNSyntax {
      -  implicit final def mouseSyntaxFTuple${arity}Ops[F[_], ${`A..N`}](ftuple: F[(${`A..N`})]): FTuple${arity}Ops[F, ${`A..N`}] = new FTuple${arity}Ops[F, ${`A..N`}](ftuple)
      -
      -  private[mouse] final class FTuple${arity}Ops[F[_], ${`A..N`}](ftuple: F[(${`A..N`})]) extends Serializable {
           $generatedFunctions
      -  }
      -
    |}"""
  }
}
