package com.example.lec6demo

class Repository private constructor() {
    companion object {
        val noteList = mutableListOf<Note>()
    }
}