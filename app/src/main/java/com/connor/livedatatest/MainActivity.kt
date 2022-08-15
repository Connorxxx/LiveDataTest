package com.connor.livedatatest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.connor.livedatatest.databinding.ActivityMainBinding
import com.drake.engine.base.EngineActivity

class MainActivity : EngineActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun initView() {
        val navController = findNavController(R.id.nav)
    }

    override fun initData() {

    }

}