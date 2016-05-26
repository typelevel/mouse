package com.github.benhutchison.mouse

import cats.Monoid

trait OptionSyntax {
  implicit final def optionSyntax[A](oa: Option[A]): OptionOps[A] = new OptionOps(oa)
}

final class OptionOps[A](val oa: Option[A]) extends AnyVal {

  def cata[B](some: A => B, none: => B): B = oa.fold[B](none)(some)

  /** Returns the containing A or the empty value for that A if A is a Monoid.
    * For instance if A is of type String it will return the empty String if the
    * Option is a None.
    */
  def getOrEmpty(implicit m: Monoid[A]): A = oa.getOrElse(m.empty)

}
