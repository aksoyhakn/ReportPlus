package com.aksoyhakn.reportplus.ui.main.onboarding

import android.content.Intent
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.fragment.BaseFragment
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.databinding.FragmentOnboardingBinding
import com.aksoyhakn.reportplus.ui.login.LoginActivity
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
        preferenceHelperImp.getCookie().takeIf { it.isNullOrEmpty() }?.apply {
            val intent = Intent(activity, LoginActivity::class.java)
            startActivityForResult(intent,1)
        } ?: kotlin.run {
            Navigation.findNavController(dataBinding.root)
                .navigate(R.id.action_onBoarding_to_homeFragment)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Navigation.findNavController(dataBinding.root)
            .navigate(R.id.action_onBoarding_to_homeFragment)
    }
}