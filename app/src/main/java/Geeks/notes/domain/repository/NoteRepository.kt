package com.geektech.notes.domain.repository

import com.geektech.notes.domain.model.Note
import com.geektech.notes.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getAllNotes(): Flow<Resource<List<Note>>>

    fun createNote(note: Note): Flow<Resource<Unit>>

    fun updateNote(note: Note): Flow<Resource<Unit>>

    fun deleteNote(note: Note): Flow<Resource<Unit>>

}