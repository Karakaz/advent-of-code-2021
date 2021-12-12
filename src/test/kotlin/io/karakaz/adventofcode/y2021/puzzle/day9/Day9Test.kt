package io.karakaz.adventofcode.y2021.puzzle.day9

import mu.KotlinLogging
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

private val logger = KotlinLogging.logger {}

internal class Day9Test {

    @Test
    fun sumOfRiskLevelsTest() {
        val heightmap = readInputToHeightmap("day9/heightmap-trial.txt")
        val sumOfRiskLevels = heightmap.sumOfRiskLevels()
        logger.info { "Sum of risk levels: $sumOfRiskLevels" }
        assertEquals(15, sumOfRiskLevels)
    }

    @Test
    internal fun theThreeLargestBasinsMultipliedTest() {
        val basinFinder = readInputToBasinFinder("day9/heightmap-trial.txt")
        val result = findTheThreeLargestBasinsMultiplied(basinFinder)
        logger.info { "The three largest basins multiplied: $result" }
        assertEquals(1134, result)
    }
}