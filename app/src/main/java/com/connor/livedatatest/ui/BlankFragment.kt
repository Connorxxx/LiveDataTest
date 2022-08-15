package com.connor.livedatatest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.connor.livedatatest.R
import com.connor.livedatatest.databinding.FragmentBlankBinding
import com.connor.livedatatest.vm.SharedViewModel
import com.drake.engine.base.Engine
import com.drake.engine.base.EngineFragment

class BlankFragment : EngineFragment<FragmentBlankBinding>(R.layout.fragment_blank) {

    private val model: SharedViewModel by activityViewModels()

    override fun initView() {
        binding.v = this
        binding.m = model.user.value
    }

    override fun initData() {
        model.user.observe(this, Observer {
            binding.textView3.text = it.firstName
        })
    }

    override fun onClick(v: View) {
        when (v) {
            binding.button3 -> {
                findNavController().navigate(R.id.action_blankFragment_to_mainFragment)
            }
            binding.button4 -> {
                val userId = (0..10000).random().toString()
                model.getUser(userId)
            }
        }
    }

}