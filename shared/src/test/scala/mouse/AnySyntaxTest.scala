package mouse

class AnySyntaxTest extends MouseSuite {

  true |> (!_) shouldEqual false

  5 |> (_ + 44) shouldEqual 49

  Some("thing") |> (_ getOrElse "that") shouldEqual "thing"

  ("This" |> Function.const("that")
          |> (_.capitalize)
          |> Function.const("at bat")) shouldEqual "at bat"

  mouse.ignore(true) shouldBe (())

  1200 |> (_*2) |> (_-5) |> (_/3) shouldBe (((1200 * 2) - 5) / 3)

  "anythingAtAll" |> mouse.ignore shouldBe (())

  def mutilate(x: CharSequence): CharSequence = x.subSequence(1, 2)
  "foo".applyIf(true)(mutilate) shouldEqual "o"
  "foo".applyIf(false)(mutilate) shouldEqual "foo"
}
