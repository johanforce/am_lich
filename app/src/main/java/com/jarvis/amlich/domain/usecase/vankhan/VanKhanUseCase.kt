package com.jarvis.amlich.domain.usecase.vankhan

import com.jarvis.amlich.domain.model.VanKhanModel
import com.jarvis.amlich.domain.repository.QueRepository
import com.jarvis.amlich.domain.usecase.base.NoParamUseCase
import org.koin.core.component.inject

class VanKhanUseCase : NoParamUseCase<List<VanKhanModel>>() {

    private val queRepository: QueRepository by inject()

    override suspend fun invoke(): List<VanKhanModel> {
        return queRepository.getAllVanKhan()
    }

}
