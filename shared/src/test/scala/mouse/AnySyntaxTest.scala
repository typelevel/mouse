package mouse

class AnySyntaxTest extends MouseSuite with MouseFunctions {
  test("AnySyntax.|>") {
    assertEquals(true |> (!_), false)

    assertEquals(5 |> (_ + 44), 49)

    assertEquals(Some("thing") |> (_ getOrElse "that"), "thing")

    assertEquals(
      "This" |> Function.const("that") |> (_.capitalize) |> Function.const("at bat"),
      "at bat"
    )

    assertEquals(ignore(true), ())

    assertEquals(1200 |> (_*2) |> (_-5) |> (_/3), ((1200 * 2) - 5) / 3)

    assertEquals("anythingAtAll" |> ignore, ())
  }
}
