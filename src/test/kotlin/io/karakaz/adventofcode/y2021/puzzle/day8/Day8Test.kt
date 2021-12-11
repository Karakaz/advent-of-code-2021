package io.karakaz.adventofcode.y2021.puzzle.day8

import mu.KotlinLogging
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

private val logger = KotlinLogging.logger {}

internal class Day8Test {

    @Test
    fun countNumberOf1s4s7s8sTest() {
        val rewiredDigits = readInput("day8/seven-segment-signal-pattern-trial.txt")
        val result = rewiredDigits.sumOf { countNumberOf1s4s7s8s(it.second) }
        logger.info { "Number of 1s, 4s, 7s and 8s: $result" }
        assertEquals(26, result)
    }

    @Test
    internal fun sumRewiredNumbersOneLineTest() {
        val rewiredDigits = readInput("day8/seven-segment-signal-pattern-trial-one-line.txt")
        val result = sumRewiredNumbers(rewiredDigits)
        logger.info { "Sum of all digits: $result" }
        assertEquals(5353, result)
    }

    @Test
    internal fun sumRewiredNumbersTest() {
        val rewiredDigits = readInput("day8/seven-segment-signal-pattern-trial.txt")
        val result = sumRewiredNumbers(rewiredDigits)
        logger.info { "Sum of all digits: $result" }
        assertEquals(61229, result)
    }
}