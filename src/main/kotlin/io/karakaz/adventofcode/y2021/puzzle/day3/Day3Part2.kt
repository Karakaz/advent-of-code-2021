package io.karakaz.adventofcode.y2021.puzzle.day3

import io.karakaz.adventofcode.y2021.util.readFileAsLines
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

class BitsFilterer(numberOfBits: Int) {

    private val masks =
        (0 until numberOfBits)
            .map { twoToThePowerOf(it) }

    fun filterBits(ints: List<Int>, index: Int, comparator: (Int, Int) -> Boolean): List<Int> {
        val (truePartition, falsePartition) = ints.partition { it.and(masks[index]) > 0 }
        return when (comparator(truePartition.size, falsePartition.size)) {
            true -> truePartition
            false -> falsePartition
        }
    }
}

fun calculateRating(
    bitsFilterer: BitsFilterer,
    ints: List<Int>,
    numberOfBits: Int,
    comparator: (Int, Int) -> Boolean
): Int {
    var list = ints
    for (i in numberOfBits - 1 downTo 0) {
        list = bitsFilterer.filterBits(list, i, comparator)
        if (list.size == 1) break
    }
    logger.debug { "calculateRating list: $list" }
    return list.first()
}

fun calculateLifeSupportRating(ints: List<Int>, numberOfBits: Int): Int {
    val bitsFilterer = BitsFilterer(numberOfBits)
    val oxygenGeneratorRating = calculateRating(bitsFilterer, ints, numberOfBits) { a, b -> a >= b }
    val co2ScrubberRating = calculateRating(bitsFilterer, ints, numberOfBits) { a, b -> a < b }
    return oxygenGeneratorRating * co2ScrubberRating
}

fun main() {
    val lines = readFileAsLines("day3/diagnostic-report.txt")
    val numberOfBits = lines.maxOf { it.length }
    val ints = lines.map { it.toInt(2) }

    val lifeSupportRating = calculateLifeSupportRating(ints, numberOfBits)
    logger.info { "Life support rating: $lifeSupportRating" }
}
