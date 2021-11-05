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
    private lateinit var taskEditText: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        taskEditText = findViewById(R.id.editText)
        saveButton = findViewById(R.id.saveLocalButton)

        val body = intent.extras?.getString("body")
        val id = intent.extras?.getInt("id")

        taskEditText.setText(body!!)
        saveButton.setOnClickListener { }
    }
}

