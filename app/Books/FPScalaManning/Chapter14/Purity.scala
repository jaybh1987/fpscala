package Books.FPScalaManning.Chapter14


case class Foo(s: String)

object Purity {
  //method with side effect
  def timesTwo(x: Int) = {
    if(x < 0) println("Got a negative number.")
    x * 2
  }



}
