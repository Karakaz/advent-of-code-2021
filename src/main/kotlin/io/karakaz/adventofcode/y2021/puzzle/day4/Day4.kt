package io.karakaz.adventofcode.y2021.puzzle.day4

import io.karakaz.adventofcode.y2021.util.readFileAsLines
import mu.KotlinLogging
import kotlin.math.sqrt
import kotlin.properties.Delegates

private val logger = KotlinLogging.logger {}

class Board(numberSequence: List<Int>) {

    private val slots: List<Slot>
    private val rows: List<Line>
    private val columns: List<Line>

    var hasWon = false
    var score by Delegates.notNull<Int>()
    var winningNumber by Delegates.notNull<Int>()

    init {
        slots = numberSequence.map { Slot(it) }
        val boardSize = sqrt(slots.size.toDouble()).toInt()
        val chunks = slots.chunked(boardSize)
        rows = chunks.map { chunk -> Line(chunk.map { it }) }
        val columnsWithNumbers = (1..boardSize).map { mutableListOf<Slot>() }
        for (x in 0 until boardSize) {
            for (y in 0 until boardSize) {
                columnsWithNumbers[x].add(rows[y][x])
            }
        }
        columns = columnsWithNumbers.map { chunk -> Line(chunk.map { it }) }
        logBoard()
    }

    fun markNumber(number: Int): Boolean {
        if (hasWon) return false
        slots.find { it.number == number }?.marked = true
        if (rows.any { it.isComplete() } || columns.any { it.isComplete() }) {
            winningNumber = number
            score = calculateScore()
            hasWon = true
        }
        return hasWon
    }

    private fun calculateScore(): Int {
        val sumUnmarked = slots.filter { !it.marked }.sumOf { it.number }
        return sumUnmarked * winningNumber
    }

    fun logBoard() {
        logger.debug { "Rows:" }
        rows.forEach { logger.debug { it } }
    }
}

data class Line(private val slots: List<Slot>) {

    operator fun get(index: Int): Slot = slots[index]

    fun isComplete(): Boolean {
        return slots.all { it.marked }
    }
}

data class Slot(val number: Int) {
    var marked = false

    override fun toString(): String {
        return "Slot(${String.format("%2s", number)}, ${if (marked) "X" else " "})"
    }
}

fun createBoardFromLines(lines: List<String>): Board {
    val numberSequence = lines.flatMap { it.split(" ") }
        .filter { it.isNotBlank() }
        .map { it.toInt() }
    return Board(numberSequence)
}

fun createBoardsFromLines(lines: List<String>): List<Board> {
    val boards = mutableListOf<Board>()
    for (i in lines.indices) {
        if (lines[i].isEmpty() && i + 1 < lines.size) {
            val boardLines = (i + 1..i + 5).map { lines[it] }
            boardLines.forEach { logger.debug { it } }
            boards.add(createBoardFromLines(boardLines))
        }
    }
    return boards.toList()
}

fun calculateScoreOfWinningBoard(input: List<String>): Int {
    val drawnNumbers = input.first().split(",").map { it.toInt() }
    val boards = createBoardsFromLines(input.subList(1, input.size))
    val winningBoard = drawnNumbers.firstNotNullOf { drawnNumber -> boards.find { it.markNumber(drawnNumber) } }
    logger.debug { "Winning board:" }
    winningBoard.logBoard()
    return winningBoard.score
}

fun calculateScoreOfLosingBoard(input: List<String>): Int {
    val drawnNumbers = input.first().split(",").map { it.toInt() }
    val boards = createBoardsFromLines(input.subList(1, input.size))
    drawnNumbers.forEach { drawnNumber -> boards.forEach { it.markNumber(drawnNumber) } }
    val losingBoard = drawnNumbers.reversed().firstNotNullOf { number -> boards.find { it.winningNumber == number } }
    return losingBoard.score
}

fun main() {
    val input = readFileAsLines("day4/bingo.txt", skipEmptyLines = false)
    val scoreWinningBoard = calculateScoreOfWinningBoard(input)
    val scoreLosingBoard = calculateScoreOfLosingBoard((input))
    logger.info { "Score of winning board: $scoreWinningBoard" }
    logger.info { "Score of losing board: $scoreLosingBoard" }
}
