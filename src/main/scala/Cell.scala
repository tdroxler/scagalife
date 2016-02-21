package scagalife

case class Cell(x:Int, y:Int){
  def neighbors = Cell.translate(Cell.neighbors, x, y)
}

object Cell{
  def translate(cells: List[Cell], x:Int, y: Int): List[Cell] = {
    cells.map(cell => Cell(cell.x + x, cell.y + y))
  }

  lazy val neighbors = List(
    Cell(-1,1),  Cell(0,1),  Cell(1,1),
    Cell(-1,0),              Cell(1,0),
    Cell(-1,-1), Cell(0,-1), Cell(1,-1)
  )
}
