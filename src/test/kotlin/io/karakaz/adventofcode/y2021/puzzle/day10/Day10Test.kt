package io.karakaz.adventofcode.y2021.puzzle.day10

import mu.KotlinLogging
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private val logger = KotlinLogging.logger {}

internal class Day10Test {

    @Test
    internal fun calculateScoreOfCorruptedChunksTest() {
        val chunkSyntaxValidator = ChunkSyntaxValidator(readInputToChunkTokens("day10/navigation-subsystem-trial.txt"))
        val corruptedChunkTokens = chunkSyntaxValidator.corruptedChunkTokens()
        logger.debug { "corruptedChunkTokens: $corruptedChunkTokens" }
        val score = chunkSyntaxValidator.scoreCorruptedChunkTokens(corruptedChunkTokens)
        logger.info { "Score of corrupted chunks: $score" }
        assertEquals(26397, score)
    }

    @Test
    internal fun calculateScoreOfIncompleteChunkLinesTest() {
        val chunkSyntaxValidator = ChunkSyntaxValidator(readInputToChunkTokens("day10/navigation-subsystem-trial.txt"))
        val incompleteChunkLines = chunkSyntaxValidator.incompleteChunkLines()
        incompleteChunkLines.forEach { line ->
            logger.debug { "incomplete chunk tokens: ${line.map { it.matchingToken }}" }
        }
        val score = chunkSyntaxValidator.scoreIncompleteChunkLines(incompleteChunkLines)
        logger.info { "Score of incomplete chunk tokens: $score" }
        assertEquals(288957, score)
    }
}