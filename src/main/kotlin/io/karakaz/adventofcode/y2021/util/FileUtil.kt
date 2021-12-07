package io.karakaz.adventofcode.y2021.util

fun readFileAsString(path: String) = ClassLoader.getSystemResource(path).readText()

fun readFileAsLines(path: String, skipEmptyLines: Boolean = true): List<String> {
    val lines = ClassLoader.getSystemResource((path))
        .readText()
        .split("\\r?\\n".toRegex())
    return if (skipEmptyLines) lines.filter(String::isNotEmpty) else lines
}