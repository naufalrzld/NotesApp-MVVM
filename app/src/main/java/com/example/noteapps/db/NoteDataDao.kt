package com.example.noteapps.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.noteapps.NoteData

@Dao
interface NoteDataDao {
    @Insert
    fun insert(note: NoteData)

    @Query("SELECT * FROM notes_table")
    fun getNotes(): List<NoteData>
}