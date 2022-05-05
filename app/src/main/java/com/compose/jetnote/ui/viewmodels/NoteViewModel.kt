package com.compose.jetnote.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.jetnote.data.model.Note
import com.compose.jetnote.data.repositories.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val noteRepository: NoteRepository) : ViewModel() {

    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        getNotes()
    }

    /**
     * Method to add notes
     * @param note [Note] object to be added
     */
    fun addNote(note: Note) = viewModelScope.launch {
        noteRepository.addNote(note)
    }.invokeOnCompletion { getNotes() }


    /**
     * Method to remove notes
     * @param note [Note] object to be removed
     */
    fun removeNote(note: Note) = viewModelScope.launch {
        noteRepository.deleteNote(note)
    }.invokeOnCompletion { getNotes() }

    /**
     * Method to get all notes
     */
    private fun getNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.getAllNotes().distinctUntilChanged().collect { noteList ->
                _noteList.value = noteList.toMutableList()
            }
        }
    }

}