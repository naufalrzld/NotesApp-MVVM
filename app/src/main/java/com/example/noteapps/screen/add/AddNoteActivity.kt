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
import org.koin.android.ext.android.inject

class AddNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAddNoteBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_note)

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
