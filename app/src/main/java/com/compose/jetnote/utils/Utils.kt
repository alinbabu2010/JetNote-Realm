package com.compose.jetnote.utils

import java.text.SimpleDateFormat
import java.util.*

private const val DATE_TIME_FORMAT = "EEE, d MMM hh:mm aaa"

fun validateInput(input: String): Boolean {
    return input.all { char -> char.isLetter() || char.isWhitespace() }
}

fun getFormattedDate(time: Long): String {
    val date = Date(time)
    val formatter = SimpleDateFormat(DATE_TIME_FORMAT, Locale.getDefault())
    return formatter.format(date)
}