package com.android.mvvm.kotlin.task

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.mvvm.kotlin.data.source.model.RealestateResponse
import com.bumptech.glide.Glide

@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<RealestateResponse>?){
    items?.let {
        (listView.adapter as TasksAdapter).submitList(items)
    }
}

@BindingAdapter("loadImage")
fun setLoadImage(imageView: ImageView, imgUrl: String ){
    Glide.with(imageView.context).load(imgUrl).into(imageView)
}