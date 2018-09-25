package object mouse {
  object all extends AllSyntax
  object any extends AnySyntax
  object option extends OptionSyntax
  object boolean extends BooleanSyntax
  object string extends StringSyntax
  object `try` extends TrySyntax
  object int extends IntSyntax
  object double extends DoubleSyntax
  object long extends LongSyntax

  /**
    * Evaluate but ignore the provided argument. This function makes value discarding an explicit operation,
    * helpful when the `-Ywarn-discard-values` compiler flag is enable to explicitly satisfy warnings.
    *
    * @param a - the value to be evaluated and ignored.
    */
  def ignore(a: Any): Unit = ()
}
