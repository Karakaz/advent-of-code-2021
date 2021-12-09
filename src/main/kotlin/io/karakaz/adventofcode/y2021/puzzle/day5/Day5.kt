package io.karakaz.adventofcode.y2021.puzzle.day5

import io.karakaz.adventofcode.y2021.util.readFileAsLines
import mu.KotlinLogging
import kotlin.math.abs

private val logger = KotlinLogging.logger {}

class HydrothermalVentCoordinator(private val vectors: List<Vector>, scanDiameter: Int) {

    private val zones: List<List<Zone>> =
        (0 until scanDiameter).map { (0 until scanDiameter).map { Zone() } }

    fun markLines() {
        vectors.forEach { increaseLevelIfLine(it) }
    }

    fun markDiagonals() {
        vectors.forEach { increaseLevelIfDiagonal(it) }
    }

    private fun increaseLevelIfLine(vector: Vector) {
        val (x1, x2) = listOf(vector.x1, vector.x2).sorted()
        val (y1, y2) = listOf(vector.y1, vector.y2).sorted()
        if (x1 == x2) {
            for (y in y1..y2) {
                zones[y][x1].increaseLevel()
            }
        } else if (y1 == y2) {
            for (x in x1..x2) {
                zones[y1][x].increaseLevel()
            }
        }
    }

    private fun increaseLevelIfDiagonal(vector: Vector) {
        if (vector.x1 == vector.x2 && vector.y1 == vector.y2) return
        if (abs(vector.x1 - vector.x2) == abs(vector.y1 - vector.y2)) {
            (vector.x1 toward vector.x2).toList()
                .zip((vector.y1 toward vector.y2).toList())
                .forEach { (x, y) -> zones[y][x].increaseLevel() }
        }
    }

    fun calculateNumberOfDangerousZones(threshold: Int): Int {
        return zones.flatMap { list -> list.filter { it.level >= threshold } }.count()
    }

    fun logHydrothermalVentZones() {
        zones.forEach { logger.debug { it.joinToString("") } }
    }
}

data class Vector(
    val x1: Int,
    val y1: Int,
    val x2: Int,
    val y2: Int
) {
    override fun toString(): String {
        return "Vector($x1, $y1 -> $x2, $y2)"
    }
}

class Zone {
    var level: Int = 0

    fun increaseLevel() {
        level++
    }

    override fun toString(): String {
        return if (level == 0) "." else "$level"
    }
}

private infix fun Int.toward(other: Int) = IntProgression.fromClosedRange(this, other, if (this < other) 1 else -1)

fun readInputToVectors(input: List<String>): List<Vector> {
    return input.map { line ->
        val (posA, posB) = line.split(" -> ")
        val (x1, y1) = posA.split(",").map { it.toInt() }
        val (x2, y2) = posB.split(",").map { it.toInt() }
        Vector(x1, y1, x2, y2)
    }
}

fun main() {
    val vectors = readInputToVectors(readFileAsLines("day5/hydrothermal-vents.txt"))
    val hydrothermalVentCoordinator = HydrothermalVentCoordinator(vectors, 1000)
    hydrothermalVentCoordinator.markLines()
    hydrothermalVentCoordinator.markDiagonals()
    val numberOfDangerousZones = hydrothermalVentCoordinator.calculateNumberOfDangerousZones(2)
    logger.info { "Number of dangerous zones: $numberOfDangerousZones" }
}