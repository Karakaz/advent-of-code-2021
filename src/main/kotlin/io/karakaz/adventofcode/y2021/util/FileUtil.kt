package io.karakaz.adventofcode.y2021.util

fun readFileAsString(path: String) = ClassLoader.getSystemResource(path).readText()

fun readFileAsLines(path: String, skipEmptyLines: Boolean = true) =
    ClassLoader.getSystemResource((path))
        .readText()
        .split("\\r?\\n".toRegex())
        .filter(String::isNotEmpty)