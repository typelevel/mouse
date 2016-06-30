package mouse

import cats.syntax.all._

class StringJvmTests extends MouseSuite {

  test("parseFloat") {
    "123.1".parseFloat should ===(123.1f.right[NumberFormatException])

  }

}
