package com.aksoyhakn.reportplus.ui.common.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.databinding.ComponentProfileBinding
import com.aksoyhakn.reportplus.extensions.notNull

class ComponentProfile : ConstraintLayout {

    private lateinit var databinding: ComponentProfileBinding

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs)
    }


    private fun init(context: Context?, attrs: AttributeSet?) {
        databinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.component_profile,
                this,
                true
            )
    }

    fun setProfile(profile: String?) {
        profile.notNull {
            databinding.profile = it
        }
    }


    companion object {

        @JvmStatic
        @BindingAdapter("bind:setProfile")
        fun setProfile(
            view: ComponentProfile?,
            profile: String?
        ) {
            profile.notNull {
                view?.setProfile(it)
            }
        }
    }
}