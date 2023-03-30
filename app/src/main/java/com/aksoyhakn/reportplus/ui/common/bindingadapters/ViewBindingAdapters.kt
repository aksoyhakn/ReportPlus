package com.aksoyhakn.reportplus.ui.common.bindingadapters

import android.content.res.Configuration
import android.graphics.PorterDuff
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDelegate
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
    fun setImageColorFilter(view: ImageView, isDarkMode: Boolean) {
        when (AppCompatDelegate.getDefaultNightMode()) {
            Configuration.UI_MODE_NIGHT_YES -> {
                view.setColorFilter(view.context.resColor(R.color.dark), PorterDuff.Mode.SRC_IN)
                view.setImageResource(R.drawable.ic_settings)
            }
            else -> {
                view.setColorFilter(view.context.resColor(R.color.dark), PorterDuff.Mode.SRC_IN)
                view.setImageResource(R.drawable.ic_settings_dark)
            }
        }
    }

    @JvmStatic
    @BindingAdapter("bind:setCategoryStrokeColorFilter")
    fun setStrokeColorFilter(view: RoundableLayout, isColor: Boolean) {
        when (AppCompatDelegate.getDefaultNightMode()) {
            Configuration.UI_MODE_NIGHT_YES -> {
                view.strokeLineColor = view.context.resColor(R.color.darkv2)
            }
            else -> {
                view.strokeLineColor = view.context.resColor(R.color.color1)
            }
        }
    }

    @JvmStatic
    @BindingAdapter("bind:setCategoryBackgroundColor")
    fun setCategoryBackgroundColor(view: RoundableLayout, isColor: Boolean) {
        when (AppCompatDelegate.getDefaultNightMode()) {
            Configuration.UI_MODE_NIGHT_YES -> {
                view.backgroundColor = view.context.resColor(R.color.darkv2)
            }
            else -> {
                view.backgroundColor = view.context.resColor(R.color.grey6)
            }
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

    @JvmStatic
    @BindingAdapter("bind:setSplashBackgroundColor")
    fun setSplashBackgroundColor(view: ImageView, isNight: Boolean) {
        when (AppCompatDelegate.getDefaultNightMode()) {
            Configuration.UI_MODE_NIGHT_YES -> {
                view.setImageResource(R.drawable.splash_dark)
            }
            else -> {
                view.setImageResource(R.drawable.splash_light)
            }
        }
    }


}

