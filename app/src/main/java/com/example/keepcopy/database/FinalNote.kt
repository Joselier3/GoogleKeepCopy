package com.example.keepcopy.database

data class FinalNote(
    val id: Int,
    val noteTitle: String,
    val note: String,
    val isPinned: Boolean,
    val noteTag: String
)

fun FinalNote.isPinned(): Boolean = isPinned