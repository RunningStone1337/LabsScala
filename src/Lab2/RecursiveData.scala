package Lab2
/** Напишите свои решения в виде функций. */
 object RecursiveData {
  // a) Реализуйте функцию, определяющую является ли пустым `List[Int]`.
  def IsListIntEmpty(l: List[Int])  ={
    if (l == null || l == Nil) true
    else  false
  }
  // используйте функцию из пункта (a) здесь, не изменяйте сигнатуру
  def testListIntEmpty(list: List[Int]): Boolean = IsListIntEmpty(list)

  // b) Реализуйте функцию, которая получает head `List[Int]`или возвращает -1 в случае если он пустой.
  def ListIntHead(lst: List[Int]): Int = {
    if (IsListIntEmpty(lst)) -1
    else lst.head
  }
  // используйте функцию из пункта (b) здесь, не изменяйте сигнатуру
  def testListIntHead(list: List[Int]): Int = ListIntHead(list)

  /* d) Реализуйте универсальное дерево (Tree) которое хранит значения в виде листьев и состоит из:
   *      node - левое и правое дерево (Tree)
   *      leaf - переменная типа A
   */
  trait Tree[A]
  case class Node[A](ln:Tree[A], rn:Tree[A]) extends Tree[A]
  case class Leaf[A](vl:A) extends Tree[A]

}

