package Lab3

import Lab3.Adts.{testDouble, testGetNth, testGoodOldJava, testIsEven, testSafeDivide}
import Lab3.Maps.{User, testGroupUsers, testNumberFrodos, testUnderaged}
import Lab3.Sequence.{testFlatMap, testForAll, testLastElement, testPalindrom, testZip}

object Lab3Main {
  def main(args: Array[String]): Unit = {
    println("Strings")
    println("testUppercase(\"lowercase to upper\") "+Strings.testUppercase("lowercase to upper"))
    println("testInterpolations(\"Dan\", 24) "+Strings.testInterpolations("Dan", 24))
    println("testComputation(2, 4) "+Strings.testComputation(2, 4))
    println("testTakeTwo(\"more then two\") "+Strings.testTakeTwo("more then two"))
    println("testTakeTwo(\"tw\")"+Strings.testTakeTwo("tw"))
    println("Sequence")
    println("testLastElement(Seq(100,12,45,7,65)) "+testLastElement(Seq(100,12,45,7,65)))
    println("testLastElement(Seq.empty[Int]) "+testLastElement(Seq.empty[Int]))
    println("testZip(Seq(10, 20, 30), Seq(40,50,60)) "+testZip(Seq(10, 20, 30), Seq(40,50,60)))
    println("testZip(Seq(3), Seq(6, 7, 9)) "+testZip(Seq(3), Seq(6, 7, 9)))
    println("testForAll(Seq(5, 12,14))(x=>x>0) "+testForAll(Seq(5, 12,14))(x=>x>0))
    println("testForAll(Seq(-4, 8, 366,-2))(x=>x>0) "+testForAll(Seq(-4, 8, 366,-2))(x=>x>0))
    println("testPalindrom(Seq('0','1','2','1','0')) "+testPalindrom(Seq('0','1','2','1','0')))
    println("testPalindrom(Seq('0','1','2','3','0')) "+testPalindrom(Seq('0','1','2','3','0')))
    println("Seq(12,14,18,7))(x=>x.toString.toSeq) "+testFlatMap(Seq(12,14,18,7))(x=>x.toString.toSeq))
    println("Maps")
    println("testGroupUsers(Seq(User(\"Jack\", 15), User(\"Boba\", 45), User(\"Biba\", 40), User(\"Boba\", 12),User(\"Flynn\",15))) "
      +testGroupUsers(Seq(User("Jack", 15), User("Boba", 45), User("Biba", 40), User("Boba", 12),User("Flynn",15))))
    println("testNumberFrodos(Map(\"First\" -> User(\"Adams\", 19), \"Second\" -> User(\"NoAdam\", 25), \"Adamantium\" -> User(\"Addd\", 40))) "
      +testNumberFrodos(Map("First" -> User("Adams", 19), "Second" -> User("NoAdam", 25), "Adamantium" -> User("Addd", 40))))
    println("testUnderaged(Map(\"First\" -> User(\"Adams\", 19), \"Second\" -> User(\"NoAdam\", 25), \"Adamantium\" -> User(\"Addd\", 40))) "
      +testUnderaged(Map("First" -> User("Adams", 19), "Second" -> User("NoAdam", 25), "Adamantium" -> User("Addd", 40))))
    println("Adts")
    println("testGetNth(List(1, 2, 3), 2) "+testGetNth(List(1, 2, 3), 2))
    println("testGetNth(List(1, 2, 3), 4) "+testGetNth(List(1, 2, 3), 4))
    println("testDouble(Option(16)) "+testDouble(Option(16)))
    println("testDouble(None) "+testDouble(None))
    println("testIsEven(2) "+testIsEven(2))
    println("testIsEven(3) "+testIsEven(3))
    println("testSafeDivide(100, 3) "+testSafeDivide(100, 3))
    println("testSafeDivide(5, 0) "+testSafeDivide(5, 0))
    println("testGoodOldJava(x=>x.toInt/0, \"6\") "+testGoodOldJava(x=>x.toInt/0, "6"))
    println("testGoodOldJava(x=>x.toInt*5, \"17\") "+testGoodOldJava(x=>x.toInt*5, "17"))
  }
}
