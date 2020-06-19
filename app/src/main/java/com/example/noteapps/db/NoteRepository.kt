package com.example.noteapps.db

import android.os.AsyncTask

class NoteRepository(private val noteDataDao: NoteDataDao) {
    private val notes: List<NoteData> = noteDataDao.getNotes()

    fun insert(note: NoteData) {
        InsertNoteAsyncTask(noteDataDao).execute(note)
    }

    fun getAllNotes(): List<NoteData> {
        return notes
    }

    private class InsertNoteAsyncTask(val noteDao: NoteDataDao) : AsyncTask<NoteData, Unit, Unit>() {

        override fun doInBackground(vararg note: NoteData?) {
            noteDao.insert(note[0]!!)
        }
    }
}