package com.jarvis.amlich.domain.usecase.note

import com.jarvis.amlich.domain.model.NoteModel
import com.jarvis.amlich.domain.model.TuViModel
import com.jarvis.amlich.domain.repository.QueRepository
import com.jarvis.amlich.domain.usecase.base.BaseUseCase
import com.jarvis.amlich.domain.usecase.base.BaseUseCaseString
import com.jarvis.amlich.domain.usecase.base.NoResultBaseUseCase
import org.koin.core.component.inject

class InsertNoteUseCase : NoResultBaseUseCase<NoteModel>() {

    private val queRepository: QueRepository by inject()

    override suspend fun invoke(note: NoteModel) {
        return queRepository.insertNote(note)
    }
}
