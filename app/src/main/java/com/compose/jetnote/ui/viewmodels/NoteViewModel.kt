package com.compose.jetnote.ui.viewmodels

import android.util.Log
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

    //private var noteList = mutableStateListOf<Note>()
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        // noteList.addAll(NoteDataSource().loadNotes())
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.getAllNotes().distinctUntilChanged().collect { noteList ->
                if (noteList.isNullOrEmpty()) {
                    Log.d("TAG", "Empty List")
                } else {
                    _noteList.value = noteList
                }

            }
        }
    }

    /**
     * Method to add notes
     * @param note [Note] object to be added
     */
    fun addNote(note: Note) = viewModelScope.launch {
        noteRepository.addNote(note)
    }


    /**
     * Method to remove notes
     * @param note [Note] object to be removed
     */
    fun removeNote(note: Note) = viewModelScope.launch {
        noteRepository.deleteNote(note)
    }

    /**
     * Method to update notes
     * @param note [Note] object to be removed
     */
    fun updateNote(note: Note) = viewModelScope.launch {
        noteRepository.updateNote(note)
    }

}