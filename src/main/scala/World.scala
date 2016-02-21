package scagalife

case class World(cells: List[Cell]) {
  def step : World = {
    cells.foldLeft((List():List[Cell], Map():Map[Cell, Int])){(acc, cell) =>
      acc match { case (livingCells, foetusCells) =>
        val (countNeighbors, innerFetusCells) = cell.neighbors.foldLeft(0, foetusCells){
          (innerAcc, neighbor) => {
            innerAcc match {case (count, ifc) =>
              if(cells.contains(neighbor)){
                (count + 1, ifc)
              }else{
                (count, ifc.get(neighbor).map{
                  nb=> ifc + (neighbor -> (nb+1))
                }.getOrElse(ifc + (neighbor -> 1)))
              }
            }
          }
        }
        if(countNeighbors == 2 || countNeighbors == 3){
          (livingCells :+ cell, innerFetusCells)
        }else{
          (livingCells, innerFetusCells)
        }
      }
    } match { case (livingCells, foetusCells) =>
      World(
        livingCells ++ foetusCells.flatMap{
          case (cell, nb) => if(nb == 3) Some(cell) else None
        }
      )
    }
  }
}
