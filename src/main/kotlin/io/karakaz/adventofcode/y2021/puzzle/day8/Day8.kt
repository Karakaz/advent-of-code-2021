package io.karakaz.adventofcode.y2021.puzzle.day8

import io.karakaz.adventofcode.y2021.util.readFileAsLines
import mu.KotlinLogging

private val SEGMENT_SIZE = mapOf(
    0 to 6,
    1 to 2,
    2 to 5,
    3 to 5,
    4 to 4,
    5 to 5,
    6 to 6,
    7 to 3,
    8 to 7,
    9 to 6
)

private val logger = KotlinLogging.logger {}

fun decodeSignals(rewiredDigits: List<Set<Char>>): Map<Set<Char>, Char> {
    val firstSegments = rewiredDigits.first { it.size == SEGMENT_SIZE[1] }
    val fourthSegments = rewiredDigits.first { it.size == SEGMENT_SIZE[4] }
    val seventhSegments = rewiredDigits.first { it.size == SEGMENT_SIZE[7] }
    val eightSegments = rewiredDigits.first { it.size == SEGMENT_SIZE[8] }

    val segmentsSize6 = rewiredDigits.filter { it.size == 6 }
    val sixthSegments = segmentsSize6.first { !it.containsAll(firstSegments) }
    val ninthSegments = segmentsSize6.first { it.containsAll(fourthSegments) }
    val zerothSegments = segmentsSize6.first { it != sixthSegments && it != ninthSegments }

    val thirdSegments = rewiredDigits.first { it.size == 5 && it.containsAll(firstSegments) }
    val segmentF = firstSegments.first { sixthSegments.contains(it) }
    val segmentsSize5NotThird = rewiredDigits.filter { it.size == 5 && it != thirdSegments}
    val fifthSegments = segmentsSize5NotThird.first { it.contains(segmentF) }
    val secondSegments = segmentsSize5NotThird.first { it != fifthSegments }
    return mapOf(
        zerothSegments to '0',
        firstSegments to '1',
        secondSegments to '2',
        thirdSegments to '3',
        fourthSegments to '4',
        fifthSegments to '5',
        sixthSegments to '6',
        seventhSegments to '7',
        eightSegments to '8',
        ninthSegments to '9'
    )
}

fun sumRewiredNumbers(rewiredDigits: List<Pair<List<Set<Char>>, List<Set<Char>>>>): Int =
    rewiredDigits.sumOf { pair ->
        val decodedSignals = decodeSignals(pair.first)
        pair.second.map { decodedSignals[it]!! }.joinToString("").toInt()
    }


fun countNumberOf1s4s7s8s(rewiredDigitNumbers: List<Set<Char>>): Int =
    rewiredDigitNumbers.count {
        it.size == SEGMENT_SIZE[1]
                || it.size == SEGMENT_SIZE[4]
                || it.size == SEGMENT_SIZE[7]
                || it.size == SEGMENT_SIZE[8]
    }

fun readInput(filepath: String): List<Pair<List<Set<Char>>, List<Set<Char>>>> {
    return readFileAsLines(filepath)
        .map { it.split(" | ").zipWithNext().first() }
        .map { pair ->
            pair.first.split(" ").map { it.toCharArray().toSet() } to
                    pair.second.split(" ").map { it.toCharArray().toSet() }
        }
}

fun main() {
    val rewiredDigits = readInput("day8/seven-segment-signal-pattern.txt")
    val resultCount = rewiredDigits.sumOf { countNumberOf1s4s7s8s(it.second) }
    val sumOfRewiredNumbers = sumRewiredNumbers(rewiredDigits)
    logger.info { "Number of 1s, 4s, 7s and 8s: $resultCount" }
    logger.info { "Sum of numbers: $sumOfRewiredNumbers" }
}