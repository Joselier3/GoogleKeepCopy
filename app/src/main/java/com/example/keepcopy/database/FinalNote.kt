package com.example.keepcopy.database

import androidx.room.ColumnInfo

data class FinalNote (
    @ColumnInfo
    val id: Int,
    @ColumnInfo(name = "title")
    val noteTitle: String,
    @ColumnInfo
    val note: String,
    @ColumnInfo(name = "is_pinned")
    val isPinned: Boolean,
    @ColumnInfo(name = "title")
    val noteTag: String
)

fun FinalNote.isPinned(): Boolean = isPinned
