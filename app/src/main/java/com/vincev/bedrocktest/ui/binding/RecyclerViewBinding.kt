package com.vincev.bedrocktest.ui.binding

import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vincev.bedrocktest.base.RecyclerViewBaseAdapter
import com.vincev.bedrocktest.data.Number
import com.vincev.bedrocktest.ui.adapter.NumberAdapter


object RecyclerViewBinding {
    @JvmStatic
    @BindingAdapter("adapter")
    fun bindAdapter(view: RecyclerView, baseAdapter: RecyclerViewBaseAdapter) {
        view.adapter = baseAdapter
    }

    @JvmStatic
    @BindingAdapter("toast")
    fun bindToast(view: RecyclerView, text: String?) {
        text?.let {
            if (it.isNotEmpty())
                Toast.makeText(view.context, it, Toast.LENGTH_SHORT).show()
        }

    }

    @JvmStatic
    @BindingAdapter("numberList")
    fun bindNumberList(view: RecyclerView, numbers: List<Number>?) {
        if (!numbers.isNullOrEmpty()) {
            val adapter: NumberAdapter = view.adapter as NumberAdapter
            adapter.addNumberList(numbers)
        }
    }
}