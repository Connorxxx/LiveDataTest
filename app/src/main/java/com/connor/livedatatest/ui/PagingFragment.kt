package com.connor.livedatatest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.connor.livedatatest.R
import com.connor.livedatatest.databinding.FragmentPagingBinding
import com.connor.livedatatest.vm.PagingViewModel
import com.drake.engine.base.EngineFragment

class PagingFragment : EngineFragment<FragmentPagingBinding>(R.layout.fragment_paging) {

    private val model: PagingViewModel by activityViewModels()

    override fun initView() {

    }

    override fun initData() {
        TODO("Not yet implemented")
    }


}