package scagalife

import Patterns._

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl._

object GameOfLife {

  def main(args: Array[String]): Unit = {

    implicit val system = ActorSystem("Scagalife")
    implicit val materializer = ActorMaterializer()

    scan(World(diehard))(World.step).runForeach { world =>
      show(world, 100, 40)
      Thread.sleep(500)
    }
  }

  //TODO make it stoppable :-)
  def scan[A](a: A)(f: A => A) : Source[A, NotUsed] = {
    Source.repeat(()).scan(a)((b: A, u: Unit) => f(b))
  }

  //TODO Do it with a nice scalajs app
  def show(w: World, gridX: Int, gridY: Int): Unit = {
    val gx = gridX/2
    val gy = gridY/2
    (-gy to gy).reverseMap { y =>
      println()
      (-gx to gx).map { x =>
        if(w.cells.contains(Cell(x, y))) {
          print("*")
        } else {
          print("-")
        }
      }
    }
    println()
  }
}

