package io.karakaz.adventofcode.y2021.puzzle.day10

import io.karakaz.adventofcode.y2021.util.readFileAsLines
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

class ChunkSyntaxValidator(private val chunkTokenLines: List<List<ChunkToken>>) {

    fun scoreCorruptedChunkTokens(chunkTokens: List<ChunkToken>) = chunkTokens.sumOf { it.score }

    fun scoreIncompleteChunkLines(chunkLines: List<List<ChunkToken>>): Long =
        chunkLines.map { chunkTokens ->
            var score = 0L
            chunkTokens.forEach { score = score * 5 + it.score }
            score
        }.sorted()[(chunkLines.size - 1) / 2]

    fun corruptedChunkTokens() = chunkTokenLines.flatMap { corruptedChunkToken(it) }

    fun incompleteChunkLines() = chunkTokenLines.mapNotNull { incompleteChunkLine(it) }

    private fun corruptedChunkToken(chunkLine: List<ChunkToken>): List<ChunkToken> {
        val chunks = Chunks()
        val corruptedTokens = chunkLine.mapNotNull { chunks.registerChunkToken(it) }
        logger.trace { "Chunk line: $chunkLine, corrupted tokens: $corruptedTokens" }
        return corruptedTokens
    }

    private fun incompleteChunkLine(chunkLine: List<ChunkToken>): List<ChunkToken>? {
        val chunks = Chunks()
        return if (chunkLine.none { chunks.registerChunkToken(it) != null }) {
            chunks.completeWithClosingChunkTokens()
        } else null
    }

}

class Chunks {
    private val tokenStack = mutableListOf<ChunkToken>()

    fun registerChunkToken(chunkToken: ChunkToken): ChunkToken? {
        when (chunkToken.type) {
            ChunkTokenType.OPEN -> tokenStack.add(chunkToken)
            ChunkTokenType.CLOSE -> {
                val lastChunkToken = tokenStack.removeLastOrNull()
                lastChunkToken?.let {
                    if (it.matchingToken != chunkToken.token) return chunkToken
                } ?: return chunkToken
            }
        }
        return null
    }

    fun completeWithClosingChunkTokens(): List<ChunkToken> =
        (tokenStack.indices).map { tokenStack.removeLast() }

}

enum class ChunkTokenType { OPEN, CLOSE }

enum class ChunkToken(
    val token: Char,
    val matchingToken: Char,
    val type: ChunkTokenType,
    val score: Int
) {
    PARENTHESIS_OPEN('(', ')', ChunkTokenType.OPEN, 1),
    BRACKET_OPEN('[', ']', ChunkTokenType.OPEN, 2),
    CURLY_OPEN('{', '}', ChunkTokenType.OPEN, 3),
    ANGLE_OPEN('<', '>', ChunkTokenType.OPEN, 4),
    PARENTHESIS_CLOSE(')', '(', ChunkTokenType.CLOSE, 3),
    BRACKET_CLOSE(']', '[', ChunkTokenType.CLOSE, 57),
    ANGLE_CLOSE('>', '<', ChunkTokenType.CLOSE, 25137),
    CURLY_CLOSE('}', '{', ChunkTokenType.CLOSE, 1197),
}

private fun Char.toChunkToken() = ChunkToken.values().first { it.token == this }

fun readInputToChunkTokens(filepath: String): List<List<ChunkToken>> =
    readFileAsLines(filepath).map { line -> line.map { it.toChunkToken() } }

fun main() {
    val chunkSyntaxValidator = ChunkSyntaxValidator(readInputToChunkTokens("day10/navigation-subsystem.txt"))

    val corruptedChunkTokens = chunkSyntaxValidator.corruptedChunkTokens()
    val scoreCorruptedChunkTokens = chunkSyntaxValidator.scoreCorruptedChunkTokens(corruptedChunkTokens)

    val incompleteChunkLines = chunkSyntaxValidator.incompleteChunkLines()
    val middleScoreIncompleteChunkLine = chunkSyntaxValidator.scoreIncompleteChunkLines(incompleteChunkLines)
    logger.info { "Score of corrupted chunks: $scoreCorruptedChunkTokens" }
    logger.info { "Score of middle incomplete chunk line: $middleScoreIncompleteChunkLine" }
}