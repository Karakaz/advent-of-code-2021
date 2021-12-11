package io.karakaz.adventofcode.y2021.puzzle.day6

import io.karakaz.adventofcode.y2021.util.readFileAsLines
import mu.KotlinLogging
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

private val logger = KotlinLogging.logger {}

internal class Day6Test {

    @Test
    fun computeLanternfish18DaysTrial() {
        val daysToReproduction = readTrialFileIntoLanternfishDaysToReproduction()
        logger.debug { daysToReproduction }
        val numberOfFish = computeLanternfish(daysToReproduction, 18)
        logger.info { "Number of lanternfish after 18 days: $numberOfFish" }
        assertEquals(26, numberOfFish)
    }

    @Test
    fun computeLanternfish80DaysTrial() {
        val daysToReproduction = readTrialFileIntoLanternfishDaysToReproduction()
        logger.debug { daysToReproduction }
        val numberOfFish = computeLanternfish(daysToReproduction, 80)
        logger.info { "Number of lanternfish after 80 days: $numberOfFish" }
        assertEquals(5934, numberOfFish)
    }

    @Test
    fun simulateLanternfishPopulation18DaysTrial() {
        val daysToReproduction = readTrialFileIntoLanternfishDaysToReproduction()
        logger.debug { daysToReproduction }
        val numberOfFish = simulateLanternfishPopulation(daysToReproduction, 18)
        logger.info { "Number of lanternfish after 18 days: $numberOfFish" }
        assertEquals(26, numberOfFish)
    }

    @Test
    fun simulateLanternfishPopulation80DaysTrial() {
        val daysToReproduction = readTrialFileIntoLanternfishDaysToReproduction()
        logger.debug { daysToReproduction }
        val numberOfFish = simulateLanternfishPopulation(daysToReproduction, 80)
        logger.info { "Number of lanternfish after 80 days: $numberOfFish" }
        assertEquals(5934, numberOfFish)
    }

    private fun readTrialFileIntoLanternfishDaysToReproduction(): List<Int> =
        readFileAsLines("day6/lanternfish-trail.txt")
            .first()
            .split(",")
            .map { it.toInt() }
}