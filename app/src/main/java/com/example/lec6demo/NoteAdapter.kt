package com.example.lec6demo

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(private val notes: List<Note>) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val body: TextView = itemView.findViewById(R.id.body)
        val poster: TextView = itemView.findViewById(R.id.poster)
        val timestamp: TextView = itemView.findViewById(R.id.timestamp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.note_cell, parent, false) as View
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.title.text = note.title
        holder.body.text = note.body.substring(0, Math.min(note.body.length, 150))
        holder.poster.text = note.poster
        holder.timestamp.text = note.timestamp
        val context = holder.itemView.context
        holder.itemView.setOnClickListener {
            val noteIntent = Intent(context, EditNoteActivity::class.java).apply {
                putExtra("body", note.body)
                putExtra("id", note.id)
                putExtra("title", note.title)
                putExtra("poster", note.poster)
            }
            context.startActivity(noteIntent)
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}