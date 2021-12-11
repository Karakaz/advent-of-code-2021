package io.karakaz.adventofcode.y2021.puzzle.day7

import io.karakaz.adventofcode.y2021.util.readFileAsLines
import mu.KotlinLogging
import kotlin.math.abs

private val logger = KotlinLogging.logger {}

fun computeCheapestAlignmentConstantFuelCost(positions: List<Int>): Pair<Int, Int> {
    return computeCheapestAlignment(positions) { it }
}

fun computeCheapestAlignmentLinearFuelCost(positions: List<Int>): Pair<Int, Int> {
    return computeCheapestAlignment(positions) { distance -> (0..distance).sum() }
}

fun computeCheapestAlignment(positions: List<Int>, costFunction: (Int) -> Int): Pair<Int, Int> {
    val lowestPosition = positions.minOrNull()!!
    val highestPosition = positions.maxOrNull()!!
    return (lowestPosition..highestPosition)
        .map { toPosition -> toPosition to positions.sumOf { costFunction(abs(it - toPosition)) } }
        .windowed(2)
        .first { it[0].second < it[1].second }[0]
}

fun main() {
    val crabPositions = readFileAsLines("day7/crab-positions.txt").first().split(",").map { it.toInt() }
    val (positionConstant, fuelCostConstant) = computeCheapestAlignmentConstantFuelCost(crabPositions)
    val (positionLinear, fuelCostLinear) = computeCheapestAlignmentLinearFuelCost(crabPositions)
    logger.info { "Cheapest position: $positionConstant, fuel cost: $fuelCostConstant" }
    logger.info { "Cheapest position: $positionLinear, fuel cost: $fuelCostLinear" }
}
