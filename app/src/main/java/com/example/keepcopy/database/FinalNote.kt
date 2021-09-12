package com.example.keepcopy.database

import androidx.room.ColumnInfo

data class FinalNote (
    @ColumnInfo
    val id: Int,
    @ColumnInfo(name = "note_title")
    val noteTitle: String,
    @ColumnInfo
    val note: String,
    @ColumnInfo(name = "is_pinned")
    val isPinned: Boolean,
    @ColumnInfo(name = "tag_title")
    val noteTag: String?
)

fun FinalNote.isPinned(): Boolean = isPinned
