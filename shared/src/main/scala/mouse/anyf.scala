package mouse
import cats.~>

trait AnyFSyntax {
  implicit final def anyfSyntaxMouse[F[_], A](fa: F[A]): AnyFOps[F, A] = new AnyFOps(fa)
}

final class AnyFOps[F[_], A](val fa: F[A]) extends AnyVal {
  @inline def thrushK[G[_]](f: F ~> G): G[A] = f(fa)
}
