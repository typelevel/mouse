package mouse

import cats.syntax.all._

class StringJvmTests extends MouseSuite {

  //FIXME fixed in master, remove post 0.8.2
  implicit def catsSyntaxEitherId[A](a: A): EitherIdOps[A] = new EitherIdOps(a)

  test("parseFloat") {
    "123.1".parseFloat should ===(123.1f.asRight[NumberFormatException])

  }

}
