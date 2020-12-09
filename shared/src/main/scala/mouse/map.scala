package mouse

import cats.{Applicative, Semigroup}

object map:
  extension [A, B](map: Map[A, B]):
    def updateAtKey(key: A, f: B => B): Map[A, B] = map.get(key).fold(map)(value => map.updated(key, f(value)))

    def updateAtKeyCombine(key: A, add: B)(using sg: Semigroup[B]): Map[A, B] =
      map.get(key).fold(map + (key -> add))(value => map.updated(key, sg.combine(value, add)))

  extension [A, B, C](map: Map[A, B]):
    def mapKeys(f: A => C): Map[C, B] = map.map((a, b) => (f(a), b))

  extension [A, B, F[_]](map: Map[A, B]):
    def updateAtKeyF(key: A, f: B => F[B])(using F: Applicative[F]): F[Map[A, B]] =
      map.get(key).fold(F.pure(map))(value => F.map(f(value))(result => map.updated(key, result)))