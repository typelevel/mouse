package mouse

import scala.util.{Failure, Success, Try}

trait OptionSyntax {
  implicit final def optionSyntax[A](oa: Option[A]): OptionOps[A] = new OptionOps(oa)
}

final class OptionOps[A](val oa: Option[A]) extends AnyVal {

  def cata[B](some: A => B, none: => B): B = oa.fold[B](none)(some)

  def toTry(ex: =>Throwable): Try[A] = oa match {
    case Some(x) => Success(x)
    case None => Failure(ex)
  }

  def toTryMsg(msg: =>String): Try[A] = toTry(new RuntimeException(msg))

}
