package algo

import scala.collection.mutable.ArrayBuffer

object Equilb {

  val arr: ArrayBuffer[Int] = ArrayBuffer(3, 5, 10, 4, 4)

  val arrayLeft: ArrayBuffer[Int] = ArrayBuffer(0)
  val arrayRight: ArrayBuffer[Int] = ArrayBuffer.empty
  /*
  *  1st element left nothing (0) right  5, 10, 4, 4
  *  2nd element left 3 right 10, 4, 4
  *  3rd element left 3, 5 right 4, 4
  * */

  for( i <- 0 until arr.length) {

    if(i > 0) {
      arrayLeft.addOne(arr(i))
    } else {
      arrayRight.addOne(arr(i))
    }

    if(arrayLeft.sum == arrayRight.sum) println(s"equilibrium is = $i") else println("Not")

  }

}
