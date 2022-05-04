package com.compose.jetnote.ui.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.compose.jetnote.data.model.Note
import com.compose.jetnote.data.source.NoteDataSource

class NoteViewModel : ViewModel() {

    private var noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NoteDataSource().loadNotes())
    }

    /**
     * Method to add notes
     * @param note [Note] object to be added
     */
    fun addNote(note: Note) {
        noteList.add(note)
    }

    /**
     * Method to remove notes
     * @param note [Note] object to be removed
     */
    fun removeNote(note: Note) {
        noteList.remove(note)
    }

    /**
     * Method to get all notes
     * @return List of [Note]
     */
    fun getAllNotes(): List<Note> = noteList

}