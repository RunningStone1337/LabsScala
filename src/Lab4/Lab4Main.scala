package Lab4

import Lab4.Typeclasses.{testReversableString, testSmashDouble, testSmashInt, testSmashString}

object Lab4Main {
  def main(args: Array[String]): Unit = {
    println("Typeclasses")
    println(testReversableString("string"))
    println(testSmashInt(5, 12))
    println(testSmashDouble(8.0, 3.0))
    println(testSmashString("firts str ", "and second"))
  }
}
