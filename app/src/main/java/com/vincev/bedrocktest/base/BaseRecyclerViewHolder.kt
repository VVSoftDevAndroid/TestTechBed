package com.vincev.bedrocktest.base

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewHolder(private val view: View)
    : RecyclerView.ViewHolder(view), View.OnClickListener {

    abstract fun bindData(data: Any)

    fun view(): View {
        return view
    }

    fun context(): Context {
        return view.context
    }
}