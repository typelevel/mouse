package mouse

trait LongSyntax {
  implicit final def longSyntaxMouse(n: Long): LongOps = new LongOps(n)
}

final class LongOps(private val n: Long) extends AnyVal {

  @inline def toByteArray: Array[Byte] = java.nio.ByteBuffer.allocate(8).putLong(n).array()

  /**
   * Base64 encoding (without final terminator). Shortcut for `java.util.Base64.getEncoder.withoutPadding.encodeToString`
   */
  @inline def toBase64: String = java.util.Base64.getEncoder.withoutPadding.encodeToString(toByteArray)

  @inline def squared: Long = n * n

}
