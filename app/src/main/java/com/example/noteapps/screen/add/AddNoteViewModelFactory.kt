package com.example.noteapps.screen.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.noteapps.db.NoteData

class AddNoteViewModelFactory(private val noteData: NoteData?) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddNoteViewModel::class.java)) {
            return AddNoteViewModel(noteData) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }

}