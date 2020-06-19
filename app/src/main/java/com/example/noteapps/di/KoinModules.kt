package com.example.noteapps.di

import com.example.noteapps.adapter.NoteAdapter
import com.example.noteapps.db.NoteDatabase
import com.example.noteapps.db.NoteRepository
import com.example.noteapps.screen.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dbModule = module {
    single { NoteDatabase.getInstance(androidContext()) }
    factory { get<NoteDatabase>().noteDataDao() }
}

val repositoryModule = module {
    single { NoteRepository(get()) }
}

val uiModule = module {
    factory { NoteAdapter() }
    viewModel { MainViewModel(get()) }
}