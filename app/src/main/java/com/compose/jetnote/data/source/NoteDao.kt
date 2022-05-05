package com.compose.jetnote.data.source

import androidx.room.*
import com.compose.jetnote.data.model.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes_tbl")
    fun getNotes(): List<Note>

    @Query("SELECT * FROM notes_tbl WHERE id=:id")
    fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(note: Note)

    @Query("DELETE  FROM notes_tbl")
    fun deleteAll()

    @Delete
    fun deleteNote(note: Note)

}
