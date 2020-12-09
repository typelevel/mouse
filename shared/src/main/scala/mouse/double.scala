package mouse


object double:
  extension (n: Double):
    @inline def toByteArray: Array[Byte] = java.nio.ByteBuffer.allocate(8).putDouble(n).array()

    @inline def squared: Double = n * n
