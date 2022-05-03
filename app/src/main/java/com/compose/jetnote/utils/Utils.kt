package com.compose.jetnote.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private const val DATE_TIME_FORMAT = "EEE, d MMM"

fun validateInput(input: String): Boolean {
    return input.all { char -> char.isLetter() || char.isWhitespace() }
}

fun getFormattedDate(dateTime: LocalDateTime): String {
    return dateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))
}