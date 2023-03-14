package com.aksoyhakn.reportplus.ui.common.component

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.databinding.ComponentCategoryBinding
import com.aksoyhakn.reportplus.extensions.notNull

class ComponentCategory : ConstraintLayout {

    private lateinit var databinding: ComponentCategoryBinding

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
                R.layout.component_category,
                this,
                true
            )
    }

    fun setCategoryIcon(icon: Drawable?) {
        icon.notNull {
            databinding.icon = it
        }
    }


    fun setCategoryTitle(title: String?) {
        title.notNull {
            databinding.categoryTitle = it
        }
    }

    fun setCategoryCount(count: String?) {
        count.notNull {
            databinding.categoryCount = it
        }
    }


    companion object {

        @JvmStatic
        @BindingAdapter("bind:setCategoryIcon")
        fun setMenuIcon(
            view: ComponentCategory?,
            icon: Drawable?
        ) {
            icon.notNull {
                view?.setCategoryIcon(it)
            }
        }


        @JvmStatic
        @BindingAdapter("bind:setCategoryTitle")
        fun setCategoryTitle(
            view: ComponentCategory?,
            title: String?
        ) {
            title.notNull {
                view?.setCategoryTitle(it)
            }
        }

        @JvmStatic
        @BindingAdapter("bind:setCategoryTCount")
        fun setCategoryTCount(
            view: ComponentCategory?,
            count: String?
        ) {
            count.notNull {
                view?.setCategoryCount(it)
            }
        }
    }
}