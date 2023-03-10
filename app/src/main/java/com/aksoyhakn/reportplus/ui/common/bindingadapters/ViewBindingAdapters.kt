package com.aksoyhakn.reportplus.ui.common.bindingadapters

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.graphics.PorterDuff
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.extensions.*
import com.tistory.zladnrms.roundablelayout.RoundableLayout

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

object ViewBindingAdapters {

    @JvmStatic
    @BindingAdapter("bind:setImage")
    fun setImage(view: ImageView, url: String?) {
        url?.let {
            view.loadImage(view.context, url, null)
        }
    }

    @JvmStatic
    @BindingAdapter("bind:setImageCricleCropCache")
    fun setImageCricleCropCache(view: ImageView, url: String?) {
        view.loadGlideImageCircleCropCache(view.context, url!!, null)
    }

    @JvmStatic
    @BindingAdapter("bind:setPublicImageCircleCropCache")
    fun setPublicImageCircleCropCache(view: ImageView, url: String?) {
        view.loadGlideImageCircleCropCache(view.context, url!!, null)
    }

    @JvmStatic
    @BindingAdapter("bind:setImageCache")
    fun setImageCache(view: ImageView, url: String?) {
        url.notNull {
            if (!url!!.contains(".gif")) {
                view.loadGlideImageCache(
                    view.context,
                    url,
                    null
                )
            } else {
                view.loadGIF(view.context, url)
            }
        }

    }

    @JvmStatic
    @BindingAdapter("bind:setImageColorFilter")
    fun setImageColorFilter(view: ImageView, isFilter: Boolean) {
        if (isFilter) {
            view.setColorFilter(
                view.context.resColor(R.color.colorPrimary),
                PorterDuff.Mode.SRC_IN
            )
        } else {
            view.setColorFilter(view.context.resColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN)
        }
    }


    @JvmStatic
    @BindingAdapter("bind:setColorFilter")
    fun setColorFilter(view: ImageView, colorID: Int?) {
        colorID.notNull {
            view.setColorFilter(
                it,
                PorterDuff.Mode.SRC_IN
            )
        }
    }

    @JvmStatic
    @BindingAdapter("onSafeClick")
    fun onSafeClick(view: View, listener: View.OnClickListener) {
        view.setSafeOnClickListener {
            listener.onClick(view)
        }
    }


    @SuppressLint("ObjectAnimatorBinding")
    @JvmStatic
    @BindingAdapter("progressAnimation")
    fun progressAnimation(view: ProgressBar, status: Boolean?) {
        val progressAnimator = ObjectAnimator.ofInt(view, "progress", 0, 100)
        progressAnimator.duration = 1000;
        progressAnimator.start()
    }
}

