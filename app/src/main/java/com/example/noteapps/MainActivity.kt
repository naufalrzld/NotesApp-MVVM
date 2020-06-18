package com.example.noteapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.noteapps.adapter.NoteAdapter
import com.example.noteapps.databinding.ActivityMainBinding
import com.example.noteapps.db.NoteDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = NoteDatabase.getInstance(this).noteDataDao()
        val repository = NoteRepository(dao)
        val factory = MainViewModelFactory(repository)
        mainViewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        mainBinding.viewmodel = mainViewModel
        mainBinding.viewmodel?.fetchRepo()
        mainBinding.lifecycleOwner = this

        noteAdapter = NoteAdapter()

        mainBinding.rvList.apply {
            setHasFixedSize(true)
            adapter = noteAdapter
        }

        mainViewModel.notesLive.observe(this, Observer {
            mainViewModel.empty.value = it.isEmpty()
            noteAdapter.setNotes(it)
        })

        mainBinding.fabAdd.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }
    }
}
