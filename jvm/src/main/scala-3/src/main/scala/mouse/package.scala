package object mouse extends MouseFunctions {
  object all extends AllSharedSyntax with AllJvmSyntax
  object any extends AnySyntax
  object anyf extends AnyFSyntax
  object boolean extends BooleanSyntax
  object double extends DoubleSyntax
  object fboolean extends FBooleanSyntax
  object feither extends FEitherSyntax
  object fnested extends FNestedSyntax
  object foption extends FOptionSyntax
  object ftuple extends FTupleSyntax
  object int extends IntSyntax
  object long extends LongSyntax
  object map extends MapSyntax
  object option extends OptionSyntax
  object string extends StringSyntax with StringJvmSyntax
  object `try` extends TrySyntax
}
