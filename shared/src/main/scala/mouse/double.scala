package mouse

trait DoubleSyntax {
  implicit final def doubleSyntaxMouse(n: Double): DoubleOps = new DoubleOps(n)
}

final class DoubleOps(private val n: Double) extends AnyVal {

  @inline def toByteArray: Array[Byte] = java.nio.ByteBuffer.allocate(8).putDouble(n).array()

  @inline def squared: Double = n * n

}
