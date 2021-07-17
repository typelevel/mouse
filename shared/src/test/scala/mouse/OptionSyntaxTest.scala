package mouse

import scala.util.{Failure, Success}

class OptionSyntaxTest extends MouseSuite {
  implicit class ExtraTest[A](a: A) {
    def shouldBeA[T](implicit ev: T =:= A): Unit = ()
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

  test("OptionSyntax.right") {
    assertEquals(Option(3).right("S"), Option(3).toRight("S"))
    assertEquals(None.right("S"), None.toRight("S"))
    Option(3).right("S").shouldBeA[Either[String, Int]]
  }

  test("OptionSyntax.") {
    assertEquals(Option(3).left("S"), Option(3).toLeft("S"))
    assertEquals(None.left("S"), None.toLeft("S"))
    Option(3).left("S").shouldBeA[Either[Int, String]]
  }
}
