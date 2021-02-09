package com.vincev.bedrocktest.ui

import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.vincev.bedrocktest.R
import com.vincev.bedrocktest.base.DataBindingBaseActivity
import com.vincev.bedrocktest.databinding.ActivityMainBinding
import org.koin.android.viewmodel.ext.android.getViewModel

//choix 1 viewmodel : https://developer.android.com/topic/libraries/architecture/viewmodel#sharing
class MainActivity : DataBindingBaseActivity() {
    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@MainActivity
            viewmodel = getViewModel()
            executePendingBindings()
        }
        fetchFragments(savedInstanceState)
    }

    private fun fetchFragments(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<NumberListFragment>(R.id.fragment_container_view)
                replace<NumberDetailFragment>(R.id.fragment_container_view2)
            }
        } else {
            supportFragmentManager.popBackStackImmediate()
            supportFragmentManager.commit {
                replace<NumberListFragment>(R.id.fragment_container_view)
            }
        }
    }
}