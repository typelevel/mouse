package object mouse {
  object all extends AllSyntax
  object option extends OptionSyntax
  object boolean extends BooleanSyntax
  object string extends StringSyntax
  object `try` extends TrySyntax

  def ignore(a: Any): Unit = ()
}
