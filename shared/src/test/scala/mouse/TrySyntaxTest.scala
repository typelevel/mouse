package mouse

import scala.util.{Failure, Success, Try}
import org.scalacheck.Gen

class TrySyntaxTest extends MouseSuite {

  private val exceptionList =
    Seq(
      new RuntimeException(_: String),
      new IllegalArgumentException(_: String),
      new UnsupportedOperationException(_: String),
      new ArrayIndexOutOfBoundsException(_: String),
      new NumberFormatException(_: String)
    )

  private def genThrowable: Gen[Throwable] = for {
    message   <- Gen.alphaStr
    throwable <- Gen.oneOf(exceptionList)
  } yield throwable(message)

  private def genTrySuccess[T](genT: => Gen[T]): Gen[(T, Try[T])] = for {
    n  <- genT
    tr <- Gen.oneOf(Try(n), Success(n))
  } yield (n, tr)

  private def genTryInt = genTrySuccess[Int](Gen.choose(-10000, 10000))

  private def genTryString = genTrySuccess[String](Gen.alphaStr)

  private def genTryBoolean = genTrySuccess[Boolean](Gen.oneOf(true, false))

  private def genTryFailure[T]: Gen[(Throwable, Try[T])] = for {
    th <- genThrowable
    tr <- Gen.oneOf(Try[T](throw th), Failure[T](th))
  } yield (th, tr)

  private def randomNumber(min: Int, max: Int): Int = Gen.choose(min, max).sample.get

  forAll(genTryInt) { case (n, t) =>
    t.cata(identity, _ => n * n) shouldEqual n
  }

  forAll(genTryFailure[Int]) { case (th, tr) =>
    val rnd = randomNumber(50000, 60000)
    tr.cata(identity, _ => rnd) shouldEqual (rnd)
  }

  forAll(genTryString) { case (msg, tr) =>
    tr.toEither shouldEqual Right(msg)
  }

  forAll(genTryFailure[String]) { case (th, tr) =>
    tr.toEither shouldEqual Left(th)
  }

  implicit class ExtraTest[A](a: A) {
    def shouldBeA[T](implicit ev: T =:= A) = succeed
  }

  forAll(genTryBoolean, minSuccessful(10)) { case (_, t) =>
    t.toEither.shouldBeA[Either[Throwable, Boolean]]
  }
}
