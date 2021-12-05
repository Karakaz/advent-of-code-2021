package io.karakaz.adventofcode.y2021.puzzle.day1

import io.karakaz.adventofcode.y2021.util.readFileAsLines
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun numberOfIncreasesRefinedSolution(readings: List<Int>): Int {
    return (1 until readings.size)
        .count { readings[it] > readings[it - 1] }
}

fun numberOfIncreasesSlidingWindowOf3RefinedSolution(readings: List<Int>): Int {
    val slides = (2 until readings.size)
        .map { readings[it - 2] + readings[it - 1] + readings[it] }
    return numberOfIncreasesRefinedSolution(slides)
}

fun main() {
    val readings = readFileAsLines("day1/readings.txt").map { it.toInt() }

    val increases = numberOfIncreasesRefinedSolution(readings)
    logger.info { "Number of increases refined solution: $increases" }

    val increasesSliding = numberOfIncreasesSlidingWindowOf3RefinedSolution(readings)
    logger.info { "Number of increases sliding window of 3 refined solution: $increasesSliding" }
}