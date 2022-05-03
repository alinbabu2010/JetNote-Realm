package com.compose.jetnote.utils

fun validateInput(input: String): Boolean {
    return input.all { char -> char.isLetter() || char.isWhitespace() }
}