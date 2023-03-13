package com.jarvis.amlich.presentation.ui.vannien.vankhan.detail

import com.jarvis.amlich.base.BaseActivity
import com.jarvis.amlich.common.Constant
import com.jarvis.amlich.databinding.ActivityDetailVankhanBinding
import com.jarvis.amlich.domain.model.VanKhanModel
import com.jarvis.amlich.presentation.ui.vannien.vankhan.VanKhanViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailVanKhanActivity :
    BaseActivity<ActivityDetailVankhanBinding>(ActivityDetailVankhanBinding::inflate) {
    private val viewModel: VanKhanViewModel by viewModel()

    override fun setupViews() {
        viewBD.toolbar.backToolbar { finish() }
    }

    override fun initData() {
        val vanKhanModel =
            intent.getParcelableExtra<VanKhanModel>(Constant.DATA_VAN_KHAN)
        viewBD.tvTitles.text = vanKhanModel?.name?:""
        viewBD.tvContent.text = vanKhanModel?.noiDung ?: ""
    }
}
