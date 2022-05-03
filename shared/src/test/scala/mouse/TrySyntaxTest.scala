/*
 * Copyright (c) 2016 Typelevel
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package mouse

import cats.syntax.eq._

import org.scalacheck.Gen
import org.scalacheck.Prop._

import scala.util.{Failure, Success, Try}

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
    message <- Gen.alphaStr
    throwable <- Gen.oneOf(exceptionList)
  } yield throwable(message)

  private def genTrySuccess[T](genT: => Gen[T]): Gen[(T, Try[T])] = for {
    n <- genT
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

  property("cata") {
    forAll(genTryInt) { case (n, t) =>
      t.cata(identity, _ => n * n) === n
    }

    forAll(genTryFailure[Int]) { case (_, tr) =>
      val rnd = randomNumber(50000, 60000)
      tr.cata(identity, _ => rnd) === rnd
    }
  }

  implicit class ExtraTest[A](a: A) {
    def shouldBeA[T](implicit ev: T =:= A): Unit = ()
  }

  property("toEither") {
    forAll(genTryString) { case (msg, tr) =>
      tr.toEither == Right(msg)
    }

    forAll(genTryFailure[String]) { case (th, tr) =>
      tr.toEither == Left(th)
    }

    forAll(genTryBoolean) { case (_, t) =>
      t.toEither.shouldBeA[Either[Throwable, Boolean]]
    }
  }
}
