package com.vincev.bedrocktest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.vincev.bedrocktest.R
import com.vincev.bedrocktest.base.DatabindingFragment
import com.vincev.bedrocktest.databinding.FragmentListBinding
import com.vincev.bedrocktest.ui.adapter.NumberAdapter
import com.vincev.bedrocktest.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.getSharedViewModel

class NumberListFragment : DatabindingFragment() {
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding<FragmentListBinding>(inflater, R.layout.fragment_list, container).apply {
        viewmodel = getSharedViewModel() as MainViewModel
        lifecycleOwner = viewLifecycleOwner
        numberListAdapter = NumberAdapter()
        this@NumberListFragment.binding = this
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
    }.root

}