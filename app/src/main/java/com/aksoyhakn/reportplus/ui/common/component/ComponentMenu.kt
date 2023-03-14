package com.aksoyhakn.reportplus.ui.common.component

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.databinding.ComponentMenuBinding
import com.aksoyhakn.reportplus.extensions.notNull


class ComponentMenu : ConstraintLayout {

    private lateinit var databinding: ComponentMenuBinding

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
                R.layout.component_menu,
                this,
                true
            )
    }

    fun setIcon(icon: Drawable?) {
        icon.notNull {
            databinding.ivAppIcon.setImageDrawable(it)
        }
    }


    companion object {

        @JvmStatic
        @BindingAdapter("bind:setMenuIcon")
        fun setMenuIcon(
            view: ComponentMenu?,
            icon: Drawable?
        ) {
            icon.notNull {
                view?.setIcon(icon)
            }
        }
    }
}