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

import org.typelevel.scalaccompat.annotation._
import scala.annotation.nowarn
import scala.util.{Failure, Success}

class OptionSyntaxTest extends MouseSuite {
  implicit class ExtraTest[A](a: A) {
    def shouldBeA[T](implicit @nowarn212 ev: T =:= A): Unit = ()
  }

  test("OptionSyntax.cata") {
    assertEquals(Option(1).cata(_.toString, ""), "1")
    assertEquals(Option.empty[Int].cata(_.toString, ""), "")
  }

  test("OptionSyntax.toTry") {
    assertEquals(Option(1).toTry(new RuntimeException("Err")), Success(1))

    val ex = new RuntimeException("Err")
    assertEquals(Option.empty[Int].toTry(ex), Failure(ex))
  }

  @nowarn("cat=deprecation")
  private def rightTest(): Unit =
    test("OptionSyntax.right") {
      assertEquals(Option(3).right("S"), Option(3).toRight("S"))
      assertEquals(None.right("S"), None.toRight("S"))
      Option(3).right("S").shouldBeA[Either[String, Int]]
    }

  rightTest()

  @nowarn("cat=deprecation")
  private def leftTest(): Unit = test("OptionSyntax.left") {
    assertEquals(Option(3).left("S"), Option(3).toLeft("S"))
    assertEquals(None.left("S"), None.toLeft("S"))
    Option(3).left("S").shouldBeA[Either[Int, String]]
  }

  leftTest()
}
