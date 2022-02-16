package algo.binaryheap

/*
* Reference Link: https://www.geeksforgeeks.org/min-heap-in-java/
* */

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


object BinaryHeap extends App{

  var heap: Array[Int] = Array.empty[Int]
  var size: Int = 0
  var maxSize: Int = 0

  def parentNode(pos: Int): Int = pos - 1 / 2

  def leftChild(pos: Int): Int = 2 * pos

  def rightChild(pos: Int): Int = (2 * pos) + 1

  def apply(size: Int): BinaryHeap.type = {
    maxSize = size
    heap = new Array[Int](size)
    this
  }

  def swap(current: Int, parentCurrent: Int): BinaryHeap.type  = {
    var temp = heap(current)
    heap(current) = heap(parentCurrent)
    heap(parentCurrent) = temp
    this
  }

  def insert(elm: Int): BinaryHeap.type = {
    if(size >= maxSize) {
      println("Heap is FULL!")
      this
    } else {
      heap(size) = elm
      size+=1
      var current = if(size == maxSize) { maxSize - 1 } else size
      while(heap(current) < heap(parentNode(current))) {
          swap(current, parentNode(current))
          current = parentNode(current)
      }
      this
    }
  }

  apply(3).insert(5).insert(10).insert(23).insert(44)

  heap.foreach(println(_))

}































