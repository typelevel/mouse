package mouse

import cats.{Applicative, Semigroup}

trait MapSyntax {
  implicit final def mapSyntaxMouse[A, B](map: Map[A, B]): MapOps[A, B] = new MapOps(map)
}

final class MapOps[A, B](private val map: Map[A, B]) extends AnyVal {

  def mapKeys[C](f: A => C): Map[C, B] = map.map { case (a, b) => (f(a), b) }

  def updateAtKey(key: A, f: B => B): Map[A, B] = map.get(key).fold(map)(value => map.updated(key, f(value)))

  def updateAtKeyF[F[_]](key: A, f: B => F[B])(implicit F: Applicative[F]): F[Map[A, B]] =
    map.get(key).fold(F.pure(map))(value => F.map(f(value))(result => map.updated(key, result)))

  def updateAtKeyCombine(key: A, add: B)(implicit sg: Semigroup[B]): Map[A, B] =
    map.get(key).fold(map + (key -> add))(value => map.updated(key, sg.combine(value, add)))
}
