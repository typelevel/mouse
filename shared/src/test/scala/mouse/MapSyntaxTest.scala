package mouse

class MapSyntaxTest extends MouseSuite {

  Map(1 -> 2, 3 -> 4).mapKeys(_ * 2) shouldEqual Map(2 -> 2, 6 -> 4)

  Map(1 -> 2, 3 -> 4).mapKeys(identity) shouldEqual Map(1 -> 2, 3 -> 4)

  Map[Int, Int]().mapKeys(identity) shouldEqual Map[Int, Int]()
}
