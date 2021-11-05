package com.example.lec6demo

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(private val notes: List<Note>) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.note_cell, parent, false) as View
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.textView.text = note.body
        val context = holder.itemView.context
        holder.itemView.setOnClickListener {
            val noteIntent = Intent(context, EditNoteActivity::class.java).apply {
                putExtra("body", note.body)
                putExtra("id", note.id)
            }
            context.startActivity(noteIntent)
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}