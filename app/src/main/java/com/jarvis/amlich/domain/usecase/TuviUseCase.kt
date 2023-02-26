package com.jarvis.amlich.domain.usecase

import com.jarvis.amlich.domain.model.TuViModel
import com.jarvis.amlich.domain.model.VanKhanModel
import com.jarvis.amlich.domain.repository.QueRepository
import com.jarvis.amlich.domain.usecase.base.BaseUseCaseInt
import com.jarvis.amlich.domain.usecase.base.BaseUseCaseString
import org.koin.core.component.inject

class TuviUseCase : BaseUseCaseString<List<TuViModel>, String>() {

    private val queRepository: QueRepository by inject()

    override suspend fun invoke(cung: String): List<TuViModel> {
        return queRepository.getGiaiDoanTuViTheoCung(cung)
    }

}
