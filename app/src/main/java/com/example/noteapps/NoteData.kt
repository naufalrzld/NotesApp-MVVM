package com.example.noteapps

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class NoteData(
    @PrimaryKey(autoGenerate = true)
    var noteID: Int,
    var noteTitle: String,
    var noteDescription: String,
    var noteDate: String
)