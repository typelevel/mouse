package mouse

trait SetSyntax {
  implicit final def setyntaxMouse[A](set: Set[A]): SetOps[A] = new SetOps[A](set)
}

final class SetOps[A](private val sa: Set[A]) extends AnyVal {

  /**
   * `Set.empty[A].tail` throws an exception, whereas `Set.empty[A].safeTail` produces `Set.empty[A]`
   */
  @inline def tailOrEmpty: Set[A] = sa.drop(1)

  /**
   * Some if there's elements in the tail, None if there's not
   */
  @inline def tailOption: Option[Set[A]] = Option(tailOrEmpty).filterNot(_.isEmpty)

}
