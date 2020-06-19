package com.example.noteapps.db

import android.os.AsyncTask
import androidx.lifecycle.LiveData

class NoteRepository(private val noteDataDao: NoteDataDao) {
    private val notes: LiveData<List<NoteData>> = noteDataDao.getNotes()

    fun insert(note: NoteData) {
        InsertNoteAsyncTask(noteDataDao).execute(note)
    }

    fun getAllNotes(): LiveData<List<NoteData>> {
        return notes
    }

    private class InsertNoteAsyncTask(val noteDao: NoteDataDao) : AsyncTask<NoteData, Unit, Unit>() {

        override fun doInBackground(vararg note: NoteData?) {
            noteDao.insert(note[0]!!)
        }
    }
}