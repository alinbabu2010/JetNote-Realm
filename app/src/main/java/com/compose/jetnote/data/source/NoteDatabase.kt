package com.compose.jetnote.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.compose.jetnote.data.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

}