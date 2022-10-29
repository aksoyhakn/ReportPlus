package com.example.trendline.ui.common.component.button

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.example.trendline.R
import com.example.trendline.databinding.ComponentButtonBinding
import com.example.trendline.extensions.resColor

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


class IyiyasaButton : RelativeLayout {

    private lateinit var databinding: ComponentButtonBinding

    constructor(context: Context?) : super(context) {
        init(context, null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs)
    }


    var btnBackgroundColor = context.resColor(R.color.antrasit)
        set(value) {
            field = value
        }

    var isActive = true
        set(value) {
            field = value
        }

    private fun init(context: Context?, attrs: AttributeSet?) {
        databinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.component_button,
                this,
                true
            )
    }

    fun setButtonText(buttonName: String?) {
        databinding.buttonName = buttonName
    }

    private fun setButtonIsActive() {

        if (!isActive) {
            databinding.rlButton.isClickable = true
            databinding.rlButton.backgroundColor = context.resColor(R.color.dark_grey)
        } else {
            databinding.rlButton.isClickable = false
            databinding.rlButton.backgroundColor = btnBackgroundColor
        }
    }

    companion object {

        @JvmStatic
        @BindingAdapter("bind:setButtonText")
        fun setButtonText(
            view: IyiyasaButton?,
            setButtonText: String?
        ) {
            view?.setButtonText(setButtonText)
        }

        @JvmStatic
        @BindingAdapter("bind:setButtonIsActive")
        fun setButtonIsActive(
            view: IyiyasaButton?,
            isActive: Boolean?
        ) {
            view?.isActive = isActive ?: true
            view?.setButtonIsActive()
        }

    }
}