package com.connor.livedatatest.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.connor.livedatatest.R
import com.connor.livedatatest.adapter.RepoAdapter
import com.connor.livedatatest.databinding.FragmentPagingBinding
import com.connor.livedatatest.vm.PagingViewModel
import com.drake.engine.base.EngineFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PagingFragment : EngineFragment<FragmentPagingBinding>(R.layout.fragment_paging) {

    companion object {
        private const val TAG = "PagingFragment"
    }

    private val viewModel: PagingViewModel by activityViewModels()

    private val repoAdapter = RepoAdapter()

    override fun initView() {
        binding.rv.adapter = repoAdapter
//        repoAdapter.addLoadStateListener {
//            when (it.refresh) {
//                is LoadState.NotLoading -> {
//                    Log.d(TAG, "NotLoading: ")
//                    binding.rv.visibility = View.VISIBLE
//                }
//                is LoadState.Loading -> {
//                    binding.rv.visibility = View.INVISIBLE
//                    Log.d(TAG, "Loading: ")
//                }
//                is LoadState.Error -> {
//                    binding.rv.visibility = View.INVISIBLE
//                    Log.d(TAG, "Error: ")
//                }
//            }
//        }
    }

    override fun initData() {
        lifecycleScope.launch {
            viewModel.getPagingData().collect() {
                repoAdapter.submitData(it)
            }
        }
    }


}