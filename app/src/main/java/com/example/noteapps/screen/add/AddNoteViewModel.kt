package com.example.noteapps.screen.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.noteapps.db.NoteData

class AddNoteViewModel(private val noteData: NoteData?) : ViewModel() {
    private val _fromAdd = MutableLiveData<Boolean>()
    val fromAdd: LiveData<Boolean>
        get() = _fromAdd

    private val _noteTitle = MutableLiveData<String>()
    val noteTitle: LiveData<String>
        get() = _noteTitle

    private val _noteDesc = MutableLiveData<String>()
    val noteDesc: LiveData<String>
        get() = _noteDesc

    private val _note = MutableLiveData<NoteData>()
    val note: LiveData<NoteData>
        get() = _note

    init {
        if (noteData == null) onFromAdd()
        else onFromEdit()
    }

    private fun onFromAdd() {
        _fromAdd.value = true
    }

    private fun onFromEdit() {
        _fromAdd.value = false
        _noteTitle.value = noteData?.noteTitle
        _noteDesc.value = noteData?.noteDescription
    }
}