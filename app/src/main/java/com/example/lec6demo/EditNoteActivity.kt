package com.example.lec6demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Request

class EditNoteActivity : AppCompatActivity() {
    private lateinit var taskEditBody: EditText
    private lateinit var taskEditTitle: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        taskEditBody = findViewById(R.id.editBody)
        taskEditTitle = findViewById(R.id.editTitle)
        saveButton = findViewById(R.id.saveLocalButton)

        val body = intent.extras?.getString("body")
        val id = intent.extras?.getInt("id")
        val poster = intent.extras?.getString("poster")
        val title = intent.extras?.getString("title")

        taskEditBody.setText(body!!)
        taskEditTitle.setText(title!!)
        saveButton.setOnClickListener {
            val editedNote = Note(taskEditBody.text.toString(), id!!, poster, taskEditTitle.text.toString())
            Repository.noteList.add(editedNote)

            val intent = Intent(this, CloudNotesActivity::class.java)
            startActivity(intent)
        }
    }
}

