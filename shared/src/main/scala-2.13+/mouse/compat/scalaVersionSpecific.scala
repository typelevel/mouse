package mouse
package compat
import scala.annotation.{Annotation, StaticAnnotation}

private[mouse] object scalaVersionSpecific {

  /**
   * a trick to suppress unused import warning for this object
   */
  class suppressUnusedImportWarningForScalaVersionSpecific extends Annotation with StaticAnnotation

}
