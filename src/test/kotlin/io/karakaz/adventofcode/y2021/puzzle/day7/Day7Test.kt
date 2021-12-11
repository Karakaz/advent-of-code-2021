package io.karakaz.adventofcode.y2021.puzzle.day7

import io.karakaz.adventofcode.y2021.util.readFileAsLines
import mu.KotlinLogging
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

private val logger = KotlinLogging.logger {}

internal class Day7Test {

    @Test
    fun computeCheapestAlignmentConstantFuelCostTest() {
        val crabPositions = readFileAsLines("day7/crab-positions-trial.txt").first().split(",").map { it.toInt() }
        val (position, fuelCost) = computeCheapestAlignmentConstantFuelCost(crabPositions)
        logger.info { "Cheapest position: $position, fuel cost: $fuelCost" }
        assertEquals(37, fuelCost)
    }

    @Test
    internal fun computeCheapestAlignmentLinearFuelCostTest() {
        val crabPositions = readFileAsLines("day7/crab-positions-trial.txt").first().split(",").map { it.toInt() }
        val (position, fuelCost) = computeCheapestAlignmentLinearFuelCost(crabPositions)
        logger.info { "Cheapest position: $position, fuel cost: $fuelCost" }
        assertEquals(168, fuelCost)
    }
}