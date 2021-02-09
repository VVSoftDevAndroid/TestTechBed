package com.vincev.bedrocktest.ui.viewholder

import android.view.View
import androidx.core.view.ViewCompat
import androidx.fragment.app.commit
import com.vincev.bedrocktest.R
import com.vincev.bedrocktest.base.BaseRecyclerViewHolder
import com.vincev.bedrocktest.data.Number
import com.vincev.bedrocktest.databinding.ItemNumberBinding
import com.vincev.bedrocktest.ui.MainActivity
import com.vincev.bedrocktest.ui.NumberDetailFragment
import com.vincev.bedrocktest.ui.ViewUtils
import com.vincev.bedrocktest.ui.binding.bindings

class NumberViewHolder(view: View) : BaseRecyclerViewHolder(view) {

    private lateinit var data: Number
    private val binding: ItemNumberBinding by bindings(view)

    init {
        view.setOnClickListener(this)
    }

    override fun bindData(data: Any) {
        if (data is Number) {
            this.data = data
            drawItemUI()
        }
    }

    private fun drawItemUI() {
        binding.apply {
            ViewCompat.setTransitionName(binding.itemContainer, data.name)
            number = data
            executePendingBindings()
        }
    }

    override fun onClick(view: View?) {
        view?.let {
            val activity = it.context as MainActivity
            activity.supportFragmentManager.popBackStackImmediate()
            activity.supportFragmentManager.commit {
                replace(
                     R.id.fragment_container_view2,
                    NumberDetailFragment.newInstance(data.name)
                ).addToBackStack(null)
                if (!ViewUtils.isTabletLand(context())) {
                    replace(
                        R.id.fragment_container_view,
                        NumberDetailFragment.newInstance(data.name)
                    ).addToBackStack(null)
                }
            }
        }
    }

}