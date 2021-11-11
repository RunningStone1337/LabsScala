package Lab4

object Typeclasses {//классы определяют абстракцию дя различных типов и реализацию для конкретных
  // a) Определите тайп-класс Reversable, который представляет в обратном порядке значения.
  trait Reversable[T]{
  def reverse(a: T): T
  }

  // b) Реализуйте функцию Reverse для String.
  implicit object ReversableString extends Reversable[String] {
      def reverse(s: String): String = {
        var t:String = new String
        for(i <- s.length - 1 to 0 by -1){
          t+=s.charAt(i)
        }
        t
     }
  }
  // Примените тайп-класс-решение из пункта (a) здесь
  def testReversableString(str: String): String = ReversableString.reverse(str)

  // c) Определите тайп-класс Smash таким образом чтобы в нем была функция smash,
  // которая выполняет операцию со значениями одного типа.
  trait Smash[T]{
  def smash(a: T, b: T): T
  }

  // d) Реализуйте  функции Smash для типа Int и Double.
  // Используйте сложение для типа Int у умножение для типа Double.
  object Smash {
    implicit object SmashInt extends Smash[Int] {
      def smash(a: Int, b: Int): Int = a + b
    }

    implicit object SmashDouble extends Smash[Double] {
      def smash(a: Double, b: Double): Double = a * b
    }

    // e) Реализуйте функцию Smash для типа String. Необходимо выполнить конкатенацию строк,
    // которые будут получены в качестве параметра.
    implicit object SmashString extends Smash[String] {
      def smash(a: String, b: String): String = a + b
    }
  }

  // Примените тайп-класс-решение из пункта (d) здесь
  def testSmashInt(a: Int, b: Int): Int = Smash.SmashInt.smash(a, b)

  // Примените тайп-класс-решение из пункта (d) здесь
  def testSmashDouble(a: Double, b: Double): Double = Smash.SmashDouble.smash(a, b)

  // Примените тайп-класс-решение из пункта (e) здесь
  def testSmashString(a: String, b: String): String = Smash.SmashString.smash(a, b)
}

// Реализуйте тестовые функции с выводом на экран проверки разработанных функций.