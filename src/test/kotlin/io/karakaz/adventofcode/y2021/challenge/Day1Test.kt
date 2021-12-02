package io.karakaz.adventofcode.y2021.challenge

import io.karakaz.adventofcode.y2021.challenge.day1.numberOfIncreases
import io.karakaz.adventofcode.y2021.challenge.day1.numberOfIncreasesRefinedSolution
import io.karakaz.adventofcode.y2021.challenge.day1.numberOfIncreasesSlidingWindowOf3
import io.karakaz.adventofcode.y2021.challenge.day1.numberOfIncreasesSlidingWindowOf3RefinedSolution
import io.karakaz.adventofcode.y2021.util.readFileAsLines
import mu.KotlinLogging
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private val logger = KotlinLogging.logger {}

internal class Day1KtTest {

    @Test
    fun numberOfIncreasesTest() {
        val readings = readFileAsLines("day1/readings-trial.txt").map { it.toInt() }
        val increases = numberOfIncreases(readings)
        assertEquals(7, increases)
        logger.info { "Total number of increases: $increases" }
    }

    @Test
    fun numberOfIncreasesRefinedSolutionTest() {
        val readings = readFileAsLines("day1/readings-trial.txt").map { it.toInt() }
        val increases = numberOfIncreasesRefinedSolution(readings)
        assertEquals(7, increases)
        logger.info { "Total number of increases: $increases" }
    }

    @Test
    fun numberOfIncreasesSlidingWindowOf3Test() {
        val readings = readFileAsLines("day1/readings-trial.txt").map { it.toInt() }
        val increases = numberOfIncreasesSlidingWindowOf3(readings)
        assertEquals(5, increases)
        logger.info { "Total number of increases sliding window of 3: $increases" }
    }

    @Test
    fun numberOfIncreasesSlidingWindowOf3RefinedSolutionTest() {
        val readings = readFileAsLines("day1/readings-trial.txt").map { it.toInt() }
        val increases = numberOfIncreasesSlidingWindowOf3RefinedSolution(readings)
        assertEquals(5, increases)
        logger.info { "Total number of increases sliding window of 3: $increases" }
    }
}