package com.jarvis.amlich.presentation.ui.vannien.tuvi

import com.jarvis.amlich.domain.model.TuViModel
import com.jarvis.amlich.domain.usecase.vankhan.TuviFlowUseCase
import com.jarvis.amlich.presentation.ui.calendar.CalendarViewModel
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.inject

class TuViViewModel : CalendarViewModel() {
    private val tuViFlowUseCase: TuviFlowUseCase by inject()
    val listFlowTuvi: Flow<List<TuViModel>> = tuViFlowUseCase.invoke()
}

