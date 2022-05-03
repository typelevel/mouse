/*
 * Copyright (c) 2016 Typelevel
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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
