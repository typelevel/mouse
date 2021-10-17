package mouse

import cats.{FlatMap, Functor}

trait FNestedSyntax {
  implicit final def fnested2SyntaxMouse[F[_], G[_], A](fga: F[G[A]]): FNested2SyntaxOps[F, G, A] =
    new FNested2SyntaxOps[F, G, A](fga)

  implicit final def fnested3SyntaxMouse[F[_], G[_], H[_], A](fgha: F[G[H[A]]]): FNested3SyntaxOps[F, G, H, A] =
    new FNested3SyntaxOps[F, G, H, A](fgha)
}

final class FNested2SyntaxOps[F[_], G[_], A](private val fga: F[G[A]]) extends AnyVal {
  def mapNested[B](f: A => B)(implicit F: Functor[F], G: Functor[G]): F[G[B]] =
    F.map(fga)(ga => G.map(ga)(f))

  def flatMapNested[B](f: A => G[B])(implicit F: Functor[F], G: FlatMap[G]): F[G[B]] =
    F.map(fga)(ga => G.flatMap(ga)(f))
}

final class FNested3SyntaxOps[F[_], G[_], H[_], A](private val fgha: F[G[H[A]]]) extends AnyVal {
  def mapNested[B](f: A => B)(implicit F: Functor[F], G: Functor[G], H: Functor[H]): F[G[H[B]]] =
    F.map(fgha)(gha => G.map(gha)(ha => H.map(ha)(f)))

  def flatMapNested[B](f: A => H[B])(implicit F: Functor[F], G: Functor[G], H: FlatMap[H]): F[G[H[B]]] =
    F.map(fgha)(gha => G.map(gha)(ha => H.flatMap(ha)(f)))
}
