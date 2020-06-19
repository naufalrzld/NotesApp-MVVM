package com.example.noteapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapps.db.NoteData
import com.example.noteapps.databinding.NoteItemListBinding

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    private var notes: List<NoteData> = emptyList()

    fun setNotes(notes: List<NoteData>) {
        this.notes = notes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            NoteItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    class ViewHolder(val binding: NoteItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(note: NoteData) {
            binding.noteData = note
        }
    }
}