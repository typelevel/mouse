/*
 * Copyright (c) 2016 Typelevel
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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

  test("FBooleanSyntax.onTrue (when true)") {
    var evalWasEvaluated = false
    var functionWasCalled = false
    def other = {
      functionWasCalled = true
      Eval.later {
        evalWasEvaluated = true
      }
    }

    Eval.now(true).onTrue(other).value
    assertEquals(evalWasEvaluated, true)
    assertEquals(functionWasCalled, true)
  }

  test("FBooleanSyntax.onTrue (when false)") {
    var evalWasEvaluated = false
    var functionWasCalled = false
    def other = {
      functionWasCalled = true
      Eval.later {
        evalWasEvaluated = true
      }
    }

    Eval.now(false).onTrue(other).value
    assertEquals(evalWasEvaluated, false)
    assertEquals(functionWasCalled, false)
  }

  test("FBooleanSyntax.onFalse (when true)") {
    var evalWasEvaluated = false
    var functionWasCalled = false
    def other = {
      functionWasCalled = true
      Eval.later {
        evalWasEvaluated = true
      }
    }

    Eval.now(false).onFalse(other).value
    assertEquals(evalWasEvaluated, true)
    assertEquals(functionWasCalled, true)
  }

  test("FBooleanSyntax.onFalse (when false)") {
    var evalWasEvaluated = false
    var functionWasCalled = false
    def other = {
      functionWasCalled = true
      Eval.later {
        evalWasEvaluated = true
      }
    }

    Eval.now(true).onFalse(other).value
    assertEquals(evalWasEvaluated, false)
    assertEquals(functionWasCalled, false)
  }

}
