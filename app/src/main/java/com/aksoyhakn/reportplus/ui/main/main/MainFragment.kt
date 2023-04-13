package com.aksoyhakn.reportplus.ui.main.main

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.fragment.BaseFragment
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.databinding.FragmentMainBinding
import com.aksoyhakn.reportplus.extensions.handler
import com.aksoyhakn.reportplus.extensions.setSafeOnClickListener
import com.aksoyhakn.reportplus.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val viewModel by viewModels<MainViewModel>()

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.viewModel = viewModel
        dataBinding.supportManager = childFragmentManager

        requireContext().handler(400L) {
            viewModel.getCurrentUser()
        }

        initClickListener()
    }

    private fun initClickListener() {
        dataBinding.ivProfile.rlBackground.setSafeOnClickListener {
            val bundle = bundleOf(
                Constants.Profile.PROFILE_DATA to viewModel.userData.get()
            )

            Navigation.findNavController(dataBinding.root)
                .navigate(R.id.action_navigation_main_to_profile, bundle)
        }
    }
}