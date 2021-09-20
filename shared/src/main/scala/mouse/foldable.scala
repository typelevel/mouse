package mouse

import cats.Foldable
import cats.implicits._
import mouse.iterableonce._

trait FoldableSyntax {
  implicit final def foldableStringSyntaxMouse[F[_]: Foldable](i: F[String]): FoldableStringOps[F] =
    new FoldableStringOps(i)
}

final class FoldableStringOps[F[_]](private val fa: F[String]) extends AnyVal {

  @inline def unlines_(implicit F: Foldable[F]): String = fa.toIterable.iterator.unlines
}
