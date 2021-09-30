package Books.FPScalaManning.Chapter13
import Books.FPScalaManning.Chapter7.Monad
import scala.io.StdIn.readLine


case class Player(name: String, score: Int)

object Player {

//  def contest(p1: Player, p2: Player): Unit = if(p1.score > p2.score) {
//    println(s"${p1.name} is the winner!")
//  } else if(p2.score > p1.score) {
//    println(s"${p2.name} is the winner!")
//  } else println("It's a draw.")


  /*factoring pure login.*/
  //computation for winner
  def winner(p1: Player, p2: Player): Option[Player] = if(p1.score > p2.score) Some(p1)
  else if (p1.score < p2.score) Some(p2)
  else None

  /*
  responsibility of declaring the winner on the console.
  still has 2 responsibility.
  computing which msg to display
  then printing the msg.
  */
//  def contest(p1: Player, p2: Player): Unit = winner(p2, p2) match {
//    case Some(Player(name, _)) => println(s"$name is the winner.")
//    case None => println("It's a draw")
//  }


  /* perform refactoring for contest again.*/

  def winnerMsg(p: Option[Player]): String = p.map {
    case Player(name, _) => s"$name is the winner !"
  }.getOrElse("It's a draw.")

//  def contest(p1: Player, p2: Player): Unit = println(winnerMsg(winner(p1, p2)))

  /*
  * Eventually, we reach functions that seem to necessitate side effects like the built-in println , which has type
  * String => Unit .
  * What do we do then?
  * */

//  trait IO { self =>
//    def run: Unit
//    def ++(io: IO): IO = new IO {
//      override def run: Unit = self.run; io.run
//    }
//  }
//
//  object IO {
//    def empty: IO = new IO {
//      override def run: Unit = ()
//    }
//  }

//  def PrintLine(msg: String): IO = new IO {
//    override def run: Unit = println(msg)
//  }

  /*now contest is pure functon returning a IO value.
  * IO describe action need to be take place but doesn't actually execute.
  * contest has an effect or is effectful,
  * but it is only the interpreter of IO that actually has side effect.
  * here responsibility of interpreting the effect and actually manupulating console is held by
  * run method of IO.
  * */
//  def contest(p1: Player, p2: Player): IO = PrintLine(winnerMsg(winner(p1, p2)))

  /*
  * encounter a program that can't be express.
  * */

  def fahrenheitToCelsius(f: Double): Double = ( f - 32 ) * 5.0 / 9.0

  def converter: Unit = {
    println("Enter a tempreature in degrees fahrenheit: ")
    val d = readLine().toDouble
    println(fahrenheitToCelsius(d))
  }

//  def converter2: IO = {
//    val prompt: IO = PrintLine( "Enter a tem in degrees Fahrenheit: ")
//    ???
//  }

  sealed trait IO[A] {
    self =>
    def run: A
    def map[B](f: A => B): IO[B] = new IO[B] {
      def run: B = f(self.run)
    }
    def flatMap[B](f: A => IO[B]): IO[B] = new IO[B] {
      def run = f(self.run).run
    }
  }

  object IO extends Monad[IO] {
    def unit[A](a: => A): IO[A] = new IO[A] { def run = a }

    def flatMap[A, B](fa: IO[A])(f: A => IO[B]): IO[B] = fa.flatMap(f)

    def apply[A](a: => A): IO[A] = unit(a)
  }

  def ReadLine: IO[String] = IO { readLine }
}































