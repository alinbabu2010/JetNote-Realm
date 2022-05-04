package com.compose.jetnote.data.source

import com.compose.jetnote.data.model.Note

class NoteDataSource {

    fun loadNotes(): List<Note> {
        return listOf(
            Note(title = "A good day", description = "We went on a vacation by the lake"),
            Note(title = "Android Compose", description = "Working on Android compose today"),
            Note(title = "Keep at it...", description = "Sometimes things just happen"),
            Note(title = "A movie day", description = "Watching a movie with family"),
            Note(title = "A movie day", description = "Watching a movie with family"),
            Note(title = "A movie day", description = "Watching a movie with family"),
            Note(title = "A movie day", description = "Watching a movie with family"),
            Note(title = "A movie day", description = "Watching a movie with family")
        )
    }

}