package Lab1

object PatternMatching {

  sealed trait Hand

  case object Rock extends Hand

  case object Paper extends Hand

  case object Scissor extends Hand

  sealed trait Result

  case object Win extends Result

  case object Lose extends Result

  case object Draw extends Result

  sealed trait Food

  case object Meat extends Food

  case object Vegetables extends Food

  case object Plants extends Food

  sealed trait Animal {
    val name: String
    var food: Food
  }

  case class Mammal(name: String, var food: Food, var weight: Int) extends Animal

  case class Fish(name: String, var food: Food) extends Animal

  case class Bird(name: String, var food: Food) extends Animal

  /* a) Напишите функцию, которая ставит в соответствие числу строку слудеющим образом:
   * Если:
   *     1 => "it is one"
   *     2 => "it is two"
   *     3 => "it is three"
   *     иначе => "what's that"
   */
  def intToString(n: Int) = n match {
    case 1 => "it is one"
    case 2 => "it is two"
    case 3 => "it is three"
    case _ => "what's that"
  }

  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testIntToString(value: Int): String = intToString(value)

  /* b) Напишите функцию которая возвращает true если переменная `value` принимает значение:
   *     "max" или "Max
   *     "moritz" или "Moritz"
   */
  def isMaxAndMoritz(s: String) = s.toLowerCase() match {
    case "max" => true
    case "moritz" => true
    case _ => false
  }


  // примените функции из пункта (b) здесь, не изменяя сигнатуру
  def testIsMaxAndMoritz(value: String): Boolean = isMaxAndMoritz(value)

  // c) Напишите функцию проверки является ли `value` четным
  def isEven(vl: Int) = if (vl % 2 == 0) true else false


  // примените функции из пункта (c) здесь, не изменяя сигнатуру
  def testIsEven(value: Int): Boolean = isEven(value)

  /* d) Напишите функцию, моделирующую игру в Камень ножницы бумага
   *     1. камень побеждает ножницы
   *     2. ножницы побеждают бумагу
   *     3. бумага побеждает камень
   *    Выиграет ли игрок `a`?
   */
  def paperScisRock(a: Hand, b: Hand) = (a, b) match {
    case (Rock, Scissor) | (Paper, Rock) | (Scissor, Paper) => Win
    /* case (Paper, Rock) =>Win
    case (Scissor, Paper) =>Win*/
    case (Rock, Rock) | (Scissor, Scissor) | (Paper, Paper) => Draw
    /*case (Scissor, Scissor) =>Draw
    case (Paper, Paper) =>Draw*/
    case _ => Lose
  }

  // примените вашу функцию из пункта (d) здесь, не изменяя сигнатуру
  def testWinsA(a: Hand, b: Hand): Result = paperScisRock(a, b)

  // Примечание: используйте определение Animals
  // e) Верните вес (weight: Int) объекта Mammal, иначе верните -1.
  def extractMammalWeight(a: Animal) = a match {
    case a: Mammal => a.weight
    case _ => -1
  }

  // примените функцию из пункта (e) здесь, не изменяйте сигнатуру
  def testExtractMammalWeight(animal: Animal): Int = extractMammalWeight(animal)

  // f) Измените поле еда объектов классов Fishes и Birds на Plants, класс Mammels оставьте неизмененным.
  def updateFood(a: Animal) = a match {
    case a: Mammal => a
    case _ => {
      a.food = Plants; a
    }
  }

  // примените функцию из пункта (f) здесь, не изменяйте сигнатуру
  def testUpdateFood(animal: Animal): Animal = updateFood(animal)
}
