package mouse

import org.scalacheck.Arbitrary._
import org.scalacheck.Prop._

class FoldableSyntaxTests extends MouseSuite {

  property("unlines_ roundtrip") {
    forAll(genLines) { (lines: List[String]) =>
      assertEquals(lines.unlines_.linesIterator.toList, lines)
    }
  }
}
