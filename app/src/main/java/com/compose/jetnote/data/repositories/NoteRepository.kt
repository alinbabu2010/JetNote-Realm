package com.compose.jetnote.data.repositories

import com.compose.jetnote.data.db.dao.NoteDao
import com.compose.jetnote.data.db.entity.NoteEntity
import com.compose.jetnote.data.model.Note
import com.compose.jetnote.utils.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDao: NoteDao,
    private val dataToEntityMapper: Mapper<Note, NoteEntity>,
    private val entityToDataMapper: Mapper<NoteEntity, Note>
) {

    suspend fun addNote(note: Note) = noteDao.insert(dataToEntityMapper.map(note))

    suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)

    fun getAllNotes(): Flow<List<Note>> {
        val noteList = MutableStateFlow(mutableListOf<Note>())
        noteDao.getNotes().forEach {
            noteList.value.add(entityToDataMapper.map(it))
        }
        return noteList
    }

}