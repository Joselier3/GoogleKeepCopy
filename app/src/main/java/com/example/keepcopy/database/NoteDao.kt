package com.example.keepcopy.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT note.id, note.note_title, note.note, note.is_pinned, tag.tag_title, tag.id " +
            "FROM note " +
            "JOIN tag " +
            "ON note.tag_id = tag_id")
    fun allNotes(): Flow<List<FinalNote>>

    @Query("SELECT * FROM note")
    fun allNotesTest(): Flow<List<FinalNote>>

    @Query("SELECT tag.id FROM tag WHERE tag.tag_title = :tagTitle")
    fun getTagId(tagTitle: String): Int
}