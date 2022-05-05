package com.compose.jetnote.data.db.dao

import com.compose.jetnote.data.db.entity.NoteEntity
import com.compose.jetnote.data.model.Note
import io.realm.Realm
import io.realm.kotlin.executeTransactionAwait
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class NoteDao @Inject constructor() {

    suspend fun insert(noteEntity: NoteEntity) {
        val realm = Realm.getDefaultInstance()
        realm.executeTransactionAwait(Dispatchers.IO) { transaction ->
            transaction.insert(noteEntity)
        }
    }

    suspend fun deleteNote(notes: Note) {
        val realm = Realm.getDefaultInstance()
        realm.executeTransactionAwait { transaction ->
            val note = transaction.where(NoteEntity::class.java)
                .equalTo("id", notes.id).findFirst()
            note?.deleteFromRealm()
        }
    }

    fun getNotes(): List<NoteEntity> {
        val notesList = mutableListOf<NoteEntity>()
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction { transaction ->
            notesList.addAll(
                transaction.where(NoteEntity::class.java).findAll()
            )
        }
        return notesList

    }

}
