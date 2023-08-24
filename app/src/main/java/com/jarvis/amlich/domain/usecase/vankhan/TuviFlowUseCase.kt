package com.jarvis.amlich.domain.usecase.vankhan

import com.jarvis.amlich.domain.model.TuViModel
import com.jarvis.amlich.domain.repository.QueRepository
import com.jarvis.amlich.domain.usecase.base.NoParamFlowUseCase
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.inject

class TuviFlowUseCase : NoParamFlowUseCase<Flow<List<TuViModel>>>() {

    private val queRepository: QueRepository by inject()

    override fun invoke(): Flow<List<TuViModel>> {
        return queRepository.getTuVi()
    }
}
