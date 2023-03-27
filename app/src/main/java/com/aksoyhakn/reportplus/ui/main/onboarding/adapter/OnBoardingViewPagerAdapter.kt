package com.aksoyhakn.reportplus.ui.main.onboarding.adapter

import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.aksoyhakn.reportplus.extensions.notNull
import com.aksoyhakn.reportplus.ui.common.component.ComponentIndicator

class OnBoardingViewPagerAdapter(
    fm: FragmentManager,
    var mainData: ArrayList<String>
) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return OnBoardingBannerFragment.newInstance(mainData[position])
    }

    override fun getCount(): Int = mainData.size

    companion object {
        @JvmStatic
        @BindingAdapter(value = ["bind:setOnBoardingBannerManager", "bind:setOnBoardingBannerData", "bind:setOnBoardingBannerIndicator"])
        fun setOnBoardingBannerManager(
            viewPager: ViewPager,
            supportFragmentManager: FragmentManager?,
            bannerData: ArrayList<String>?,
            indicator: ComponentIndicator?
        ) {

            bannerData.notNull {
                val adapter = OnBoardingViewPagerAdapter(supportFragmentManager!!, it)
                viewPager.adapter = adapter
                indicator?.setViewPager(viewPager)
            }

        }
    }
}