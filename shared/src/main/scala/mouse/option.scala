package mouse

import scala.util.{Failure, Success, Try}

object option:
  extension [A](oa: Option[A])
    @inline def toTry(ex: =>Throwable): Try[A] = oa.cata(Success(_), Failure(ex))

    @inline def toTryMsg(msg: =>String): Try[A] = oa.toTry(new RuntimeException(msg))

  extension [A, B](oa: Option[A])
    @inline def cata(some: A => B, none: => B): B = oa.fold[B](none)(some)

    @deprecated("use `toRight` instead", "1.0.0")
    @inline def right(b: => B) : Either[B, A] = oa.toRight(b)
  
    @deprecated("use `toLeft` instead", "1.0.0")
    @inline def left(b: => B) : Either[A, B] = oa.toLeft(b)
