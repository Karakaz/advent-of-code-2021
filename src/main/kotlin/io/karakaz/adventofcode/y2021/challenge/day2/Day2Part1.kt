package io.karakaz.adventofcode.y2021.challenge.day2

import io.karakaz.adventofcode.y2021.util.readFileAsLines
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

data class Command(
    val type: CommandType,
    val strength: Int
)

enum class CommandType(val value: String, val execution: (Position, Int) -> Unit) {
    FORWARD("forward", { position: Position, strength: Int -> position.x += strength }),
    DOWN("down", { position: Position, strength: Int -> position.y += strength }),
    UP("up", { position: Position, strength: Int -> position.y -= strength });

    companion object {
        fun fromValue(value: String) = values().first { it.value == value }
    }
}

data class Position(
    var x: Int = 0,
    var y: Int = 0
)

fun pilot(commands: List<Command>): Int {
    val position = Position()
    commands.forEach { it.type.execution(position, it.strength) }
    logger.debug { "$position" }
    return position.x * position.y
}

fun commandsFromLines(lines: List<String>): List<Command> {
    return lines.map { it.split(" ") }
        .map { Command(CommandType.fromValue(it[0]), it[1].toInt()) }
}

fun main() {
    val commands = commandsFromLines(readFileAsLines("day2/commands.txt"))
    val result = pilot(commands)
    logger.info { "Result after piloting: $result" }
}