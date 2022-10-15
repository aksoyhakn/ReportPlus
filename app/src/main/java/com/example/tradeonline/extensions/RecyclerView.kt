package com.example.tradeonline.extensions

import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView?.deleteNotifyAnimate() {
    this?.itemAnimator = null
}

fun RecyclerView?.initNotifyAnimate(animator: RecyclerView.ItemAnimator = DefaultItemAnimator()) {
    this?.itemAnimator = animator
}