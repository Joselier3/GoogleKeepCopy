package com.example.keepcopy.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "note_title")
    val noteTitle: String,
    @ColumnInfo
    val note: String,
    @ColumnInfo(name = "tag_id")
    val tagId: Int,
    @ColumnInfo(name = "is_pinned")
    val isPinned: Boolean
)