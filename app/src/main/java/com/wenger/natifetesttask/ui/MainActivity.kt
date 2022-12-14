package com.wenger.natifetesttask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.wenger.natifetesttask.R
import com.wenger.natifetesttask.base.BaseActivity
import com.wenger.natifetesttask.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private var binding: ActivityMainBinding? = null
    private val viewModel: MainActivityViewModel by viewModels()
    override fun getNavFragment(): Fragment? =
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}