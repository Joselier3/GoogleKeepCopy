package com.example.keepcopy.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.keepcopy.database.FinalNote
import com.example.keepcopy.database.Note
import com.example.keepcopy.database.NoteDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class KeepCopyViewModel(private val noteDao: NoteDao) : ViewModel() {
    fun getAllNotes(): Flow<List<FinalNote>> = noteDao.allNotes()

    fun addNote(note: FinalNote) {
        viewModelScope.launch {
            val tagId = noteDao.getTagId(note.noteTag)
            val newNote: Note = Note(
                noteTitle = note.noteTitle,
                note = note.note,
                tagId = tagId,
                isPinned = note.isPinned
            )
            noteDao.insert(newNote)
        }
    }
}

class KeepCopyViewModelFactory(private val noteDao: NoteDao): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(KeepCopyViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return KeepCopyViewModel(noteDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}