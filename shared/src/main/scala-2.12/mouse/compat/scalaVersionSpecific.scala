package mouse
package compat
import scala.annotation.{Annotation, StaticAnnotation}

private[mouse] object scalaVersionSpecific {

  /**
   * a trick to suppress unused import warning for this object
   */
  class suppressUnusedImportWarningForScalaVersionSpecific extends Annotation with StaticAnnotation

  type IterableOnce[+A] = TraversableOnce[A]

  implicit class traversableOnceExtension[A](private val to: TraversableOnce[A]) extends AnyVal {
    def iterator: Iterator[A] = to.toIterator
  }
}
