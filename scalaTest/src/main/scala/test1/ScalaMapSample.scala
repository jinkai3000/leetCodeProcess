package test1

/**
  * Created by JinKai on 2016/12/12.
  */
object ScalaMapSample extends App {

  def process(xs : List[Int]) : List[Int] = {
//    xs.filter(_ > 2).map(_ * 2)
    xs.par.filter( x =>{
      println(s"Filter paramter $x , in Thread ${Thread.currentThread().getName}")
      x > 2
    }).map(x => {
      println(s"Mapping paramter $x , in Thread ${Thread.currentThread().getName}")
      x*2
    }).toList

  }

  def process2(xs : List[Int]) : List[String]= {

    xs.map(x=>{
      s"a_$x"
    })

  }

//  var result = process(List(1,2,3,4,5))
//
//  println(result)

  println(process2(List(2,3,4)))

}
