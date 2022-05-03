/*
 * Copyright (c) 2022 Typelevel
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package mouse

trait LongSyntax {
  implicit final def longSyntaxMouse(n: Long): LongOps = new LongOps(n)
}

final class LongOps(private val n: Long) extends AnyVal {

  @inline def toByteArray: Array[Byte] = java.nio.ByteBuffer.allocate(8).putLong(n).array()

  /**
   * Base64 encoding (without final terminator). Shortcut for
   * `java.util.Base64.getEncoder.withoutPadding.encodeToString`
   */
  @inline def toBase64: String = java.util.Base64.getEncoder.withoutPadding.encodeToString(toByteArray)

  @inline def squared: Long = n * n

}
