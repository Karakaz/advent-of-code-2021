package io.karakaz.adventofcode.y2021.puzzle.day6

import io.karakaz.adventofcode.y2021.util.readFileAsLines
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

class Population(private val lanternfish: MutableList<Lanternfish>) {

    fun simulateLanternfishPopulation(days: Int): Int {
        (1..days).forEach { _ ->
            val population = lanternfish.toList()
            population.forEach { fish ->
                fish.dayHavePassed()?.let { lanternfish.add(it) }
            }
        }
        return lanternfish.size
    }

}

data class Lanternfish(var daysToNewBirth: Int = 8) {

    fun dayHavePassed(): Lanternfish? {
        return if (daysToNewBirth-- == 0) {
            daysToNewBirth = 6
            Lanternfish()
        } else null
    }

    override fun toString(): String {
        return "$daysToNewBirth"
    }
}

fun computeLanternfish(daysUntilNewBirth: List<Int>, numberOfDaysToSimulate: Int): Int {
    return Population(daysUntilNewBirth.map { Lanternfish(it) }.toMutableList())
        .simulateLanternfishPopulation(numberOfDaysToSimulate)
}

fun main() {
    val daysToReproduction = readFileAsLines("day6/lanternfish.txt")
        .first()
        .split(",")
        .map { it.toInt() }
    val numberOfFish = computeLanternfish(daysToReproduction, 80)
    logger.info { "Number of lanternfish after 80 days: $numberOfFish" }
}