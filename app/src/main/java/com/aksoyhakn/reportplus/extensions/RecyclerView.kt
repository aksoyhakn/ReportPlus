package com.aksoyhakn.reportplus.extensions

import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView?.deleteNotifyAnimate() {
    this?.itemAnimator = null
}

fun RecyclerView?.initNotifyAnimate(animator: RecyclerView.ItemAnimator = DefaultItemAnimator()) {
    this?.itemAnimator = animator
}


fun NestedScrollView.onScrollToEnd(
    onScrollNearEnd: (Unit) -> Unit
) =
    setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
        if (v.getChildAt(v.getChildCount() - 1) != null)
        {
            if (scrollY > oldScrollY)
            {
                if (scrollY >= (v.getChildAt(v.getChildCount() - 1).getMeasuredHeight() - v.getMeasuredHeight()))
                {
                    onScrollNearEnd(Unit)
                }
            }
        }
    })
