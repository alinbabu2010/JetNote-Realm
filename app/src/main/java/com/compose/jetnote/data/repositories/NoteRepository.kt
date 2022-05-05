package com.compose.jetnote.data.repositories

import com.compose.jetnote.data.model.Note
import com.compose.jetnote.data.source.NoteDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {

    suspend fun addNote(note: Note) = noteDao.insert(note)

    suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)

    fun getAllNotes(): Flow<List<Note>> = noteDao.getNotes().flowOn(Dispatchers.IO)

}