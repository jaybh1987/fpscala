package Books.FPScalaManning.Chapter14

import scala.annotation.tailrec


case class Foo(s: String)

object Purity {
  //method with side effect
  def timesTwo(x: Int) = {
    if(x < 0) println("Got a negative number.")
    x * 2
  }


  def loop(l: List[Int]): List[Int] = {
    def fn(ls: List[Int], ansList: List[Int]): List[Int] = ls match {
      case h :: t => fn(t, ansList :+ (h * h))
      case Nil => ansList
    }
    fn(l, Nil)
  }

  /*
  * List(1,2)
  *
  * fn( (1, 2), Nil ) = (1, 2)
  *
  * 1 :: (2) => fn( (2), Nil :+ (1 * 1)  )
  * 2 :: Nil => fn( Nil, List(1) :+ (2 * 2) )
  *
  * List(1, 4)
  * */

}
