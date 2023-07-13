package com.geektech.notes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geektech.notes.data.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

}