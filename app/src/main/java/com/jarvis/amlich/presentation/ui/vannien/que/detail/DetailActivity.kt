package com.jarvis.amlich.presentation.ui.vannien.que.detail

import com.jarvis.amlich.R
import com.jarvis.amlich.base.BaseActivity
import com.jarvis.amlich.base.observe
import com.jarvis.amlich.base.recyclerview.SimpleBDAdapter
import com.jarvis.amlich.databinding.ActivityDetailQueBinding
import com.jarvis.amlich.databinding.ItemDanhMucBinding
import com.jarvis.amlich.domain.model.DetailModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : BaseActivity<ActivityDetailQueBinding>(ActivityDetailQueBinding::inflate) {
    private val viewModel: DetailViewModel by viewModel()

    private val listDetailQueAdapter by lazy {
        SimpleBDAdapter<ItemDanhMucBinding, DetailModel>(ItemDanhMucBinding::inflate) { itemBD, item, _ ->
            itemBD.tvHonNhan.text = item.title
            itemBD.tvHonNhanTho.text = item.thoDich.toString()
            itemBD.tvHonNhanBan.text = item.banLuan.toString()
        }
    }

    override fun setupViews() {
        viewBD.toolbar.backToolbar { finish() }
        viewBD.recyclerTopRatedMovies.adapter = listDetailQueAdapter
    }

    override fun initData() {
        val idQue: String = intent.getStringExtra("DETAIL") ?: ""
        viewModel.getDataDetailQue(idQue.toInt())
    }

    override fun observeData() {
        observe(viewModel.details) {
            listDetailQueAdapter.submitList(it)
        }
        observe(viewModel.queModel) {
            viewBD.tvTich.text = it.tichXua
            viewBD.tvTitle.text = getString(R.string.so_que_title, it.stt, it.tenQUe)
            viewBD.tvStatus.text = it.status
        }
    }
}
