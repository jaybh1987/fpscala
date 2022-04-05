package algo.binaryheap

import scala.annotation.tailrec

/*
* Reference Link:
*   https://www.geeksforgeeks.org/min-heap-in-java/
*   https://selcote.medium.com/how-to-implement-a-binary-heap-in-java-9bfcf3b9a947
*
* */



/*testing */


/*
* Array Base representation ,
* This can be achieve in scala using recursive data structure | aljebrick data type.
* */

/*
* Overview
* Return parent node Arr( (i - 1) / 2 )
* Return the left child node Arr( (2 * i) + 1 )
* Return the right child node Arr( (2 * i) + 2 )
*
* */


object TestFold {


  def fun(upto: Int): Unit = {

    def loop(fst: Int, snd: Int): Unit = {
      if(snd > upto) {
        print(" End")
      } else {
        print(s"$fst , ")
        loop(snd, fst + snd)
      }
    }

    loop(0, 1)
  }

  import scala.collection.mutable.ArrayBuffer
  def fib(n: Int): Int = if( n <= 1) n else fib(n - 1) + fib(n - 2)

  def fun2(x: Int): Unit = {
    var f : ArrayBuffer[Int] = ArrayBuffer.empty
      f.update(0, 0)
    for(i <- 2 until x) {
      f(i) = f(i - 1) + f(i - 2)
      print(f(i))
    }
  }

  @tailrec
  def map[A, B](l: List[A])(f: A => B)(ls: List[B] = Nil) : List[B] = {
    l match {
      case h :: t => map(t)(f)(f(h) +: ls)
      case Nil => ls
    }
  }

}

object BinaryHeap extends App{

  var heap : Array[Int] = Array.empty[Int]
  var size: Int = 0
  var max: Int = 0

  def isFull(): Boolean = size == max

  def getParent(index: Int): Int = (index - 1) / 2

  def apply(capacity: Int) = {
    max = capacity
    heap = new Array[Int](capacity)
    this
  }

  def insert(elm: Int) = {

    if(size >= max) {
      println("HEAP is full!")
    } else {
      heap(size) = elm
      heapify(size)
      size+=1
    }
    this
  }

  def heapify(index: Int): Unit = {

    var pos = index
    var newValue = heap(index)

    while(pos > 0 && newValue > heap(getParent(pos))) {
      heap(pos) = heap(getParent(pos))
      pos = getParent(pos)
    }

    heap(pos) = newValue
  }

  apply(7)
    .insert(500)
    .insert(1)
    .insert(10)
    .insert(800)
    .insert(90)
    .insert(25)
    .insert(18)

  heap.foreach( println(_))
}










