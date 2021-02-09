package com.vincev.bedrocktest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.vincev.bedrocktest.R
import com.vincev.bedrocktest.base.DatabindingFragment
import com.vincev.bedrocktest.databinding.FragmentDetailBinding
import com.vincev.bedrocktest.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.getSharedViewModel

class NumberDetailFragment : DatabindingFragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding<FragmentDetailBinding>(inflater, R.layout.fragment_detail, container).apply {
        val viewModel = getSharedViewModel() as MainViewModel
        viewmodel = viewModel
        lifecycleOwner = viewLifecycleOwner
        viewLifecycleOwner.lifecycleScope.launch { arguments?.get(ARG_NUMBER_NAME)?.let { viewModel.loadNumberDetail(it as String) } }
        this@NumberDetailFragment.binding = this
    }.root

    companion object {
        private const val ARG_NUMBER_NAME = "ARG_NUMBER_NAME"

        fun newInstance(numberName: String): NumberDetailFragment {
            val args = Bundle()
            args.putString(ARG_NUMBER_NAME, numberName)
            val fragment = NumberDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }

}