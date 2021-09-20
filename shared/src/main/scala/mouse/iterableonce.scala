package mouse

import compat.scalaVersionSpecific._

trait IterableOnceSyntax {
  implicit final def iterableOnceStringSyntaxMouse(i: IterableOnce[String]): IterableOnceStringOps =
    new IterableOnceStringOps(i)
}

final class IterableOnceStringOps(private val i: IterableOnce[String]) extends AnyVal {

  @inline def unlines: String = (i.iterator ++ Iterator("")).mkString("\n")
}
