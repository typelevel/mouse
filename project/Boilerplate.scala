import sbt._

import scala.annotation.tailrec
import scala.collection.immutable

/**
 * Copied, with some modifications, from https://github.com/milessabin/shapeless/blob/main/project/Boilerplate.scala
 *
 * Generate a range of boilerplate classes, those offering alternatives with 0-22 params and would be tedious to craft
 * by hand
 *
 * @author
 *   Miles Sabin
 * @author
 *   Kevin Wright
 */
object Boilerplate {

  import scala.StringContext._

  implicit final class BlockHelper(private val sc: StringContext) extends AnyVal {
    def block(args: Any*): String = {
      val interpolated = sc.standardInterpolator(treatEscapes, args)
      val rawLines = interpolated.split('\n')
      val trimmedLines = rawLines.map(_.dropWhile(_.isWhitespace))
      trimmedLines.mkString("\n")
    }
  }

  val templates: Seq[Template] = Seq(GenFTupleNSyntax)

  val header: String =
    """// auto-generated boilerplate by /project/Boilerplate.scala
      |package mouse
      |""".stripMargin

  /**
   * Returns a seq of the generated files. As a side-effect, it actually generates them...
   */
  def gen(dir: File) =
    for (t <- templates) yield {
      val tgtFile = t.filename(dir)
      IO.write(tgtFile, t.body)
      tgtFile
    }

  val maxArity: Int = 22

  final class TemplateVals(val arity: Int) {
    val synTypes: immutable.Seq[String] = (0 until arity).map(n => s"A$n")
    val `A..N`: String = synTypes.mkString(", ")
  }

  trait Template {
    def filename(root: File): File

    def content(tv: TemplateVals): String

    def range = 1 to maxArity

    def body: String = {
      @tailrec
      def expandInstances(contents: IndexedSeq[Array[String]], acc: Array[String] = Array.empty): Array[String] =
        if (!contents.exists(_.exists(_.startsWith("-"))))
          acc.map(_.tail)
        else {
          val pre = contents.head.takeWhile(_.startsWith("|"))
          val instances = contents.flatMap(_.dropWhile(_.startsWith("|")).takeWhile(_.startsWith("-")))
          val next = contents.map(_.dropWhile(_.startsWith("|")).dropWhile(_.startsWith("-")))
          expandInstances(next, acc ++ pre ++ instances)
        }

      val rawContents = range.map { n =>
        content(new TemplateVals(n)).split('\n').filterNot(_.isEmpty)
      }
      val headerLines = header.split('\n')
      val instances = expandInstances(rawContents)
      val footerLines = rawContents.head.reverse.takeWhile(_.startsWith("|")).map(_.tail).reverse
      (headerLines ++ instances ++ footerLines).mkString("\n")
    }
  }
}
