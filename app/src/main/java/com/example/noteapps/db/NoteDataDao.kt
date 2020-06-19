package com.example.noteapps.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDataDao {
    @Insert
    fun insert(note: NoteData)

    @Query("SELECT * FROM notes_table")
    fun getNotes(): LiveData<List<NoteData>>
}