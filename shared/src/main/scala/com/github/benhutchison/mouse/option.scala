package com.github.benhutchison.mouse

trait OptionSyntax {
  implicit final def optionSyntax[A](oa: Option[A]): OptionOps[A] = new OptionOps(oa)
}

final class OptionOps[A](val oa: Option[A]) extends AnyVal {

  def cata[B](some: A => B, none: => B): B = oa.fold[B](none)(some)

}
