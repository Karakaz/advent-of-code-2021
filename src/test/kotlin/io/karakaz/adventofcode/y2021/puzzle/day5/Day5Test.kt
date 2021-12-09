package io.karakaz.adventofcode.y2021.puzzle.day5

import io.karakaz.adventofcode.y2021.util.readFileAsLines
import mu.KotlinLogging
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private val logger = KotlinLogging.logger {}

internal class Day5Test {

    @Test
    internal fun markLinesTest() {
        val vectors = readInputToVectors(readFileAsLines("day5/hydrothermal-vents-trial.txt"))
        vectors.forEach { logger.debug { "$it" } }
        val hydrothermalVentCoordinator = HydrothermalVentCoordinator(vectors, 10)
        hydrothermalVentCoordinator.markLines()
        hydrothermalVentCoordinator.logHydrothermalVentZones()
        val numberOfDangerousZones = hydrothermalVentCoordinator.calculateNumberOfDangerousZones(2)
        logger.info { "Number of dangerous zones: $numberOfDangerousZones" }
        assertEquals(5, numberOfDangerousZones)
    }

    @Test
    internal fun markLinesAndDiagonalsTest() {
        val vectors = readInputToVectors(readFileAsLines("day5/hydrothermal-vents-trial.txt"))
        vectors.forEach { logger.debug { "$it" } }
        val hydrothermalVentCoordinator = HydrothermalVentCoordinator(vectors, 10)
        hydrothermalVentCoordinator.markLines()
        hydrothermalVentCoordinator.markDiagonals()
        hydrothermalVentCoordinator.logHydrothermalVentZones()
        val numberOfDangerousZones = hydrothermalVentCoordinator.calculateNumberOfDangerousZones(2)
        logger.info { "Number of dangerous zones: $numberOfDangerousZones" }
        assertEquals(12, numberOfDangerousZones)
    }
}