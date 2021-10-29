import uni.removek

import java.io
import scala.io.StdIn.readInt
import scala.language.postfixOps
import scala.math.pow

object uni {
def main(args: Array[String]): Unit ={
  println(mult("string"));
  println(product("string"));
  println(recprod("string"));
  println(xnsolv(2,3))
  println(natsum(5,7))
  println(lists(List(List(1, 1), 2, List(3, List(5, 8)))))
  println(biggestdiv(321))
  println("Enter multiplier\n")
  //println(listMult(List(1,2,3),readInt()))
  println(commonCrat(3,22))
  println("Enter value\n")
  //println(removek(List(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15),readInt()))
  println(places(7,5))
  println("Enter value\n")
  //println(offsetk(List(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15),readInt()))
  println(perfect(8))
  splitter(List(1,2,3,4,5,6,7,8,9))
  println(strange(512))
  println(corteges(List((1,"First"),(2,"Second"),(3,"Third"))))
}
def mult(s: String)={
    var t:BigInt=1;
    for(i<-s) t*=i.toInt;
    t;
  }
def product(s: String):BigInt={s.map(x => x.toLong) reduce ((y, x) => y * x);}
def recprod(s: String): BigInt={var t =s.toList; if(t.isEmpty) 1 else t.head.toLong * recprod(s.tail) }
  def xnsolv(x:Double,n:Int):Double= {if(n == 0) 1  else if(n>0) x * xnsolv(x,n-1) else 1/xnsolv(x,-n) }

  def natsum(n:Int,m:Int)={
    var lst : List[Int] = List();
    var strs : List[String] = List();
    for(i<-n to m){
      strs=strs:+i.toString;
    }
    for(str<-strs){
      for(s<-str){
        if(str.filter(x=>x==s).length==1) lst=lst:+str.toInt;
      }
    }
    lst.sum;
  }
  def lists(l:List[Any]):List[Int]={
    var res: List[Int] = List();
    for(i<-l){
      if(i.isInstanceOf[List[Any]]){
        res = res++lists(i.asInstanceOf[List[Any]]);
      }
      else{
        res = res:+i.asInstanceOf[Int];
      }
    }
    res;
  }

  def biggestdiv(n: Int): Int ={
    for(i<- 1 to n-1 reverse) if(n%i==0){
      var res=0;
      val str = i.toString;
      for(i<-str) res+=i.asDigit
      return res
   }
   1
  }

  def listMult(l:List[Any],n: Int) ={
    var res: List[Any] = List()
    for(i<- l;j<- 1 until n+1){
      res=res :+ i
    }
    res
  }

  def commonCrat(n:Int, m:Int): Int ={
    return m * (n / noc(n, m))
  }

  def noc(n:Int, m:Int) : Int={
    if (m == 0) {
      return n
    }
    else {
      return noc(m, n % m)
    }
  }

  def removek(l: List[Any],k:Int)={
    var lst: List[Any] = List()
    var i =1
    for(t<-l){
      if(i!=k){
        lst= lst:+t
        i+=1
      }
      else {
        i=1
      }
    }
    lst
  }

  def places(n: Int, k: Int): BigInt ={
    var res:BigInt =1
    for(t<-n-k+1 to n) res*=t
    return  res
  }

  def offsetk(l:List[Any],k:Int)={
    var lst:List[Any] = l
    for(l<-0 to k-1) {
      var t = lst.head
      lst = lst.drop(1)
      lst = lst:+t
    }
    lst
  }

  def perfect(n: Int): Int ={
    var seq = (2 to n).filter(x=>(1 to x-1).filter(t=>x%t==0).sum == x).max
    seq
}

  def splitter(enter:List[Any])={
    var l1:List[Any] = List()
    var l2:List[Any] = List()
    var i =0;
    for(t<-enter){
      if(i%2==0){
        l1= l1:+t
      }
      else {
        l2= l2:+t
      }
      i+=1
    }
    println(l1)
    println(l2)
  }

  def strange(n:Int)={
    var max =0;
    var sum =0
    for(i<-n.toString) sum+=i.asDigit

    for(k<- 1 to n){
      var t=0
      var c=2
      while (t<n){
          t=pow(sum,c).toInt
          c+=1
      }
      if (t == n && sum>max){
        max = sum
      }
    }
    max
  }

  def corteges(l:List[Tuple2[Int,String]])={
    var l1:List[Int] = List()
    var l2:List[String] = List()
    var i =0;
    for(t<-l){
        l1= l1:+t._1
        l2= l2:+t._2
    }
    println(l1)
    println(l2)
  }
}
object MainFirst{
  def main(args: Array[String])={
    println(removek(List(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15),readInt()))
  }
}

