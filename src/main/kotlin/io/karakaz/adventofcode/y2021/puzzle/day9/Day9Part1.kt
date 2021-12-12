package io.karakaz.adventofcode.y2021.puzzle.day9

import io.karakaz.adventofcode.y2021.util.readFileAsLines
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

class Heightmap(private val points: List<IntArray>) {

    private val minX = 0
    private val minY = 0
    private val maxX = points[minY].size - 1
    private val maxY = points.size - 1

    fun sumOfRiskLevels(): Int {
        return points.indices.sumOf { y ->
            points[y].indices.sumOf { x ->
                riskLevel(y, x)
            }
        }
    }

    private fun riskLevel(y: Int, x: Int): Int {
        val point = points[y][x]
        if (y > minY && points[y - 1][x] <= point) return 0
        if (y < maxY && points[y + 1][x] <= point) return 0
        if (x > minX && points[y][x - 1] <= point) return 0
        if (x < maxX && points[y][x + 1] <= point) return 0
        return point + 1
    }
}


fun readInputToHeightmap(filepath: String): Heightmap =
    Heightmap(
        readFileAsLines(filepath).map { line ->
            line.map { Character.getNumericValue(it) }.toIntArray()
        }
    )

fun main() {
    val heightmap = readInputToHeightmap("day9/heightmap.txt")
    val sumOfRiskLevels = heightmap.sumOfRiskLevels()
    logger.info { "Sum of risk levels: $sumOfRiskLevels" }
}