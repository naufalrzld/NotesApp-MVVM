package com.example.noteapps

import com.example.noteapps.db.NoteDataDao

class NoteRepository(private val noteDataDao: NoteDataDao) {
    val notes = noteDataDao.getNotes()

    fun insert(note: NoteData) {
        noteDataDao.insert(note)
    }
}