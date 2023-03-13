package com.jarvis.amlich.presentation.ui.vannien.vankhan

import android.content.Intent
import com.jarvis.amlich.base.BaseActivity
import com.jarvis.amlich.base.observe
import com.jarvis.amlich.base.recyclerview.SimpleBDAdapter
import com.jarvis.amlich.common.Constant.DATA_VAN_KHAN
import com.jarvis.amlich.common.extension.onChangeText
import com.jarvis.amlich.databinding.ActivityVankhanBinding
import com.jarvis.amlich.databinding.ItemQueBinding
import com.jarvis.amlich.domain.model.VanKhanModel
import com.jarvis.amlich.presentation.ui.vannien.vankhan.detail.DetailVanKhanActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class VanKhanActivity : BaseActivity<ActivityVankhanBinding>(ActivityVankhanBinding::inflate) {

    private val viewModel: VanKhanViewModel by viewModel()

    private val listQueAdapter by lazy {
        SimpleBDAdapter<ItemQueBinding, VanKhanModel>(ItemQueBinding::inflate) { itemBD, item, _ ->
            itemBD.tvQue.text = item.name
            itemBD.tvSoQue.text = item.id.toString()
        }
    }

    override fun setupViews() {
        viewBD.toolbar.backToolbar { finish() }
        viewBD.recyclerQue.adapter = listQueAdapter.apply {
            onItemClick = { _, item, _ ->
                val intent = Intent()
                intent.putExtra(DATA_VAN_KHAN, item)
                intent.setClass(this@VanKhanActivity, DetailVanKhanActivity::class.java)
                startActivity(intent)
            }
        }
//        viewBD.icSearch.click {
//
//        }
        viewBD.etSearch.onChangeText {
            handleSearch(it)
        }
    }

    private fun handleSearch(text: String) {
        val listSearch =
            viewModel.listVanKhanLiveData.value?.filter { it.name?.contains(text) == true }
        if (listSearch.isNullOrEmpty()) listQueAdapter.submitList(viewModel.listVanKhanLiveData.value?.sortedBy { it.id })
        else listQueAdapter.submitList(listSearch)
    }

    override fun initData() {
        viewModel.getAllVanKhanData()
    }

    override fun observeData() {
        observe(viewModel.listVanKhanLiveData) { listQue ->
            listQueAdapter.submitList(listQue.sortedBy { it.id })
        }
    }
}
