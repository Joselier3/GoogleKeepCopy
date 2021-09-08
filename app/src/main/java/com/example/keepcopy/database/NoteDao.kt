package com.example.keepcopy.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT note.id, note.title, note.note, note.is_pinned ,tag.title " +
            "FROM note " +
            "JOIN tag " +
            "ON note.tag_id = tag_id")
    fun allNotes(): Flow<List<FinalNote>>
}