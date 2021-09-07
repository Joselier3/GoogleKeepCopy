package com.example.keepcopy.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.keepcopy.database.FinalNote
import com.example.keepcopy.database.NoteDao
import kotlinx.coroutines.flow.Flow

class KeepCopyViewModel(private val noteDao: NoteDao) : ViewModel() {
    fun getAllNotes(): Flow<List<FinalNote>> = noteDao.allNotes()
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