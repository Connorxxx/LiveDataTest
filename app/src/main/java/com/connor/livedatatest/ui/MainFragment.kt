package com.connor.livedatatest.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.connor.livedatatest.R
import com.connor.livedatatest.databinding.FragmentMainBinding
import com.connor.livedatatest.vm.SharedViewModel
import com.drake.engine.base.EngineFragment
import kotlinx.coroutines.*

class MainFragment : EngineFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val model: SharedViewModel by activityViewModels()

    private val job = Job()
    private val scope = CoroutineScope(job)

    override fun initView() {
        binding.v = this
        binding.m = model.user.value
    }

    override fun initData() {
        model.user.observe(this, Observer {
            binding.textView2.text = it.firstName
        })
    }

    override fun onClick(v: View) {
        when (v) {
            binding.button -> {
                val userId = (0..10000).random().toString()
                model.getUser(userId)
            }
            binding.button2 -> {
                findNavController().navigate(R.id.action_mainFragment_to_blankFragment)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

}