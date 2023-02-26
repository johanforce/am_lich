package com.jarvis.amlich.presentation.ui.vannien.que

import android.content.Intent
import com.jarvis.amlich.base.BaseActivity
import com.jarvis.amlich.base.observe
import com.jarvis.amlich.base.recyclerview.SimpleBDAdapter
import com.jarvis.amlich.common.Constant.DETAIL
import com.jarvis.amlich.databinding.ActivityQueBinding
import com.jarvis.amlich.databinding.ItemQueBinding
import com.jarvis.amlich.domain.model.QueModel
import com.jarvis.amlich.presentation.ui.vannien.que.detail.DetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class QueActivity : BaseActivity<ActivityQueBinding>(ActivityQueBinding::inflate) {

    private val viewModel: QueViewModel by viewModel()

    private val listQueAdapter by lazy {
        SimpleBDAdapter<ItemQueBinding, QueModel>(ItemQueBinding::inflate) { itemBD, item, _ ->
            itemBD.tvQue.text = item.tenQUe
            itemBD.tvSoQue.text = item.stt.toString()
        }
    }

    override fun setupViews() {
        viewBD.toolbar.backToolbar { finish() }
        viewBD.recyclerQue.adapter = listQueAdapter.apply {
            onItemClick = { _, item, _ ->
                val intent = Intent()
                intent.putExtra(DETAIL, item.stt.toString())
                intent.setClass(this@QueActivity, DetailActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun initData() {
        viewModel.getAllQueData()
    }

    override fun observeData() {
        observe(viewModel.listQueLiveData) { listQue ->
            listQueAdapter.submitList(listQue.sortedBy { it.stt })
        }
    }
}
