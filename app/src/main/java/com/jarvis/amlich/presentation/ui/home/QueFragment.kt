package com.jarvis.amlich.presentation.ui.home

import com.jarvis.amlich.R
import com.jarvis.amlich.base.BaseFragment
import com.jarvis.amlich.base.recyclerview.SimpleBDAdapter
import com.jarvis.amlich.databinding.FragmentQueBinding
import com.jarvis.amlich.databinding.ItemQueBinding
import com.jarvis.amlich.domain.model.QueModel
import com.jarvis.amlich.presentation.ui.detail.DetailFragmentArgs
import org.koin.androidx.viewmodel.ext.android.viewModel

class QueFragment :
    BaseFragment<FragmentQueBinding, HomeViewModel>(FragmentQueBinding::inflate) {

    override val viewModel: HomeViewModel by viewModel()

    private val listQueAdapter by lazy {
        SimpleBDAdapter<ItemQueBinding, QueModel>(ItemQueBinding::inflate) { itemBD, item, _ ->
            itemBD.tvQue.text = item.tenQUe
            itemBD.tvSoQue.text = item.stt.toString()
        }
    }

    override fun setupViews() {
        viewBD.recyclerQue.adapter = listQueAdapter.apply {
            onItemClick = { _, item, _ ->
                val bundle = DetailFragmentArgs(item.stt.toString()).toBundle()
                navigate(R.id.detailFragment, bundle)
            }
        }
    }

    override fun initData() {
        viewModel.getAllQueData()
    }

    override fun observeData() {
        viewModel.listQueLiveData.observe(viewLifecycleOwner) { movies ->
            listQueAdapter.submitList(movies.sortedBy { it.stt })
        }
    }
}
