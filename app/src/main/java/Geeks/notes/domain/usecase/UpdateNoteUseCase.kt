package com.geektech.notes.domain.usecase

import com.geektech.notes.domain.model.Note
import com.geektech.notes.domain.repository.NoteRepository
import javax.inject.Inject

class UpdateNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {

    fun updateNote(note: Note) = noteRepository.updateNote(note)

}