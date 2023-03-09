package com.jarvis.amlich.domain.usecase.note

import com.jarvis.amlich.domain.model.NoteModel
import com.jarvis.amlich.domain.repository.QueRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetNoteUseCase : KoinComponent {

    private val queRepository: QueRepository by inject()

    suspend fun invoke(startDate: Long, endDate: Long): List<NoteModel> {
        return queRepository.getNoteInDay(startDate, endDate)
    }
}
