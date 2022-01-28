# Mouse 

![Continuous Integration](https://github.com/typelevel/mouse/workflows/Continuous%20Integration/badge.svg) [![Maven Central](https://img.shields.io/maven-central/v/org.typelevel/mouse_2.12.svg)](https://maven-badges.herokuapp.com/maven-central/org.typelevel/mouse_2.12) 

Mouse is a small companion to the [Cats] functional programming library and the Scala standard library.

The library arose from this [Cats issue] and is a [Typelevel member].

Mouse is published for Scala 2.12, 2.13 and 3.0. For Scala.jvm:
```scala
"org.typelevel" %% "mouse" % version
```

For scala.js 1.x:
```scala
"org.typelevel" %%% "mouse" % version
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
- [Int](https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest/mouse/IntOps.html)
- [Long](https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest/mouse/LongOps.html)
- [Map\[K, V\]](https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest/mouse/MapOps.html)
- [Option\[A\]](https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest/mouse/OptionOps.html)
- [String](https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest/mouse/StringOps.html)
- [Try\[A\]](https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest/mouse/TryOps.html)
- [Tuple](https://www.javadoc.io/doc/org.typelevel/mouse_2.13/latest/mouse/TupleSyntax.html)

#### Example:

```scala
scala> import mouse.all._
import mouse.all._

scala> true.option("Its true!")
res0: Option[String] = Some(Its true!)

scala> def makeEven(i: Int) = (i % 2 == 1).applyIf(i)(_ - 1)
def makeEven(i: Int): Int

scala> val e1: Either[String, Int] = Left("failed")
e1: Either[String,Int] = Left(failed)

scala> true.whenA(e1)
res0: Either[String,Unit] = Left(failed)

scala> false.whenA(e1)
res1: Either[String,Unit] = Right(())

scala> res0.cata(msg => s"Message received: ${msg}", "No message")
res1: String = Message received: Its true!

scala> "1.0".parseFloat
res0: Either[NumberFormatException, Float] = Right(1.0F)

scala> "foo".parseIntValidated
res1: cats.data.Validated[NumberFormatException,Int] = Invalid(java.lang.NumberFormatException: For input string: "foo")

scala> val t1 = scala.util.Try(new java.net.URL("https://www.github.com"))
t1: scala.util.Try[java.net.URL] = Success(https://www.github.com)

scala> t1.cata(msg => s"URL is valid!", error => s"URL is invalid: ${error.getMessage}")
res1: String = URL is valid!

scala> t1.toEither
res2: Either[Throwable,java.net.URL] = Right(https://www.github.com)

scala> val t2 = scala.util.Try(new java.net.URL("https//www.github.com"))
t2: scala.util.Try[java.net.URL] = Failure(java.net.MalformedURLException: no protocol: https//www.github.com)

scala> t2.cata(msg => s"URL is valid!", error => s"URL is invalid: ${error.getMessage}")
res3: String = URL is invalid: no protocol: https//www.github.com

scala> t2.toEither
res4: Either[Throwable,java.net.URL] = Left(java.net.MalformedURLException: no protocol: https//www.github.com)

scala> val intToBytes = 123456789.toByteArray
intToBytes: Array[Byte] = Array(7, 91, -51, 21)

scala> val longToBase64 = 123456789L.toBase64
longToBase64: String = AAAAAAdbzRU

scala> 5.squared
res0: Int = 25

scala> 1.5 |> (_.toInt) |> (_.toString)
res0: String = 1

//lift a partial function into a total function to an Either, when you want to treat unhandled input cases as an error
scala> liftEither[Option[Int]]({case Some(n) => n}, a => s"Unexpected: $a")(Some(6))
res0: Either[String,Int] = Right(6)

scala> val mapped = Map(1 -> 2, 3 -> 4).mapKeys(_ * 2)
mapped: Map[Int,Int] = Map(2 -> 2, 6 -> 4)

scala> val foption = List(Option(1), Option(2), Option(4)).mapIn(_ * 2)
foption: List[Option[Int]] = List(Some(2), Some(4), Some(8))

scala> val feither = List(Either.cond(true, 1, "0")).mapIn(_ * 2)
foption: List[Either[String, Int]] = List(Right(2))

scala> val listOption = List(Option(1), Option(2)).mapNested2(_ * 2)
listOption: List[Option[Int]] = List(Some(2), Some(4))

scala> val listOptionList = List(Option(List(1)), Option(List(2))).mapNested3(_ * 2)
listOptionList: List[Option[List[Int]]] = List(Some(List(2)), Some(List(4)))

scala> val tupleHead = (1, 2, 4, 8).head
tupleHead: Int = 1

scala> val tupleLast = (1, 2, 4, 8).last
tupleHead: Int = 8
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