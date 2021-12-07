package io.karakaz.adventofcode.y2021.puzzle.day4

import io.karakaz.adventofcode.y2021.util.readFileAsLines
import mu.KotlinLogging
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private val logger = KotlinLogging.logger {}

internal class Day4KtTest {

    @Test
    fun calculateScoreOfWinningBoardTest() {
        val input = readFileAsLines("day4/bingo-trial.txt", skipEmptyLines = false)
        val score = calculateScoreOfWinningBoard(input)
        logger.info { "Score: $score" }
        assertEquals(4512, score)
    }

    @Test
    internal fun calculateScoreOfLosingBoardTest() {
        val input = readFileAsLines("day4/bingo-trial.txt", skipEmptyLines = false)
        val score = calculateScoreOfLosingBoard(input)
        logger.info { "Score: $score" }
        assertEquals(1924, score)
    }
}