package mouse

trait MapSyntax {
  implicit final def mapSyntaxMouse[A, B](map: Map[A, B]): MapOps[A, B] = new MapOps(map)
}

final class MapOps[A, B](private val map: Map[A, B]) extends AnyVal {

  def mapKeys[C](f: A => C): Map[C, B] = map.map { case (a, b) => (f(a), b) }
}
