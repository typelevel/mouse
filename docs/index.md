# Mouse 

![Continuous Integration](https://github.com/typelevel/mouse/workflows/Continuous%20Integration/badge.svg) [![Maven Central](https://img.shields.io/maven-central/v/org.typelevel/mouse_2.12.svg)](https://maven-badges.herokuapp.com/maven-central/org.typelevel/mouse_2.12) 

Mouse is a small companion to the [Cats] functional programming library and the Scala standard library.

The library arose from this [Cats issue] and is a [Typelevel member].

Mouse is published for Scala 2.12, 2.13 and 3.0. For Scala.jvm:
```scala
"org.typelevel" %% "mouse" % "@VERSION@"
```

For scala.js 1.x:
```scala
"org.typelevel" %%% "mouse" % "@VERSION@"
```

### Scope of Library

Provide enrichments to classes from the Scala standard library that convert to Cats datatypes,
or otherwise improve the functional programming experience.

### Content

Mouse includes enrichments for:

- [Any](https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest/mouse/AnyOps.html)
- [Boolean](https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest/mouse/BooleanOps.html)
- [Double](https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest/mouse/DoubleOps.html)
- [F\[A\]](https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest/mouse/AnyFOps.html)
- [F\[Either\[A, B\]\]](https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest/mouse/FEitherOps.html)
- [F\[Option\[A\]\]](https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest/mouse/FOptionOps.html)
- [F\[G\[A\]\]](https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest/mouse/FNested2SyntaxOps.html)
- [F\[G\[H\[A\]\]\]](https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest/mouse/FNested3SyntaxOps.html)
- [F\[TupleN\]](https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest/mouse/FTupleNSyntax.html)
- [Int](https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest/mouse/IntOps.html)
- [Long](https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest/mouse/LongOps.html)
- [Map\[K, V\]](https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest/mouse/MapOps.html)
- [Option\[A\]](https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest/mouse/OptionOps.html)
- [String](https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest/mouse/StringOps.html)
- [Try\[A\]](https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest/mouse/TryOps.html)
- [Tuple](https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest/mouse/TupleSyntax.html)

#### Example:

```scala mdoc
import mouse.all._

true.option("Its true!")

def makeEven(i: Int) = (i % 2 == 1).applyIf(i)(_ - 1)

val e1: Either[String, Int] = Left("failed")

true.whenA(e1)

false.whenA(e1)

res0.cata(msg => s"Message received: ${msg}", "No message")

"1.0".parseFloat

"foo".parseIntValidated

val t1 = scala.util.Try(new java.net.URL("https://www.github.com"))

t1.cata(msg => s"URL is valid!", error => s"URL is invalid: ${error.getMessage}")

t1.toEither

val t2 = scala.util.Try(new java.net.URL("https//www.github.com"))

t2.cata(msg => s"URL is valid!", error => s"URL is invalid: ${error.getMessage}")

t2.toEither

val intToBytes = 123456789.toByteArray

val longToBase64 = 123456789L.toBase64

5.squared

1.5 |> (_.toInt) |> (_.toString)

//lift a partial function into a total function to an Either, when you want to treat unhandled input cases as an error
liftEither[Option[Int]]({case Some(n) => n}, a => s"Unexpected: $a")(Some(6))

val mapped = Map(1 -> 2, 3 -> 4).mapKeys(_ * 2)

val foption = List(Option(1), Option(2), Option(4)).mapIn(_ * 2)

val feither = List(Either.cond(true, 1, "0")).mapIn(_ * 2)

val listOption = List(Option(1), Option(2)).mapNested2(_ * 2)

val listOptionList = List(Option(List(1)), Option(List(2))).mapNested3(_ * 2)

val tupleHead = (1, 2, 4, 8).head

val tupleLast = (1, 2, 4, 8).last
```

### Contributing

Mouse is maintained by [@benhutchison] and [@danicheg].

Issues and pull requests are welcome. Code contributions should be aligned with the above scope to be included, and include unit tests.
See [contributing guide] for more details.

This project supports the [Scala code of conduct] and aims that its channels
(mailing list, Gitter, Github, etc.) to be welcoming environments for everyone.


[Cats]: https://github.com/typelevel/cats
[Cats issue]: https://github.com/typelevel/cats/issues/791
[@benhutchison]: https://github.com/benhutchison
[@danicheg]: https://github.com/danicheg
[Typelevel member]: http://typelevel.org/projects/
[contributing-guide]: ../contributing-guide/
[Scala code of conduct]: https://www.scala-lang.org/conduct/