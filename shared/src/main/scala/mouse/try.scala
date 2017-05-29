package mouse

import scala.util.{Failure, Success, Try}

trait TrySyntax {
  implicit final def trySyntaxMouse[A](ta: Try[A]): TryOps[A] = new TryOps(ta)
}

final class TryOps[A](val ta: Try[A]) extends AnyVal {

  def cata[B](success: A => B, failure: Throwable => B): B =
    ta match {
      case Success(value) => success(value)
      case Failure(error) => failure(error)
    }

  def either: Either[Throwable, A] = cata[Either[Throwable, A]](Right(_), Left(_))
}