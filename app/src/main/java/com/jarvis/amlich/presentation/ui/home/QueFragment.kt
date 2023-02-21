package com.jarvis.amlich.presentation.ui.home

import android.content.Intent
import com.jarvis.amlich.base.BaseFragment
import com.jarvis.amlich.base.recyclerview.SimpleBDAdapter
import com.jarvis.amlich.common.Constant.DETAIL
import com.jarvis.amlich.databinding.FragmentQueBinding
import com.jarvis.amlich.databinding.ItemQueBinding
import com.jarvis.amlich.domain.model.QueModel
import com.jarvis.amlich.presentation.ui.detail.DetailActivity
import com.jarvis.amlich.presentation.ui.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class QueFragment :
    BaseFragment<FragmentQueBinding, HomeViewModel>(FragmentQueBinding::inflate) {

    override val viewModel: HomeViewModel by viewModel()
    private var diaryActivity: MainActivity? = null
    private val listQueAdapter by lazy {
        SimpleBDAdapter<ItemQueBinding, QueModel>(ItemQueBinding::inflate) { itemBD, item, _ ->
            itemBD.tvQue.text = item.tenQUe
            itemBD.tvSoQue.text = item.stt.toString()
        }
    }

    override fun setupViews() {
        viewBD.recyclerQue.adapter = listQueAdapter.apply {
            onItemClick = { _, item, _ ->
                val intent = Intent()
                intent.putExtra(DETAIL, item.stt.toString())
                diaryActivity?.let { intent.setClass(it, DetailActivity::class.java) }
                startActivity(intent)
            }
        }
    }

    override fun initData() {
        viewModel.getAllQueData()
        this.diaryActivity = activity as MainActivity
        if (diaryActivity == null) {
            return
        }
    }

    override fun observeData() {
        viewModel.listQueLiveData.observe(viewLifecycleOwner) { movies ->
            listQueAdapter.submitList(movies.sortedBy { it.stt })
        }
    }
}
