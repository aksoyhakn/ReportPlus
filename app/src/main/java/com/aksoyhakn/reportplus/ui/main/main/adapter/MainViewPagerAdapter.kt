package com.aksoyhakn.reportplus.ui.main.main.adapter

import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.aksoyhakn.reportplus.ui.common.component.ComponentIndicator
import com.aksoyhakn.reportplus.ui.main.main.MenuItem
import com.aksoyhakn.reportplus.ui.main.main.viewpager.FreeMainFragment
import com.aksoyhakn.reportplus.ui.main.main.viewpager.PremiumMainFragment

class MainViewPagerAdapter(
    fm: FragmentManager
) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            FreeMainFragment.newInstance()
        } else {
            PremiumMainFragment.newInstance()
        }
    }

    override fun getCount(): Int = 2

    companion object {
        @JvmStatic
        @BindingAdapter(value = ["bind:setMainManager", "bind:setMainIndicator"])
        fun setMainManager(
            viewPager: ViewPager,
            supportFragmentManager: FragmentManager?,
            indicator: ComponentIndicator?
        ) {
            val adapter = MainViewPagerAdapter(supportFragmentManager!!)
            viewPager.adapter = adapter
            indicator?.setViewPager(viewPager)
        }
    }
}