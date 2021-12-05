package io.karakaz.adventofcode.y2021.puzzle.day3

import io.karakaz.adventofcode.y2021.util.readFileAsLines
import mu.KotlinLogging
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private val logger = KotlinLogging.logger {}


internal class Day3Test {

    @Test
    fun calculatePowerConsumptionTest() {
        val lines = readFileAsLines("day3/diagnostic-report-trail.txt")
        val numberOfBits = lines.maxOf { it.length }

        val ints = lines.map { it.toInt(2) }
        ints.forEach { logger.debug { "$it (${it.toString(2)})" } }

        val powerConsumption = calculatePowerConsumption(ints, numberOfBits)

        logger.info { "Power consumption: $powerConsumption" }
        assertEquals(198, powerConsumption)
    }

    @Test
    internal fun calculateLifeSupportRatingTest() {
        val lines = readFileAsLines("day3/diagnostic-report-trail.txt")
        val numberOfBits = lines.maxOf { it.length }
        val ints = lines.map { it.toInt(2) }

        val lifeSupportRating = calculateLifeSupportRating(ints, numberOfBits)
        logger.info { "Life support rating: $lifeSupportRating" }
        assertEquals(230, lifeSupportRating)
    }
}