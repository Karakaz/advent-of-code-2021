package io.karakaz.adventofcode.y2021.puzzle.day9

import io.karakaz.adventofcode.y2021.util.readFileAsLines
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

class BasinFinder(private val points: List<IntArray>) {

    private val minX = 0
    private val minY = 0
    private val maxX = points[minY].size - 1
    private val maxY = points.size - 1
    private val checkedPoints = mutableSetOf<Pair<Int, Int>>()

    fun findBasinSizes(): List<Int> = findLowPoints().map { exploreFromPoint(it) }

    private fun findLowPoints(): List<Pair<Int, Int>> {
        return points.indices.flatMap { y ->
            points[y].indices.mapNotNull { x ->
                lowPoint(y, x)
            }
        }
    }

    private fun lowPoint(y: Int, x: Int): Pair<Int, Int>? {
        val point = points[y][x]
        if (y > minY && points[y - 1][x] <= point) return null
        if (y < maxY && points[y + 1][x] <= point) return null
        if (x > minX && points[y][x - 1] <= point) return null
        if (x < maxX && points[y][x + 1] <= point) return null
        return y to x
    }

    private fun exploreFromPoint(point: Pair<Int, Int>): Int {
        if (points[point.y()][point.x()] == 9 || checkedPoints.contains(point)) return 0
        checkedPoints.add(point)
        var size = 1
        if (point.y() > minY) size += exploreFromPoint(point.y() - 1 to point.x())
        if (point.y() < maxY) size += exploreFromPoint(point.y() + 1 to point.x())
        if (point.x() > minX) size += exploreFromPoint(point.y() to point.x() - 1)
        if (point.x() < maxX) size += exploreFromPoint(point.y() to point.x() + 1)
        return size
    }

    private fun Pair<Int, Int>.y() = this.first
    private fun Pair<Int, Int>.x() = this.second
}

fun findTheThreeLargestBasinsMultiplied(basinFinder: BasinFinder): Int =
    basinFinder.findBasinSizes()
        .sortedDescending()
        .take(3)
        .reduce { a, b -> a * b }


fun readInputToBasinFinder(filepath: String): BasinFinder =
    BasinFinder(
        readFileAsLines(filepath).map { line ->
            line.map { Character.getNumericValue(it) }.toIntArray()
        }
    )

fun main() {
    val basinFinder = readInputToBasinFinder("day9/heightmap.txt")
    val result = findTheThreeLargestBasinsMultiplied(basinFinder)
    logger.info { "The three largest basins multiplied: $result" }
}