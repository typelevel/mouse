import sbt._
import scala.annotation.tailrec

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

  val header =
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

  val maxArity = 22

  final class TemplateVals(val arity: Int) {
    val synTypes = (0 until arity).map(n => s"A$n")
    val synVals = (0 until arity).map(n => s"a$n")
    val synTypedVals = synVals.zip(synTypes).map { case (v, t) => v + ":" + t }
    val `A..N` = synTypes.mkString(", ")
    val `a..n` = synVals.mkString(", ")
    val `_.._` = Seq.fill(arity)("_").mkString(", ")
    val `(A..N)` = if (arity == 1) "Tuple1[A0]" else synTypes.mkString("(", ", ", ")")
    val `(_.._)` = if (arity == 1) "Tuple1[_]" else Seq.fill(arity)("_").mkString("(", ", ", ")")
    val `(a..n)` = if (arity == 1) "Tuple1(a)" else synVals.mkString("(", ", ", ")")
    val `a:A..n:N` = synTypedVals.mkString(", ")

    val `A..(N - 1)` = (0 until (arity - 1)).map(n => s"A$n")
    val `A..(N - 2)` = (0 until (arity - 2)).map(n => s"A$n")
    val `A0, A(N - 1)` = if (arity <= 1) "" else `A..(N - 1)`.mkString(", ")
    val `A0, A(N - 2)` = if (arity <= 2) "" else `A..(N - 2)`.mkString("", ", ", ", ")
    val `[A0, A(N - 2)]` = if (arity <= 2) "" else `A..(N - 2)`.mkString("[", ", ", "]")
    val `(A..N - 2, *, *)` =
      if (arity <= 2) "(*, *)"
      else `A..(N - 2)`.mkString("(", ", ", ", *, *)")
    val `a..(n - 1)` = (0 until (arity - 1)).map(n => s"a$n")
    val `fa._1..fa._(n - 2)` =
      if (arity <= 2) "" else (0 until (arity - 2)).map(n => s"fa._${n + 1}").mkString("", ", ", ", ")
    val `pure(fa._1..(n - 2))` =
      if (arity <= 2) "" else (0 until (arity - 2)).map(n => s"G.pure(fa._${n + 1})").mkString("", ", ", ", ")
    val `a0, a(n - 1)` = if (arity <= 1) "" else `a..(n - 1)`.mkString(", ")
    val `[A0, A(N - 1)]` = if (arity <= 1) "" else `A..(N - 1)`.mkString("[", ", ", "]")
    val `(A0, A(N - 1))` =
      if (arity == 1) "Tuple1[A0]"
      else if (arity == 2) "A0"
      else `A..(N - 1)`.mkString("(", ", ", ")")
    val `(A..N - 1, *)` =
      if (arity == 1) "Tuple1"
      else `A..(N - 1)`.mkString("(", ", ", ", *)")
    val `(fa._1..(n - 1))` =
      if (arity <= 1) "Tuple1.apply" else (0 until (arity - 1)).map(n => s"fa._${n + 1}").mkString("(", ", ", ", _)")

    def `A0, A(N - 1)&`(a: String): String =
      if (arity <= 1) s"Tuple1[$a]" else `A..(N - 1)`.mkString("(", ", ", s", $a)")

    def `fa._1..(n - 1) & `(a: String): String =
      if (arity <= 1) s"Tuple1($a)" else (0 until (arity - 1)).map(n => s"fa._${n + 1}").mkString("(", ", ", s", $a)")

    def `constraints A..N`(c: String): String = synTypes.map(tpe => s"$tpe: $c[$tpe]").mkString("(implicit ", ", ", ")")

    def `constraints A..(N-1)`(c: String): String =
      if (arity <= 1) "" else `A..(N - 1)`.map(tpe => s"$tpe: $c[$tpe]").mkString("(implicit ", ", ", ")")

    def `parameters A..(N-1)`(c: String): String = `A..(N - 1)`.map(tpe => s"$tpe: $c[$tpe]").mkString(", ")
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
