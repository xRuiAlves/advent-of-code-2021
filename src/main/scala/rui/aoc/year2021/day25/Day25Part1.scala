package rui.aoc.year2021.day25

import rui.aoc.year2021.ProblemSolution
import rui.aoc.year2021.utils.FileIO

import scala.annotation.tailrec

class Day25Part1 extends ProblemSolution {
  private[this] final val EmptyCell = '.'
  private[this] final val RightFacingCell = '>'
  private[this] final val DownFacingCell = 'v'

  override def solve(): AnyVal = {
    val map = FileIO.readResourceLines("day25.txt").map(_.toCharArray)
    step(map)
  }

  @tailrec
  private final def step(map: Array[Array[Char]], stepNumber: Int = 1): Int = {
    var moved = false
    val cells = (for (i <- map.indices; j <- map(i).indices) yield (i, j)).toSet

    val toMoveHorizontally = cells.filter { case (i, j) => map(i)(j) == RightFacingCell && map(i)((j + 1) % map(i).length) == EmptyCell }
    toMoveHorizontally.foreach { case (i, j) =>
      moved = true
      map(i)(j) = EmptyCell
      map(i)((j + 1) % map(i).length) = RightFacingCell
    }

    val toMoveVertically = cells.filter { case (i, j) => map(i)(j) == DownFacingCell && map((i + 1) % map.length)(j) == EmptyCell }
    toMoveVertically.foreach { case (i, j) =>
      moved = true
      map(i)(j) = EmptyCell
      map((i + 1) % map.length)(j) = DownFacingCell
    }

    if (moved) step(map, stepNumber + 1)
    else stepNumber
  }
}
