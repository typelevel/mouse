package object mouse extends MouseFunctions {
  object all extends AllSharedSyntax with AllJsSyntax
  object any extends AnySyntax
  object anyf extends AnyFSyntax
  object option extends OptionSyntax
  object boolean extends BooleanSyntax
  object string extends StringSyntax
  object `try` extends TrySyntax
  object int extends IntSyntax
  object double extends DoubleSyntax
  object long extends LongSyntax
  object map extends MapSyntax
  object iterableonce extends IterableOnceSyntax
  object foldable extends FoldableSyntax
}
