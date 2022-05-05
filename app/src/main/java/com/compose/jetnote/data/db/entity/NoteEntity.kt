package com.compose.jetnote.data.db.entity

import io.realm.RealmObject
import java.util.*

open class NoteEntity(
    var id: UUID = UUID.randomUUID(),
    var title: String = "",
    var description: String = "",
    var entryDate: Long = 0L
) : RealmObject()
