package mouse

import cats.{FlatMap, Functor}

trait FBooleanSyntax {
  implicit final def FBooleanSyntaxMouse[F[_]](fBoolean: F[Boolean]): FBooleanOps[F] =
    new FBooleanOps[F](fBoolean)
}

final class FBooleanOps[F[_]](private val fBoolean: F[Boolean]) extends AnyVal {

  /**
   * Transforms this `F[Boolean]` by negating the `Boolean`
   */
  def not(implicit F: Functor[F]): F[Boolean] =
    F.map(fBoolean)(b => !b)

  /**
   * Behaves like `&&` but inside the `F` context.
   *
   * Wont evaluate `other` unless this evaluates to `true`
   */
  def andM(other: => F[Boolean])(implicit F: FlatMap[F]): F[Boolean] =
    F.flatMap(fBoolean) {
      case false => F.pure(false)
      case true  => other
    }

  /**
   * Behaves like `||` but inside the `F` context.
   *
   * Wont evaluate `other` unless this evaluates to `false`
   */
  def orM(other: => F[Boolean])(implicit F: FlatMap[F]): F[Boolean] =
    F.flatMap(fBoolean) {
      case true  => F.pure(true)
      case false => other
    }
}
