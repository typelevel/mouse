package mouse


trait LongSyntax {
  implicit final def longSyntaxMouse(n: Long): LongOps = new LongOps(n)
}

final class LongOps(val n: Long) extends AnyVal {

  @inline final def toByteArray: Array[Byte] = java.nio.ByteBuffer.allocate(8).putLong(n).array()

  /** Base64 encoding (without final terminator). Shortcut for `java.util.Base64.getEncoder.withoutPadding.encodeToString`*/
  @inline final def toBase64: String = java.util.Base64.getEncoder.withoutPadding.encodeToString(toByteArray)

}
