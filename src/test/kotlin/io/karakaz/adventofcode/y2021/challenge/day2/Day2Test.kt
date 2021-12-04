package io.karakaz.adventofcode.y2021.challenge.day2

import io.karakaz.adventofcode.y2021.util.readFileAsLines
import mu.KotlinLogging
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private val logger = KotlinLogging.logger {}

internal class Day2Test {

    @Test
    internal fun `pilot trial part 1`() {
        val commands = commandsFromLines(readFileAsLines("day2/commands-trial.txt"))

        logger.debug { "$commands" }

        val result = pilot(commands)

        logger.info { "Result value after piloting: $result" }

        assertEquals(150, result)
    }

    @Test
    internal fun `pilot trial part 2`() {
        val lines = readFileAsLines("day2/commands-trial.txt")
        val result = pilot(lines)

        logger.info { "Result value after piloting: $result" }

        assertEquals(900, result)
    }
}