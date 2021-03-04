# Mouse
Mouse is a small companion to the [Cats](https://github.com/typelevel/cats) functional programming library for Scala. It
includes convenience extension methods for Scala standard library classes, including some found in
[scalaz](https://github.com/scalaz/scalaz) that are not in Cats.

The library arose from this [Cats issue](https://github.com/typelevel/cats/issues/791) and is a [Typelevel member](http://typelevel.org/projects/).

Mouse is published for Scala 2.12, 2.13 and 3.0-RC1. For Scala.jvm:

`"org.typelevel" %% "mouse" % version`

For scala.js 1.x:

`"org.typelevel" %%% "mouse" % version`

[![Maven Central](https://img.shields.io/maven-central/v/org.typelevel/mouse_2.12.svg)](https://maven-badges.herokuapp.com/maven-central/org.typelevel/mouse_2.12)
![Continuous Integration](https://github.com/typelevel/mouse/workflows/Continuous%20Integration/badge.svg)

## Content

Mouse includes enrichments for:

- [Any](./shared/src/main/scala/mouse/any.scala)
- [F\[A\] for any F, A](./shared/src/main/scala/mouse/anyf.scala)
- [Boolean](./shared/src/main/scala/mouse/boolean.scala)
- [Option](./shared/src/main/scala/mouse/option.scala)
- [String](./shared/src/main/scala/mouse/string.scala)
- [Try](./shared/src/main/scala/mouse/try.scala)
- [Int](./shared/src/main/scala/mouse/int.scala)
- [Long](./shared/src/main/scala/mouse/long.scala)
- [Double](./shared/src/main/scala/mouse/double.scala)
- [Map](./shared/src/main/scala/mouse/map.scala)

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
```

#### Release Notes

Please see [Releases](https://github.com/typelevel/mouse/releases) for newer releases >= `1.0.0` (Mar 21)

Version `0.26` (Dec 20) adds `applyIf` for Boolean and builds against Cats 2.3.0.

Version `0.25` (Apr 20) adds Scalajs 1.x support.

Version `0.24` (Dec 19) adds `valueOrPure` for Boolean and `parseUrl`/`parseUri` for String. Drops 2.11 support. Built against cats `2.1.0`.

Version `0.23` (Aug 19) adds parsing of `BigInt` and `BigDecimal`. Built against cats `2.0.0-RC1`.

Version `0.22` (June 19) is about support for Scala 2.13.0. Built against cats `2.0.0-M4`.

Version `0.21` (May 19) is about support for Scala 2.13.0 RC1. Built against cats `2.0 M1`.

Version `0.20` (Dec 18) adds syntax for Map and add support for Scala 2.13.0 M5. Built against cats `1.5.0`.

Version `0.19` (Oct 18) adds syntax for F[A] and is built against cats `1.4.0`. Support for Scala 2.10 is removed in this release.

Version `0.18` (Aug 18) adds PartialFunction lift to Either and is built against cats `1.2.0`

Version `0.17` (Apr 18) is built against cats `1.1.0`

Version `0.16` (Jan 18) is built against cats `1.0.1`

Version `0.15` (Dec 17) is built against cats `1.0.0`

Version `0.14` (Dec 17) include Int/Long/Double squared and is built against cats `1.0.0-RC2`

Version `0.13` (Dec 17) include Int/Long/Double toByteArray and toBase64 operations and is built against cats `1.0.0-RC1`

Version `0.12` (Nov 17) include Boolean Monoid operations and is built against cats `1.0.0-RC1`

Version `0.11` (Oct 17) migrates to `org.typelevel` group and remains built against cats `1.0.0-MF`

Version `0.10-MF` (Aug 17) is built against cats `1.0.0-MF`. It mainly supports compat testing for cats 1.0 release.

Version `0.9` (Jun 17) is built against cats `0.9`, rename `either`->`toEither` on Try to align with 2.12 core changes.

Version `0.8` (Jun 17) is built against cats `0.9`, `cata` and `either` on Try.

Version `0.7` (Apr 17) is built against cats `0.9`, Boolean `fold`, Option `right` and `left`.

Version `0.6` (Nov 16) is built against cats `0.8.1` and migrates `Xor` boolean syntax to `Either`.

Version `0.5` (Aug 16) is built against cats `0.7.0` but otherwise unchanged.

Version `0.4` (July 2016) includes a breaking package rename from `com.github.benhutchison.mouse` -> `mouse`. Rationale was
to follow cats and other modern libs convention of short, convenient package names.

## Scope of Library

- Provide enrichments to classes from the Scala standard library that convert to Cats datatypes,
or otherwise improve the functional programming experience.

- Make it easier to migrate source code between Scalaz and Cats.

## Contributing

Issues and pull requests are welcome. Code contributions should be aligned with the above scope to be included, and include unit tests.

This project supports the [Scala code of conduct](https://www.scala-lang.org/conduct/) and aims that its channels
(mailing list, Gitter, github, etc.) to be welcoming environments for everyone.
