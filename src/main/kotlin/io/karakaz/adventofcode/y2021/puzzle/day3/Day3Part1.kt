package io.karakaz.adventofcode.y2021.puzzle.day3

import io.karakaz.adventofcode.y2021.util.readFileAsLines
import mu.KotlinLogging
import kotlin.math.pow

private val logger = KotlinLogging.logger {}

class BitsCounter(numberOfBits: Int) {

    val puzzleMask = twoToThePowerOf(numberOfBits) - 1
    private val counters =
        (0 until numberOfBits)
            .map { twoToThePowerOf(it) }
            .associateWith { 0 }
            .toMutableMap()

    fun count(int: Int) {
        counters.forEach { (mask, count) ->
            if (int.and(mask) > 0) counters[mask] = count + 1
        }
        logger.debug { "Counters: $counters" }
    }

    fun mostCommonBits(halfSize: Int) =
        counters.entries.fold(puzzleMask) { int, count ->
            int.and(if (count.value > halfSize) puzzleMask else (puzzleMask - count.key))
        }
}

fun twoToThePowerOf(number: Int) = (2).toDouble().pow(number).toInt()

fun calculatePowerConsumption(ints: List<Int>, numberOfBits: Int): Int {
    val bitsCounter = BitsCounter(numberOfBits)
    logger.debug { "puzzleMask: ${bitsCounter.puzzleMask} (${bitsCounter.puzzleMask.toString(2)})" }

    ints.forEach { bitsCounter.count(it) }
    val mostCommon = bitsCounter.mostCommonBits(ints.size / 2)
    val leastCommon = bitsCounter.puzzleMask - mostCommon

    logger.debug {
        "mostCommon: $mostCommon (${mostCommon.toString(2)}), leastCommon: $leastCommon (${leastCommon.toString(2)})"
    }
    return mostCommon * leastCommon
}

fun main() {
    val lines = readFileAsLines("day3/diagnostic-report.txt")
    val ints = lines.map { it.toInt(2) }
    val powerConsumption = calculatePowerConsumption(ints, lines.maxOf { it.length })
    logger.info { "Power consumption: $powerConsumption" }
}