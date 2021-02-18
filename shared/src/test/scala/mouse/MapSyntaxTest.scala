package mouse

class MapSyntaxTest extends MouseSuite:
  import map._

  testEquals(Map(1 -> 2, 3 -> 4).mapKeys(_ * 2), Map(2 -> 2, 6 -> 4))

  testEquals(Map(1 -> 2, 3 -> 4).mapKeys(identity), Map(1 -> 2, 3 -> 4))

  testEquals(Map[Int, Int]().mapKeys(identity) ,  Map[Int, Int]())


  testEquals(Map(1 -> 2, 3 -> 4).updateAtKey(3, _ * 2) ,  Map(1 -> 2, 3 -> 8))

  testEquals(Map(1 -> 2, 3 -> 4).updateAtKey(42, _ * 2), Map(1 -> 2, 3 -> 4))

  testEquals(Map(1 -> 2, 3 -> 4).updateAtKey(3, identity), Map(1 -> 2, 3 -> 4))


  testEquals(Map(1 -> 2, 3 -> 4).updateAtKeyCombine(3, 5), Map(1 -> 2, 3 -> 9))
  testEquals(Map(1 -> 2, 3 -> 4).updateAtKeyCombine(42, 5), Map(1 -> 2, 3 -> 4, 42 -> 5))



  testEquals(Map(1 -> 2, 3 -> 4).updateAtKeyF(3, Option(_)) ,  Option(Map(1 -> 2, 3 -> 4)))

  testEquals(Map(1 -> 2, 3 -> 4).updateAtKeyF(3, i => Option(i * 2)) ,  Option(Map(1 -> 2, 3 -> 8)))

  testEquals(Map(1 -> 2, 3 -> 4).updateAtKeyF(42, Option(_)) ,  Option(Map(1 -> 2, 3 -> 4)))
