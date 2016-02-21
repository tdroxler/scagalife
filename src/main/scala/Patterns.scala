package scagalife

object Patterns{
  lazy val blinker = List(
    Cell(0,-1), Cell(0,0), Cell(0,1)
  )
  lazy val toad = List(
    Cell(0,0),  Cell(1,0), Cell(2,0),
    Cell(-1,-1), Cell(0,-1), Cell(1,-1)
  )
  lazy val glider = List(
    Cell(0,1), Cell(1,0), Cell(-1,-1),
    Cell(0,-1), Cell(1,-1)
  )
  lazy val diehard = List(
    Cell(-3,0), Cell(-2,0), Cell(-2,-1),
    Cell(2,-1), Cell(3,-1), Cell(4,-1),
    Cell(3,1)
  )
  lazy val acorn = List(
    Cell(-3,-1), Cell(-2,-1), Cell(-2,1),
    Cell(0,0), Cell(1,-1), Cell(2,-1),
    Cell(3,-1)
  )
}
