package com.example.lec6demo

import com.squareup.moshi.JsonClass
import java.sql.Timestamp

@JsonClass(generateAdapter = true)
data class Note(
    val body: String,
    val id: Int = -1,
    val poster: String? = "",
    val title: String? = "",
    val timestamp: String? = ""
)