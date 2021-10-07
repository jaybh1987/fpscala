package algo

import scala.collection.mutable.ArrayBuffer

object Equilb {


  def compareFirst(l: List[Int]): Int = l match {
    case h :: tail if h == tail.sum => h
    case _ => 0
  }

  def leftSum(l: List[Int], index: Int): List[Int] = (l, index) match {
    case (Nil, _) => Nil
    case (_ , 0)  => Nil
    case (h :: tail, idx) => h :: leftSum(tail, idx - 1)
  }

  def rightSum(l: List[Int], index: Int): List[Int] = l.takeRight(l.length - index - 1)

  def lengthCheck(l: List[Int]) = l.length <= 2

  def findEq(ls: List[Int]) = ls.zipWithIndex.map {
    case (_, idx) =>
      if(idx == 0) compareFirst(ls)
      else {
        if(leftSum(ls, idx).sum == rightSum(ls, idx).sum) ls(idx) else 0
      }
  }.sum


  def go(l: List[Int]) = if(lengthCheck(l)) {
    l match {
      case h :: tail if(h == tail.sum) => h
      case _ => 0
    }
  } else {
    findEq(l)
  }


}
