package com.example.lec6demo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

const val BASE_URL = "http://143.198.115.54:8080/"

class CloudNotesActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NoteAdapter
    private lateinit var seeLocalNotesButton: Button
    private lateinit var cloudEditText: EditText
    private lateinit var cloudSaveButton: Button

    private val client = OkHttpClient()
    private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    private val noteJsonAdapter = moshi.adapter(Note::class.java)
    private val noteListType = Types.newParameterizedType(List::class.java, Note::class.java)
    private val noteListJsonAdapter : JsonAdapter<List<Note>> = moshi.adapter(noteListType)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seeLocalNotesButton = findViewById(R.id.seeLocalNotesButton)
        seeLocalNotesButton.setOnClickListener {
            val intent = Intent(this, LocalNoteActivity::class.java)
            startActivity(intent)
        }

        cloudEditText = findViewById(R.id.cloudEditText)
        cloudSaveButton = findViewById(R.id.cloudSaveButton)
        cloudSaveButton.setOnClickListener {
            runBlocking {
                withContext(Dispatchers.IO) {
                    // make networking request
                }
            }
        }

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        populateNotesList()
    }

    private fun populateNotesList() {
        // val requestGet
    }

    private fun updateNote(newNoteBody: String) {
        val newNote = Note("foo", -1, "bar")
        val requestPost = Request.Builder().url(BASE_URL + "posts/")
            .post(noteJsonAdapter.toJson(newNote).toRequestBody(("application/json; charset=utf-8").toMediaType())).build()
        client.newCall(requestPost).execute().use {
            if (!it.isSuccessful) {
                // handle unsuccessful response
            }
            val responseString = it.body!!.string()
        }
    }
}