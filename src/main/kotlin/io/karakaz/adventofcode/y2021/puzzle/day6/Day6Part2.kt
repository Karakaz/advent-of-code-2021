package io.karakaz.adventofcode.y2021.puzzle.day6

import io.karakaz.adventofcode.y2021.util.readFileAsLines
import mu.KotlinLogging

private const val DAYS_FOR_NEW_FISH_TO_REPRODUCE = 8
private const val DAYS_FOR_OLD_FISH_TO_REPRODUCE = 6
private const val DAY_OF_REPRODUCTION = 0

private val logger = KotlinLogging.logger {}

class LanternfishPopulation(private var population: LongArray) {

    fun simulatePopulation(numberOfDaysToSimulate: Int): Long {
        (1..numberOfDaysToSimulate).forEach { _ -> passDay() }
        return population.sum()
    }

    private fun passDay() {
        val newPopulation = LongArray(DAYS_FOR_NEW_FISH_TO_REPRODUCE + 1)
        newPopulation[DAYS_FOR_NEW_FISH_TO_REPRODUCE] = population[DAY_OF_REPRODUCTION]
        newPopulation[DAYS_FOR_OLD_FISH_TO_REPRODUCE] = population[DAY_OF_REPRODUCTION]
        for (i in DAY_OF_REPRODUCTION + 1..DAYS_FOR_NEW_FISH_TO_REPRODUCE) {
            newPopulation[i - 1] += population[i]
        }
        population = newPopulation
    }
}

fun simulateLanternfishPopulation(daysUntilNewBirth: List<Int>, numberOfDaysToSimulate: Int): Long {
    val population = LongArray(DAYS_FOR_NEW_FISH_TO_REPRODUCE + 1)
    daysUntilNewBirth.forEach { population[it]++ }
    return LanternfishPopulation(population).simulatePopulation(numberOfDaysToSimulate)
}

fun main() {
    val daysToReproduction = readFileAsLines("day6/lanternfish.txt")
        .first()
        .split(",")
        .map { it.toInt() }
    val numberOfFish = simulateLanternfishPopulation(daysToReproduction, 256)
    logger.info { "Number of lanternfish after 80 days: $numberOfFish" }
}
