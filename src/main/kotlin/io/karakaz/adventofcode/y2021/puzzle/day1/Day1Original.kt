package io.karakaz.adventofcode.y2021.puzzle.day1

import io.karakaz.adventofcode.y2021.util.readFileAsLines
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun numberOfIncreases(readings: List<Int>): Int {
    var increases = 0
    for (i in 1 until readings.size) {
        if (readings[i] > readings[i - 1]) {
            increases++
            logger.debug { "Is ${readings[i]} bigger than ${readings[i - 1]}? > yes" }
        } else {
            logger.debug { "Is ${readings[i]} bigger than ${readings[i - 1]}? > no" }
        }
    }
    return increases
}

fun numberOfIncreasesSlidingWindowOf3(readings: List<Int>): Int {
    var increases = 0
    for (i in 3 until readings.size) {
        val readingA = readings[i - 3] + readings[i - 2] + readings[i - 1]
        val readingB = readings[i - 2] + readings[i - 1] + readings[i - 0]
        if (readingB > readingA) {
            increases++
            logger.debug { "Is $readingB bigger than $readingA? > yes" }
        } else {
            logger.debug { "Is $readingB bigger than $readingA? > no" }
        }
    }
    return increases
}

fun main() {
    val readings = readFileAsLines("day1/readings.txt").map { it.toInt() }

    val increases = numberOfIncreases(readings)
    logger.info { "Number of increases: $increases" }

    val increasesSliding = numberOfIncreasesSlidingWindowOf3(readings)
    logger.info { "Number of increases sliding window of 3: $increasesSliding" }
}