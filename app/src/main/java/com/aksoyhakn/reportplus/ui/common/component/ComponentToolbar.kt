package com.aksoyhakn.reportplus.ui.common.component

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.databinding.ComponentToolbarBinding
import com.aksoyhakn.reportplus.extensions.isNull
import com.aksoyhakn.reportplus.extensions.notNull
import com.aksoyhakn.reportplus.extensions.show

class ComponentToolbar : ConstraintLayout {

    private lateinit var databinding: ComponentToolbarBinding

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
                R.layout.component_toolbar,
                this,
                true
            )
    }

    fun setIcon(icon: Drawable?) {
        icon.notNull {
            databinding.icon = it
        }
    }

    fun setTitle(title: String?) {
        title.notNull {
            databinding.appTitle = it
        }
        title.isNull {
            databinding.ivAppIcon.show()
        }
    }

    companion object {

        @JvmStatic
        @BindingAdapter("bind:setToolbarTitle")
        fun setToolbarTitle(
            view: ComponentToolbar?,
            title: String?
        ) {
            view?.setTitle(title)
        }

        @JvmStatic
        @BindingAdapter("bind:setToolbarIcon")
        fun setToolbarIcon(
            view: ComponentToolbar?,
            icon: Drawable?
        ) {
            icon.notNull {
                view?.setIcon(it)
            }
        }
    }
}