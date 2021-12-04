package io.karakaz.adventofcode.y2021.challenge.day2

import io.karakaz.adventofcode.y2021.util.readFileAsLines
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

enum class Action(val perform: (Int, State) -> State) {
    forward({ strength: Int, state: State ->
        state.copy(
            x = state.x + strength,
            y = state.y + state.aim * strength
        )
    }),
    down({ strength: Int, state: State -> state.copy(aim = state.aim + strength) }),
    up({ strength: Int, state: State -> state.copy(aim = state.aim - strength) })
}

data class State(
    val x: Int = 0,
    val y: Int = 0,
    val aim: Int = 0
)

fun pilot(commands: List<String>): Int {
    val resultState = commands.fold(State()) { state, commandAndStrength ->
        logger.debug { "$state, command: $commandAndStrength" }
        val (command, strength) = commandAndStrength.split(" ")
        Action.valueOf(command).perform(strength.toInt(), state)
    }
    logger.debug { "$resultState" }
    return resultState.x * resultState.y
}

fun main() {
    val commands = readFileAsLines("day2/commands.txt")
    val result = pilot(commands)
    logger.info { "Result after piloting: $result" }
}
