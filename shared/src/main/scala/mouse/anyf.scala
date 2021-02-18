package mouse
import cats.~>

object anyf:
  extension [F[_], G[_], A](fa: F[A])
    @inline def ||>(f: F ~> G): G[A] = f(fa)
    @inline def thrushK(f: F ~> G): G[A] = f(fa)

