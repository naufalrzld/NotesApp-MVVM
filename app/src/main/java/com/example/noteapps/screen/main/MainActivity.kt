package com.example.noteapps.screen.main

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapps.*
import com.example.noteapps.adapter.NoteAdapter
import com.example.noteapps.databinding.ActivityMainBinding
import com.example.noteapps.db.NoteData
import com.example.noteapps.db.NoteDatabase
import com.example.noteapps.db.NoteRepository
import com.example.noteapps.screen.add.AddNoteActivity
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private val mainViewModel: MainViewModel by inject()
    private val noteAdapter: NoteAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )

        mainBinding.viewmodel = mainViewModel
        mainBinding.lifecycleOwner = this

        mainBinding.rvList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = noteAdapter
        }

        mainViewModel.notesLive.observe(this, Observer {
            noteAdapter.setNotes(it)
        })

        mainViewModel.eventAdd.observe(this, Observer { hasAdd ->
            if (hasAdd) {
                val intent = Intent(this, AddNoteActivity::class.java)
                startActivityForResult(intent, 22)
                mainViewModel.onEventAddFinish()
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 22 && resultCode == Activity.RESULT_OK) {
            val note = data?.getParcelableExtra<NoteData>("note_data")

            note?.let { mainViewModel.insert(it) }
        }
    }
}
