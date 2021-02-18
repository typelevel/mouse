package mouse

import mouse.any._

class AnySyntaxTest extends MouseSuite:

  testEquals(true |> (!_),  false)

  testEquals(5 |> (_ + 44),  49)

  testEquals(Some("thing") |> (_ getOrElse "that"),  "thing")

  testEquals(("This" |> Function.const("that")
        |> (_.capitalize)
        |> Function.const("at bat")),  "at bat")

  testEquals(1200 |> (_*2) |> (_-5) |> (_/3), (((1200 * 2) - 5) / 3))

  testEquals("anythingAtAll" |> mouse.ignore, ())
