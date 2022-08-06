package mouse

trait ListSyntax {
  implicit final def listSyntaxMouse[A](list: List[A]): ListOps[A] = new ListOps[A](list)
}

final class ListOps[A](private val list: List[A]) extends AnyVal {

  /**
   * `Nil.tail` throws a runtime exception, whereas `Nil.tailOrEmpty` produces `Nil`
   */
  @inline def tailOrEmpty: List[A] = list.drop(1)

  /**
   * Some if there's elements in the tail, None if there's not
   */
  @inline def tailOption: Option[List[A]] = Option(tailOrEmpty).filterNot(_.isEmpty)

}
