import scala.collection.mutable.ArrayBuffer

val j = List(0, 5, -5)
val k = List(4, 4, 6, 5, 3)


/*
* case (4 :: List(4, 6, 5, 3) , 2) => 4 :: rsum(List(4, 6, 5, 3), 2 - 1)
* case (4 :: List(6, 5, 3), 1) => 4 :: rsum(List(6, 5, 3), 1 - 1)
* case (6 :: List(5, 3) , 0 ) => Nil
*
* */
//put index minus 1



/*
*  case (4 :: List(4, 6, 5, 3), 2 ) => 4 :: leftSum(List(4, 6, 5, 3), 2 - 1)
*  case (4 :: List(6, 5, 3), 1) => 4 :: leftSum(List(6, 5, 3), 1 - 1)
*  case (_, 0) => Nil
*
* */