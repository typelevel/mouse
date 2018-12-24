package mouse

class MapSyntaxTest extends MouseSuite {

  Map(1 -> 2, 3 -> 4).mapKeys(_ * 2) shouldEqual Map(2 -> 2, 6 -> 4)

  Map(1 -> 2, 3 -> 4).mapKeys(identity) shouldEqual Map(1 -> 2, 3 -> 4)

  Map[Int, Int]().mapKeys(identity) shouldEqual Map[Int, Int]()


  Map(1 -> 2, 3 -> 4).updateKey(3, _ * 2) shouldEqual Map(1 -> 2, 3 -> 8)

  Map(1 -> 2, 3 -> 4).updateKey(42, _ * 2) shouldEqual Map(1 -> 2, 3 -> 4)

  Map(1 -> 2, 3 -> 4).updateKey(3, identity) shouldEqual Map(1 -> 2, 3 -> 4)


  Map(1 -> 2, 3 -> 4).updateKeyCombine(3, 5) shouldEqual Map(1 -> 2, 3 -> 9)

  Map(1 -> 2, 3 -> 4).updateKeyCombine(42, 5) shouldEqual Map(1 -> 2, 3 -> 4)


  Map(1 -> 2, 3 -> 4).updateKeyF(3, Option(_)) shouldEqual Some(Map(1 -> 2, 3 -> 4))

  Map(1 -> 2, 3 -> 4).updateKeyF(3, i => Option(i * 2)) shouldEqual Some(Map(1 -> 2, 3 -> 8))

  Map(1 -> 2, 3 -> 4).updateKeyF(42, Option(_)) shouldEqual Some(Map(1 -> 2, 3 -> 4))
}
