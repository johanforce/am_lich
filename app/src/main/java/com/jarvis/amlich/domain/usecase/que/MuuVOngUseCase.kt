package com.jarvis.amlich.domain.usecase.que

import com.jarvis.amlich.domain.model.MuuVongModel
import com.jarvis.amlich.domain.repository.QueRepository
import com.jarvis.amlich.domain.usecase.base.BaseUseCaseInt
import org.koin.core.component.inject

class MuuVOngUseCase : BaseUseCaseInt<MuuVongModel, Int>() {

    private val queRepository: QueRepository by inject()

    override suspend fun invoke(idQue: Int): MuuVongModel {
        return queRepository.getMuuVong(idQue)
    }
}
