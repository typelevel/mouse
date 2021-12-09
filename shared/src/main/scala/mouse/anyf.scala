package mouse

import cats.data.EitherT
import cats.data.OptionT
import cats.~>
import cats.Functor

trait AnyFSyntax {
  implicit final def anyfSyntaxMouse[F[_], A](fa: F[A]): AnyFOps[F, A] = new AnyFOps(fa)
}

final class AnyFOps[F[_], A](private val fa: F[A]) extends AnyVal {
  @inline def ||>[G[_]](f: F ~> G): G[A] = f(fa)
  @inline def thrushK[G[_]](f: F ~> G): G[A] = f(fa)

  def liftRightT[E](implicit F: Functor[F]): EitherT[F, E, A] =
    EitherT.right[E](fa)

  def liftSomeT(implicit F: Functor[F]): OptionT[F, A] =
    OptionT.liftF(fa)

}
