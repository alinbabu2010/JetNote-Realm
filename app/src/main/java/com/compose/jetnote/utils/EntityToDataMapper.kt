package com.compose.jetnote.utils

import com.compose.jetnote.data.db.entity.NoteEntity
import com.compose.jetnote.data.model.Note
import java.util.*
import javax.inject.Inject

class EntityToDataMapper @Inject constructor() : Mapper<NoteEntity, Note> {

    override fun map(data: NoteEntity): Note {
        return Note(data.id, data.title, data.description, convertDate(data.entryDate))
    }

    private fun convertDate(timestamp: Long) = Date(timestamp)

}