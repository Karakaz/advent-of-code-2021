package io.karakaz.adventofcode.y2021.puzzle.day4

import io.karakaz.adventofcode.y2021.util.readFileAsLines
import mu.KotlinLogging
import kotlin.math.sqrt

private val logger = KotlinLogging.logger {}

data class BingoBoard(private val slots: List<BingoSlot>) {

    private val boardSize = sqrt(slots.size.toDouble()).toInt()

    fun calculateScoreWithWinningRound(drawnSequence: List<Int>): Pair<Int, Int> {
        return drawnSequence.indices.firstNotNullOf { i ->
            markNumberReturnScore(drawnSequence[i])?.let { it to i }
        }
    }

    private fun markNumberReturnScore(drawnNumber: Int): Int? {
        slots.find { it.number == drawnNumber }?.marked = true
        return if (checkHasWon()) {
            logBoard()
            calculateScore(drawnNumber)
        } else null
    }

    private fun checkHasWon(): Boolean {
        val wonOnRows = slots.windowed(boardSize, boardSize).any { line -> line.all { it.marked } }
        val wonOnColumns = (0 until boardSize).any { i ->
            (i until slots.size step boardSize).map { slots[it] }.all { it.marked }
        }
        return wonOnRows || wonOnColumns
    }

    private fun calculateScore(winningNumber: Int): Int {
        val sumUnmarked = slots.filter { !it.marked }.sumOf { it.number }
        return sumUnmarked * winningNumber
    }

    private fun logBoard(header: String = "BingoBoard:") {
        logger.debug { header }
        slots.windowed(boardSize, boardSize).forEach {
            logger.debug { it.joinToString() }
        }
    }
}

data class BingoSlot(val number: Int) {
    var marked = false
    override fun toString(): String {
        return "(${String.format("%2s", number)}, ${if (marked) "X" else " "})"
    }
}

private fun createBingoBoardFromLines(lines: List<String>): BingoBoard {
    val numberSequence = lines.flatMap { it.split(" ") }
        .filter { it.isNotBlank() }
        .map { it.toInt() }
        .map { BingoSlot(it) }
    return BingoBoard(numberSequence)
}

private fun readInputCreateDrawnSequenceAndBingoBoards(lines: List<String>): Pair<List<Int>, List<BingoBoard>> {
    val drawnSequence = lines[0].split(",").map { it.toInt() }
    val boardSize = lines[1].split(" ").count { it.isNotBlank() }
    val bingoBoards = lines.subList(1, lines.size)
        .windowed(boardSize, boardSize)
        .map { createBingoBoardFromLines(it) }
    return drawnSequence to bingoBoards
}

fun calculateScoreOfWinningAndLosingBoards(lines: List<String>): Pair<Int, Int> {
    val (drawnSequence, boards) = readInputCreateDrawnSequenceAndBingoBoards(lines)
    val scoreAndWinningRoundList = boards.map { it.calculateScoreWithWinningRound(drawnSequence) }
    val winningScore = scoreAndWinningRoundList.minByOrNull { it.second }!!.first
    val losingScore = scoreAndWinningRoundList.maxByOrNull { it.second }!!.first
    return winningScore to losingScore
}

fun main() {
    val input = readFileAsLines("day4/bingo.txt")
    val (winningScore, losingScore) = calculateScoreOfWinningAndLosingBoards(input)
    logger.info { "Score of winning board: $winningScore" }
    logger.info { "Score of losing board: $losingScore" }
}
