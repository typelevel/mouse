package mouse

import cats.{ Applicative, Monoid }


object boolean:
  extension [A](b: Boolean)
    @inline def option(a: => A): Option[A] = fold(Some(a), None)

    @inline def fold(t: => A, f: => A): A = if (b) t else f

    @inline def valueOrZero(a: => A)(using M: Monoid[A]): A = if (b) a else M.empty

    @inline def zeroOrValue(a: => A)(using M: Monoid[A]): A = if (b) M.empty else a

    @inline def ??(a: => A)(using M: Monoid[A]): A = valueOrZero(a)

    @inline def !?(a: => A)(using M: Monoid[A]): A = zeroOrValue(a)

    @inline def applyIf(a: A): ApplyIfPartiallyApplied[A] = new ApplyIfPartiallyApplied[A](b, a)

  extension [L, R](b: Boolean)
    @inline def either(l: =>L, r: =>R): Either[L, R] = b.fold(Right(r), Left(l))


  extension [F[_], A](b: Boolean)
    @inline def valueOrPure(fa: =>F[A])(a: =>A)(using F: Applicative[F]) = if (b) fa else F.pure(a)

    @inline def whenA(fa: F[A])(using F: Applicative[F]): F[Unit] = 
      F.whenA(b)(fa)
  
    @inline def unlessA(fa: F[A])(using F: Applicative[F]): F[Unit] = 
      F.unlessA(b)(fa)


class ApplyIfPartiallyApplied[A](b: Boolean, a: A):
  @inline def apply[B >: A](f: B => B): B = if (b) f(a) else a
