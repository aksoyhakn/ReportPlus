package com.aksoyhakn.reportplus.ui.main.onboarding

import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.fragment.BaseFragment
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.databinding.FragmentOnboardingBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

@AndroidEntryPoint
class OnBoardingFragment :
    BaseFragment<FragmentOnboardingBinding>(R.layout.fragment_onboarding) {

    private val viewModel by viewModels<OnBoardingViewModel>()

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.fragment = this
        dataBinding.viewModel = viewModel
        dataBinding.supportManager = childFragmentManager
    }

    fun clickSign() {
        Navigation.findNavController(dataBinding.root)
            .navigate(R.id.action_onBoarding_to_homeFragment)
    }
}