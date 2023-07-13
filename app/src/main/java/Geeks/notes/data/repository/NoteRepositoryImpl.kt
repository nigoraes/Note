package com.geektech.notes.data.repository

import com.geektech.notes.data.local.NoteDao
import com.geektech.notes.data.mapper.toEntity
import com.geektech.notes.data.mapper.toNote
import com.geektech.notes.domain.model.Note
import com.geektech.notes.domain.repository.NoteRepository
import com.geektech.notes.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(

    private val noteDao: NoteDao

) : NoteRepository {
    override fun getAllNotes(): Flow<Resource<List<Note>>> = flow {
        emit(Resource.Loading())
        try {
            val data = noteDao.getAllNotes().map { it.toNote() }
            emit(Resource.Success(data))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage?: "Unknown Error"))
        }
    }.flowOn(Dispatchers.IO)

    override fun createNote(note: Note) = flow {
        emit(Resource.Loading())
        kotlinx.coroutines.delay(2000)
        try {
            val data = noteDao.createNotes(note.toEntity())
            emit(Resource.Success(data))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage?: "Unknown Error"))
        }
    }.flowOn(Dispatchers.IO)

    override fun updateNote(note: Note) = flow {
        emit(Resource.Loading())
        try {
            val data = noteDao.updateNotes(note.toEntity())
            emit(Resource.Success(data))
        }catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage?: "Unknown Error"))
        }
    }.flowOn(Dispatchers.IO)

    override fun deleteNote(note: Note) = flow {
        emit(Resource.Loading())
        try {
            val data = noteDao.deleteNotes(note.toEntity())
            emit(Resource.Success(data))
        }catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage?: "Unknown Error"))
        }
    }.flowOn(Dispatchers.IO)
}