package mouse


trait IntSyntax {
  implicit final def intSyntaxMouse(n: Int): IntOps = new IntOps(n)
}

final class IntOps(private val n: Int) extends AnyVal {

  @inline def toByteArray: Array[Byte] = java.nio.ByteBuffer.allocate(4).putInt(n).array()

  /** Base64 encoding (without final terminator). Shortcut for `java.util.Base64.getEncoder.withoutPadding.encodeToString`*/
  @inline def toBase64: String = java.util.Base64.getEncoder.withoutPadding.encodeToString(toByteArray)

  @inline def squared: Int = n * n

}
