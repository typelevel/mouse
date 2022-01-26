package mouse

import cats.{Eval, Id}

class FBooleanSyntaxTests extends MouseSuite {
  test("FBooleanSyntax.not") {
    assertEquals(Id(true).not, Id(false))
    assertEquals(Id(false).not, Id(true))
  }

  test("FBooleanSyntax.andM") {
    // Boolean logic.
    assertEquals(Id(true).andM(Id(true)), Id(true))
    assertEquals(Id(true).andM(Id(false)), Id(false))
    assertEquals(Id(false).andM(Id(true)), Id(false))
    assertEquals(Id(false).andM(Id(false)), Id(false))

    // Short-circuit.
    var evalWasEvaluated = false
    var functionWasCalled = false
    def other = {
      functionWasCalled = true
      Eval.later {
        evalWasEvaluated = true
        true
      }
    }

    Eval.now(false).andM(other)
    assertEquals(evalWasEvaluated, false)
    assertEquals(functionWasCalled, false)
  }

  test("FBooleanSyntax.orM") {
    // Boolean logic.
    assertEquals(Id(true).orM(Id(true)), Id(true))
    assertEquals(Id(true).orM(Id(false)), Id(true))
    assertEquals(Id(false).orM(Id(true)), Id(true))
    assertEquals(Id(false).orM(Id(false)), Id(false))

    // Short-circuit.
    var evalWasEvaluated = false
    var functionWasCalled = false
    def other = {
      functionWasCalled = true
      Eval.later {
        evalWasEvaluated = true
        true
      }
    }

    Eval.now(true).orM(other)
    assertEquals(evalWasEvaluated, false)
    assertEquals(functionWasCalled, false)
  }
}
