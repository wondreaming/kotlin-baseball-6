package baseball.util

fun String.splitAndInt() = this.split("").filter { it.isNotEmpty() }.map { it.toInt() }