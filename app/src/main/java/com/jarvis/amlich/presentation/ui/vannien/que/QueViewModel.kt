package com.jarvis.amlich.presentation.ui.vannien.que

import com.jarvis.amlich.base.BaseViewModel
import com.jarvis.amlich.common.utils.SingleLiveData
import com.jarvis.amlich.domain.model.QueModel
import com.jarvis.amlich.domain.usecase.QueUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

class QueViewModel : BaseViewModel() {
    private val queUseCase: QueUseCase by inject()

    val listQueLiveData = SingleLiveData<List<QueModel>>()

    fun getAllQueData() {
        executeTask(onExecute = {
            mLoading.value = true
            val listQue = withContext(Dispatchers.IO) {
                queUseCase.invoke()
            }
            listQueLiveData.postValue(listQue)
            mLoading.value = false
        })
    }
}
