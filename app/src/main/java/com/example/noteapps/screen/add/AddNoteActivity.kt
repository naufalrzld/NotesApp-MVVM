package com.example.noteapps.screen.add

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.noteapps.db.NoteData
import com.example.noteapps.R
import com.example.noteapps.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {
    private lateinit var addNoteViewModel: AddNoteViewModel
    private lateinit var viewModelFactory: AddNoteViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAddNoteBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_note)

        viewModelFactory = AddNoteViewModelFactory(intent.getParcelableExtra("note_data"))
        addNoteViewModel = ViewModelProvider(this, viewModelFactory).get(AddNoteViewModel::class.java)
        binding.viewModel = addNoteViewModel
        binding.lifecycleOwner = this

        binding.btnSave.setOnClickListener {
            val title = binding.etTitle.text.toString()
            val desc = binding.etNoteDesc.text.toString()

            val note = NoteData(
                noteTitle = title,
                noteDescription = desc
            )

            val intent = Intent().apply {
                putExtra("note_data", note)
            }

            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
