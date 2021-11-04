package Lab2
import scala.annotation.tailrec

/** Реализуйте функции для решения следующих задач.
  * Примечание: Попытайтесь сделать все функции с хвостовой рекурсией, используйте аннотацию для подстверждения.
  * рекурсия будет хвостовой если:
  *   1. рекурсия реализуется в одном направлении
  *   2. вызов рекурсивной функции будет последней операцией перед возвратом
  */
object RecursiveFunctions {
  /* a) Напишите функцию которая записывает в обратном порядке список:
   *        def reverse[A](list: List[A]): List[A]
   */
  def reverse[A](l: List[A]): List[A]={
    @tailrec
    def loop(lst: List[A], temp: List[A]): List[A] = {
      if (lst.length == 0) temp
      else loop(lst.tail,lst.head +:temp)
  }
    loop(l, List.empty[A])
  }
  // используйте функцию из пункта (a) здесь, не изменяйте сигнатуру
  def testReverse[A](list: List[A]): List[A] = reverse(list)
  /* b) Напишите функцию, которая применяет функцию к каждому значению списка:
   *        def map[A, B](list: List[A])(f: A => B): List[B]
   */
  def map[A, B](list: List[A])(f: A => B): List[B] ={
    @tailrec
    def loop(lst: List[A], temp: List[B]): List[B] = {
    if (lst.length == 0) temp
    else loop(lst.tail,temp :+f(lst.head))
  }
    loop(list, List.empty[B])
  }
  // используйте функцию из пункта  (b) здесь, не изменяйте сигнатуру
  def testMap[A, B](list: List[A], f: A => B): List[B] = map(list)(f)
  /* c) Напишите функцию, которая присоединяет один список к другому:
   *        def append[A](l: List[A], r: List[A]): List[A]
   */
  def append[A](l: List[A], r: List[A]): List[A]={
    @tailrec
    def loop(lst: List[A], temp: List[A]): List[A] ={
    if (temp.length == 0) lst
    else loop(lst:+ temp.head,temp.tail)
  }
    loop(l,r)
  }
  // используйте функцию из пункта  (c) здесь, не изменяйте сигнатуру
  def testAppend[A](l: List[A], r: List[A]): List[A] = append(l,r)
  /* d) Напишите функцию, которая применяет функцию к каждому значению списка:
   *        def flatMap[A, B](list: List[A])(f: A => List[B]): List[B]
   * 
   *    она получает функцию, которая создает новый List[B] для каждого элемента типа A в 
   *    списке. Поэтому вы создаете List[List[B]]. 
   */
  def flatMap[A, B](list: List[A])(f: A => List[B]): List[B]={
    @tailrec
    def loopf(lst: List[A], temp: List[List[B]]): List[List[B]] =  {
    if (lst.length == 0) temp
    else loopf(lst.tail,temp:+ f(lst.head))
    }
    @tailrec
    def loops(lst: List[List[B]], temp: List[B]): List[B] =  {
    if (lst.length == 0) temp
    else loops(lst.tail,append(temp,lst.head))
    }
    loops(loopf(list,List.empty[List[B]]),List.empty[B])
  }
  // используйте функцию из пункта  (d) здесь, не изменяйте сигнатуру
  def testFlatMap[A, B](list: List[A], f: A => List[B]): List[B] = flatMap(list)(f)
  /* e) Вопрос: Возможно ли написать функцию с хвостовой рекурсией для `Tree`s? Если нет, почему? */
  // Нельзя, т.к. хвостовая рекурсия не позволяет возвращаться к пройденным элементам,
  // а в рекурсивных методах это требутся для получения результата
}
