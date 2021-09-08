package com.example.keepcopy

import android.app.Application
import com.example.keepcopy.database.NoteRoomDatabase

class KeepCopyApplication : Application() {
    val database: NoteRoomDatabase by lazy { NoteRoomDatabase.getDatabase(this) }
 }