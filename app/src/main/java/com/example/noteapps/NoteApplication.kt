package com.example.noteapps

import android.app.Application
import com.example.noteapps.di.dbModule
import com.example.noteapps.di.repositoryModule
import com.example.noteapps.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NoteApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NoteApplication)
            modules(listOf(dbModule, repositoryModule, uiModule))
        }
    }
}