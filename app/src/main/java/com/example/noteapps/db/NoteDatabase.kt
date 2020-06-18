package com.example.noteapps.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDataDao(): NoteDataDao

    companion object {
        @Volatile
        private var INSTANCE: NoteDatabase? = null
        fun getInstance(context: Context): NoteDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "notes_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}