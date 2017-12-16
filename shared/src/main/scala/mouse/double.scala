package mouse


trait DoubleSyntax {
  implicit final def DoubleSyntaxMouse(n: Double): DoubleOps = new DoubleOps(n)
}

final class DoubleOps(val n: Double) extends AnyVal {

  @inline final def toByteArray: Array[Byte] = java.nio.ByteBuffer.allocate(8).putDouble(n).array()

}
