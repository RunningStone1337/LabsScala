package Lab1

object Functions {
  /* a) Напишите функцию, которая рассчитывает площадь окружности
   *    r^2 * Math.PI
   */
  def area(rad: Double) = rad * rad * Math.PI

  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testCircle(r: Double): Double = area(r)

  /* b) Напишите карированную функцию которая рассчитывает площадь прямоугольника a * b.
   */
  def carirArea(a: Double) = (b: Double) => a * b

  // примените вашу функцию из пукта (b) здесь, не изменяя сигнатуру
  def testRectangleCurried(a: Double, b: Double): Double = carirArea(a)(b)

  // c) Напишите не карированную функцию для расчета площади прямоугольника.
  def simpleArea(a: Double, b: Double) = a * b

  // примените вашу функцию из пункта (c) здесь, не изменяя сигнатуру
  def testRectangleUc(a: Double, b: Double): Double = simpleArea(a, b)
}
