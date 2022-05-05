package com.compose.jetnote.utils

import com.compose.jetnote.data.db.entity.NoteEntity
import com.compose.jetnote.data.model.Note
import javax.inject.Inject

class DataToEntityMapper @Inject constructor() : Mapper<Note, NoteEntity> {

    override fun map(data: Note): NoteEntity {
        return NoteEntity(data.id, data.title, data.description, data.entryDate.time)
    }

}