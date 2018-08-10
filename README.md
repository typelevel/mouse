# Mouse
Mouse is a small companion to the [Cats](https://github.com/typelevel/cats) functional programming library for Scala. It
includes convenience extension methods for Scala standard library classes, including some found in
[scalaz](https://github.com/scalaz/scalaz) that are not in Cats.

The library arose from this [Cats issue](https://github.com/typelevel/cats/issues/791) and is a [Typelevel member](http://typelevel.org/projects/).

Mouse is published Scala 2.10, 2.11, 2,12. For Scala.jvm:

`"org.typelevel" %% "mouse" % version`

For scala.js:

`"org.typelevel" %%% "mouse" % version`

[![Maven Central](https://img.shields.io/maven-central/v/org.typelevel/mouse_2.12.svg)](https://maven-badges.herokuapp.com/maven-central/org.typelevel/mouse_2.12)


[![Build Status](https://travis-ci.org/typelevel/mouse.svg?branch=master)](https://travis-ci.org/typelevel/mouse)

## Content

Mouse includes enrichments for:

- [Any](./shared/src/main/scala/mouse/any.scala)
- [Boolean](./shared/src/main/scala/mouse/boolean.scala)
- [Option](./shared/src/main/scala/mouse/option.scala)
- [String](./shared/src/main/scala/mouse/string.scala)
- [Try](./shared/src/main/scala/mouse/try.scala)
- [Int](./shared/src/main/scala/mouse/int.scala)
- [Long](./shared/src/main/scala/mouse/long.scala)
- [Double](./shared/src/main/scala/mouse/double.scala)

#### Example:

```scala
scala> import mouse.all._
import mouse.all._

scala> true.option("Its true!")
res0: Option[String] = Some(Its true!)

scala> res0.cata(msg => s"Message received: ${msg}", "No message")
res1: String = Message received: Its true!

scala> "1.0".parseFloat
res0: Either[NumberFormatException, Float] = Right(1.0F)

scala> "foo".parseIntValidated
res1: cats.data.Validated[NumberFormatException,Int] = Invalid(java.lang.NumberFormatException: For input string: "foo")

scala> val t1 = scala.util.Try(new java.net.URL("https://www.github.com"))
t1: scala.util.Try[java.net.URL] = Success(https://www.github.com)

t1.cata(msg => s"URL is valid!", error => s"URL is invalid: ${error.getMessage}")
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
liftEither[Option[Int]]({case Some(n) => n}, a => s"Unexpected: $a")(Some(6))
res0: Either[String,Int] = Right(6)
```

#### Release Notes

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

This project supports the Typelevel [code of conduct](http://typelevel.org/conduct.html) and aims that its channels
(mailing list, Gitter, github, etc.) to be welcoming environments for everyone.
