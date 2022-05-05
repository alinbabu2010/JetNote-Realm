package com.compose.jetnote.utils

interface Mapper<U, V> {
    fun map(data: U): V
}