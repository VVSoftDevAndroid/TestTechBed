package com.vincev.bedrocktest.ui.binding

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.vincev.bedrocktest.R
import com.vincev.bedrocktest.ui.gone

object ViewBinding {
    @JvmStatic
    @BindingAdapter("loadImage")
    fun bindLoadImage(view: AppCompatImageView, url: String?) {
        Glide.with(view.context)
            .load(url ?: R.drawable.ic_image_not_found)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("gone")
    fun bindGone(view: View, shouldBeGone: Boolean?) {
        if (shouldBeGone == true) {
            view.gone(true)
        } else {
            view.gone(false)
        }
    }
}