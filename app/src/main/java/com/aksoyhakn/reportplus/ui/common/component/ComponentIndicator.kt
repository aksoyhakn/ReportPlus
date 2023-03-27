package com.aksoyhakn.reportplus.ui.common.component

import android.content.Context
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.aksoyhakn.reportplus.R
import kotlin.math.roundToInt

class ComponentIndicator : LinearLayout {
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    fun setViewPager(viewPager: ViewPager?, margin: Int = 2) {
        if (viewPager != null && viewPager.adapter != null && viewPager.adapter!!.count != 0) {
            val count = viewPager.adapter!!.count
            val dots = arrayOfNulls<ImageView>(count)
            val passiveDot = drawPassiveDot()
            val activeDot = drawActiveDot()

            for (i in 0 until count) {
                dots[i] = ImageView(context)
                dots[i]?.setImageDrawable(passiveDot)
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(
                    dp2px(context, margin.toFloat()),
                    0,
                    dp2px(context, margin.toFloat()),
                    0
                )
                addView(dots[i], params)
            }
            dots[0]?.setImageDrawable(activeDot)

            viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                }

                override fun onPageSelected(position: Int) {
                    for (i in 0 until count) {
                        dots[i]?.setImageDrawable(passiveDot)
                    }
                    dots[position]?.setImageDrawable(activeDot)
                }

                override fun onPageScrollStateChanged(state: Int) {
                }
            })
        }
    }

    private fun drawActiveDot(): ShapeDrawable {
        val activeColor: Int = ContextCompat.getColor(context, R.color.color2)
        val oval = ShapeDrawable(OvalShape())
        oval.intrinsicHeight = dp2px(context, 8f)
        oval.intrinsicWidth = dp2px(context, 8f)
        oval.paint.color = activeColor
        return oval
    }

    private fun drawPassiveDot(): ShapeDrawable {
        val oval = ShapeDrawable(OvalShape())
        oval.intrinsicHeight = dp2px(context, 8f)
        oval.intrinsicWidth = dp2px(context, 8f)
        oval.paint.color = ContextCompat.getColor(context, R.color.grey6)
        return oval
    }

    fun dp2px(context: Context, dp: Float): Int {
        val px = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            context.resources.displayMetrics
        )
        return px.roundToInt()
    }

}