package Lab2

object Lab2Main {
  def main(args: Array[String]): Unit = {
    println("Compositions")
    println("Compositions.testCompose((s:String)=>s.toUpperCase())((s:String)=>s.filter(ch=>ch!='R'))((s:String)=>s.toLowerCase)(\"Enter Str\") "
      + Compositions.testCompose((s:String)=>s.toUpperCase())((s:String)=>s.filter(ch=>ch!='R'))((s:String)=>s.toLowerCase)("Enter Str"))
    println("Compositions.testMapFlatMap((n:Int)=>Some(n/2))((n:Int)=> Some(n.toString))((s:String)=>s.toList)(Some(200)) "
      + Compositions.testMapFlatMap((n:Int)=>Some(n/2))((n:Int)=> Some(n.toString))((s:String)=>s.toList)(Some(200)))
    println("Compositions.testForComprehension((n:Int)=>Some(n/2))((n:Int)=> Some(n.toString))((s:String)=>s.toList)(Some(200)) "+Compositions.testForComprehension((n:Int)=>Some(n/2))((n:Int)=> Some(n.toString))((s:String)=>s.toList)(Some(200)))
    println("RecData")
    println("RecursiveData.testListIntEmpty(List(1,2,3,4,5)) " + RecursiveData.testListIntEmpty(List(1,2,3,4,5)))
    println("RecursiveData.testListIntEmpty(List()) " + RecursiveData.testListIntEmpty(List()))
    println("RecursiveData.testListIntHead(List(1,2,3,4,5)) " + RecursiveData.testListIntHead(List(1,2,3,4,5)))
    println("RecursiveData.testListIntHead(List()) " + RecursiveData.testListIntHead(List()))
    println("RecFunc")
    println("RecursiveFunctions.testReverse(List(\"First\",\"Second\",\"Third\")) " +RecursiveFunctions.testReverse(List("First","Second","Third")))
    println("RecursiveFunctions.testMap(List(1,2,3,4,5),(x:Int)=>if(x%2==0) x else -1) "+ RecursiveFunctions.testMap(List(1,2,3,4,5),(x:Int)=>if(x%2==0) x else -1))
    println("RecursiveFunctions.testAppend(List(1,2,3,4,5),List(6,7,8,9)) "+ RecursiveFunctions.testAppend(List(1,2,3,4,5),List(6,7,8,9)))
    println("RecursiveFunctions.testFlatMap(List(\"This is string and num \",15.toString),(x:String)=>x.toList) "+ RecursiveFunctions.testFlatMap(List("This is string and num ",15.toString),(x:String)=>x.toList))
  }
}
