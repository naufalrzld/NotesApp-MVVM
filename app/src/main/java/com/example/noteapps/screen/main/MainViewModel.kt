package com.example.noteapps.screen.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.noteapps.db.NoteData
import com.example.noteapps.db.NoteRepository

class MainViewModel(private val noteRepository: NoteRepository) : ViewModel() {
    private val _empty = MutableLiveData<Boolean>().apply { value = true }
    val empty: LiveData<Boolean>
        get() = _empty

    var notesLive: LiveData<List<NoteData>> = noteRepository.getAllNotes()

    private val _eventAdd = MutableLiveData<Boolean>()
    val eventAdd: LiveData<Boolean>
        get() = _eventAdd

    init {
        checkEmpty()
    }

    private fun checkEmpty() {
        _empty.value = (notesLive.value)?.isEmpty()
    }

    fun onEventAdd() {
        _eventAdd.value = true
    }

    fun onEventAddFinish() {
        _eventAdd.value = false
    }

    fun insert(note: NoteData) {
        noteRepository.insert(note)
    }
}