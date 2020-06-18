package com.example.noteapps

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val noteRepository: NoteRepository) : ViewModel() {
    val empty = MutableLiveData<Boolean>().apply { value = true }
    val notesLive = MutableLiveData<List<NoteData>>()

    fun fetchRepo() {
        val notes = noteRepository.notes
        empty.value = notes.isEmpty()
    }

    fun insert(note: NoteData) {
        noteRepository.insert(note)
    }
}