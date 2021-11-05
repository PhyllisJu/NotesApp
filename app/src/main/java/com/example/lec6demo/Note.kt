package com.example.lec6demo

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Note(
    val body: String,
    val id: Int = -1,
    val poster: String? = "",
    val title: String? = ""
)