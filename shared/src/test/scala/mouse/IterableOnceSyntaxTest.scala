package mouse

import org.scalacheck.Arbitrary._
import org.scalacheck.Prop._

class IterableOnceSyntaxTests extends MouseSuite {

  property("unlines roundtrip") {
    forAll(genLines) { (lines: List[String]) =>
      assertEquals(lines.unlines.linesIterator.toList, lines)
    }
  }
}
