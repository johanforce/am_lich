package com.jarvis.amlich.presentation.ui.vannien.vankhan.detail

import com.jarvis.amlich.base.BaseViewModel
import com.jarvis.amlich.common.utils.SingleLiveData
import com.jarvis.amlich.domain.model.DetailModel
import com.jarvis.amlich.domain.model.QueModel
import com.jarvis.amlich.domain.usecase.que.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

class DetailVanKhanViewModel : BaseViewModel()