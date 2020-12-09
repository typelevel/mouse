package mouse

import cats.syntax.all._
import cats.{Id}

import mouse.anyf._

class AnyFSyntaxTest extends MouseSuite:

  type ~>[F[_], G[_]] = [A] => F[A] => G[A]

  val emptyK: List ~> List = [A] => (_: List[A]) => Nil

//  val double: List ~> List = [T] => ((list) => list ::: list)
//
//  testEquals(List(1, 2, 3) thrushK emptyK, Nil, "thrushK emptyK")
//
//  testEquals(List(5, 10) thrushK double, List(5, 10, 5, 10), "thrushK double")
//
//  testEquals("thing".some thrushK ((_.toRight("foo")): Option ~> Either[String, *]), Right("thing"))
//
//  testEquals((List("This") ||> double ||> List ~> Option(_.headOption) ||> Option ~> Id(_.head)), "This")
