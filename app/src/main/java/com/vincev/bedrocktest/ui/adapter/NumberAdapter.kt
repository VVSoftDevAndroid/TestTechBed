package com.vincev.bedrocktest.ui.adapter

import android.view.View
import com.vincev.bedrocktest.R
import com.vincev.bedrocktest.base.RecyclerViewBaseAdapter
import com.vincev.bedrocktest.base.SectionRow
import com.vincev.bedrocktest.data.Number
import com.vincev.bedrocktest.ui.viewholder.NumberViewHolder

class NumberAdapter: RecyclerViewBaseAdapter() {
    init {
        addSection(arrayListOf<Number>())
    }

    fun addNumberList(numbers: List<Number>) {
        sections().first().run {
            clear()
            addAll(numbers)
            notifyDataSetChanged()
        }
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_number

    override fun viewHolder(layout: Int, view: View) = NumberViewHolder(view)

}