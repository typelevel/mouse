package com.github.benhutchison.mouse

import cats.data.Xor

trait BooleanSyntax {
  implicit final def booleanSyntax(b: Boolean): BooleanOps = new BooleanOps(b)
}

final class BooleanOps(val b: Boolean) extends AnyVal {

  def option[A](a: => A): Option[A] = if (b) Some(a) else None

  def xor[L, R](l: =>L, r: =>R): Xor[L, R] = if (b) Xor.right(r) else Xor.left(l)

}