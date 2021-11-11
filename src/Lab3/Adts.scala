package Lab3
import scala.util.{Failure, Success, Try}

/** Реализуйте следующие функции.
  * 
  * List(1, 2) match {
  *   case head :: tail => ???
  *   case Nil          => ???
  *   case l            => ???
  * }
  * 
  * Option(1) match {
  *   case Some(a) => ???
  *   case None    => ???
  * }
  * 
  * Either.cond(true, 1, "right") match {
  *   case Left(i)  => ???
  *   case Right(s) => ???
  * }
  * 
  * Try(impureExpression()) match {
  *   case Success(a)     => ???
  *   case Failure(error) => ???
  * }
  * 
  * Try(impureExpression()).toEither
  * 
  */
object Adts {
  // a) Дан List[Int], верните элемент с индексом n
  def GetNth(list: List[Int], n: Int): Option[Int] = {
    list match {
      case head :: tail =>{if(list.length>=n) Some(list(n)) else None}
      case _ => None
    }
  }

  // Примените функцию из пункта (a) здесь, не изменяйте сигнатуру
  def testGetNth(list: List[Int], n: Int): Option[Int] = GetNth(list, n)

  // b) Напишите функцию, увеличивающую число в два раза.
  def DoubleNum(n: Option[Int]): Option[Int] = {
    n match {
      case Some(x) => Some(x * 2)
      case _ => None
    }
  }

  // Примените функцию из пункта (b) здесь, не изменяйте сигнатуру
  def testDouble(n: Option[Int]): Option[Int] = DoubleNum(n)

  // c) Напишите функцию, проверяющую является ли число типа Int четным. Если так, верните Right.
  // В противном случае, верните Left("Нечетное число.").
  def IsEven(n: Int): Either[String, Int] = {
    Either.cond(n % 2 == 0, n, "Нечетное число")
  }

  // Примените функцию из пункта (c) здесь, не изменяйте сигнатуру
  def testIsEven(n: Int): Either[String, Int] = IsEven(n)

  // d) Напишите функцию, реализующую безопасное деление целых чисел.
  // Верните Right с результатом или Left("Вы не можете делить на ноль.").
  def SafeDivide(a: Int, b: Int): Either[String, Int] = {
    Either.cond(b != 0, a / b, "Вы не можете делить на ноль")
  }

  // Примените функцию из пункта (d) здесь, не изменяйте сигнатуру
  def testSafeDivide(a: Int, b: Int): Either[String, Int] = SafeDivide(a, b)

  // e) Обработайте исключения функции с побочным эффектом вернув 0.
  def GoodOldJava(impure: String => Int, str: String): Try[Int] = {
    Try(impure(str)) match {
      case Success(x) => Success(x)
      case Failure(_) => Success(0)
    }
  }

  // Примените функцию из пункта (e) здесь, не изменяйте сигнатуру
  def testGoodOldJava(impure: String => Int, str: String): Try[Int] = GoodOldJava(impure, str)

}