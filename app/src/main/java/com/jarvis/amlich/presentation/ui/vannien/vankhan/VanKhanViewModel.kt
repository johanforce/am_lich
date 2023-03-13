package com.jarvis.amlich.presentation.ui.vannien.vankhan

import com.jarvis.amlich.base.BaseViewModel
import com.jarvis.amlich.common.utils.SingleLiveData
import com.jarvis.amlich.domain.model.VanKhanModel
import com.jarvis.amlich.domain.usecase.vankhan.VanKhanUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

class VanKhanViewModel : BaseViewModel() {
    private val vanKhanUseCase: VanKhanUseCase by inject()

    val listVanKhanLiveData = SingleLiveData<List<VanKhanModel>>()

    fun getAllVanKhanData() {
        executeTask(onExecute = {
            mLoading.value = true
            val listVanKhan = withContext(Dispatchers.IO) {
                vanKhanUseCase.invoke()
            }
            listVanKhanLiveData.postValue(listVanKhan)
            mLoading.value = false
        })
    }
}
