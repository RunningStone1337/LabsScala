
object CLasses{/*
 * 
 a) Создать класс Animal, который имеет следующие поля:
 *      - name: String (название)
 *      - species: String (вид)
 *      - food: String
 *    Синтаксис: class MyClass(val publicField: Int, privateField: String) {
 *              // остальные поля и методы
 *            }
 */
  class AnimalClass(val name: String,val species: String, val food: String)

/* b) Создайте объект-компаньон для класса Animal и добавьте следующие сущности как поля:
 *      - cat, mammal, meat
 *      - parrot, bird, vegetables
 *      - goldfish, fish, plants
 * 
 *    Синтаксис: object MyClass {
 *              // статические поля и методы
 *            }
 */
object  AnimalObjB{
  case object Cat
  case object Mammal
  case object Meat
  case object Parrot
  case object Bird
  case object Vegitables
  case object Goldfish
  case object Fish
  case object Plants
}

/* c) Добавьте следующие метод в Animals:
 *      def eats(food: String): Boolean
 *     который проверяет ест ли животное определенную пищу
 */
class AnimalClassWithEats(val name: String,val species: String, val food: Food){
  def eats(food: String): Boolean = food == this.food
}
 /* d) Переопределите ваш класс Animal как трейт и создайте объекты класса-образца для Mammals, Birds и Fishs.
 *    Вам все еще нужно поле `species`?
 */
  trait AnimalTr{
  val name: String
  val food: String
  def eats(food: String)= this.food == food
  }
 /* e) Добавьте следующие функции в объект-компаньон Animal:
 *      def knownAnimal(name: String): Boolean  // true если это имя одного из трех животных из (b)
 *      def apply(name: String): Option[Animal] // возвращает одно из трех животных в соответствии с именем (Some) или ничего (None), см. ниже
 */
 object  AnimalObj{
   def knownAnimal(name: String) = name match{
     case "cat" =>true
     case "parrot"=>true
     case "goldfish" =>true
     case _ => false
   }
   def apply(name: String): Option[Animal] = name match{
     case "cat" => Some(Mammals(name, Meat(),4))
     case "parrot" => Some(Birds(name, Vegitables()))
     case "goldfish" => Some(Fishes(name, Plants()))
     case _ => None()
   }
 }
 /* f) Создайте трейт Food со следующими классами-образцами:
 *      - Meat
 *      - Vegetables
 *      - Plants
 *   и добавьте это в определение Animal. Так же добавьте объект-компаньон с методом apply():
 *      def apply(food: String): Option[Food]
 */
trait Food
case class Meat() extends Food
case class Vegitables() extends Food
case class Plants() extends Food

object Food{
  def apply(name: String): Option[Food]={
    name match{
      case ""=> None()
      case "Meat"=> Some(Meat())
      case "Vegitables" => Some(Vegitables())
      case "Plants" => Some(Plants())
    }
  }
}

trait Animal{
  val name: String
  val food: Food
  def eats(food: Food)= this.food == food
}

case class Mammals(name: String, food: Food, weight: Int)extends  Animal
case class Birds(name: String, food: Food)extends  Animal
case class Fishes(name: String, food: Food)extends  Animal

sealed trait Option[A] {
 
  def isEmpty: Boolean
}
case class Some[A](a: A) extends Option[A] {
  val isEmpty = false
}
case class None[A]()     extends Option[A] {
  val isEmpty = true
}
}