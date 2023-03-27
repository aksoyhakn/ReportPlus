package com.aksoyhakn.reportplus.ui.main.onboarding.adapter

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.fragment.BaseFragment
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.databinding.FragmentOnboardingBannerBinding
import com.aksoyhakn.reportplus.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

@AndroidEntryPoint
class OnBoardingBannerFragment :
    BaseFragment<FragmentOnboardingBannerBinding>(R.layout.fragment_onboarding_banner) {

    private val data: String? by lazy {
        arguments?.getString(Constants.Banner.BANNER_DATA)
    }

    private val viewModel by viewModels<OnBoardingBannerViewModel>()

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.data = data
    }

    companion object {
        fun newInstance(data: String): OnBoardingBannerFragment {
            val fragment = OnBoardingBannerFragment()
            val bundle = bundleOf(
                Constants.Banner.BANNER_DATA to data
            )
            fragment.arguments = bundle
            return fragment
        }
    }
}