package mouse


trait IntSyntax {
  implicit final def intSyntaxMouse(n: Int): IntOps = new IntOps(n)
}

final class IntOps(val n: Int) extends AnyVal {

  @inline final def toByteArray: Array[Byte] = java.nio.ByteBuffer.allocate(4).putInt(n).array()

  /** Base64 encoding (without final terminator). Shortcut for `java.util.Base64.getEncoder.withoutPadding.encodeToString`*/
  @inline final def toBase64: String = java.util.Base64.getEncoder.withoutPadding.encodeToString(toByteArray)

  @inline final def squared: Int = n * n

}
