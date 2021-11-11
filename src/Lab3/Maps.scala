package Lab3

import scala.annotation.tailrec

/** Напишите вашу реализацию в тестовые функции.
  * 
  * https://docs.scala-lang.org/overviews/collections/maps.html
  */
object Maps {

  case class User(name: String, age: Int)

  /* a) В данной Seq[User] сгруппируйте пользователей по имени (`groupBy`)
       * и вычислите средний возраст: `name -> averageAge`. Вы можете реализовать
       * ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
       */
  def testGroupUsers(users: Seq[User]): Map[String, Int] = {
    def ages(seq: Seq[Int]) = seq.sum / seq.length
    users.groupBy(_.name).map {
      pair => (pair._1, ages(pair._2.map(_.age)))
    }
  }

  /* b) Дана `Map[String, User]` состоящая из имен пользователей `User`, сколько имен пользователей,
   * содержащихся в Map, содержат подстроку "Adam"? Вы можете реализовать ваше решение в
   * теле тестовой функции. Не изменяйте сигнатуру.
   */
  def testNumberFrodos(map: Map[String, User]): Int = {
    @tailrec
    def loop(in: List[(String, User)], out: Int): Int = in.length match {
      case 0 => out
      case _ =>
        val one = in.head._1
        val two = in.head._2.name
        var t: Int = out
        if (one.contains("Adam") || two.contains("Adam")) t+=1
        loop(in.tail, t)
    }
    loop(map.toList, 0)
  }

  /* c) Удалите всех пользователей возраст которых менее 35 лет.
   * Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
   */
  def testUnderaged(map: Map[String, User]): Map[String, User] = {
    map.filter(x=>x._2.age >= 35)
  }
}
