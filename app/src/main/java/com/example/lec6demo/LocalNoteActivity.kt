package com.example.lec6demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LocalNoteActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter : NoteAdapter
    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local_note)

        recyclerView = findViewById(R.id.recyclerView)
        adapter = NoteAdapter(Repository.noteList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            val intent = Intent(this, CloudNotesActivity::class.java)
            startActivity(intent)
        }
    }
}