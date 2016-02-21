package scagalife

import scala.annotation.tailrec
import Patterns._

object GameOfLife{
  def main(args:Array[String]):Unit ={
    loop(World(diehard), 100, 40, 500)
  }

  //TODO make it stop :-)
  @tailrec
  def loop(world:World, gridX:Int, gridY:Int, sleepTime: Int):Unit ={
    show(world, gridX, gridY)
    Thread.sleep(sleepTime)
    loop(world.step, gridX, gridY, sleepTime)
  }

  //TODO Do it with a nice scalajs app
  def show(w:World, gridX:Int, gridY:Int):Unit = {
    val gx = gridX/2
    val gy = gridY/2
    (-gy to gy).reverseMap{ y =>
      println()
      (-gx to gx).map{ x =>
        if(w.cells.contains(Cell(x,y))){
          print("*")
        }else{
          print("-")
        }
      }
    }
    println()
  }
}

