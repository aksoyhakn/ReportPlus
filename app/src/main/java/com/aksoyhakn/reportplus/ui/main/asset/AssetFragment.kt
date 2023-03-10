package com.aksoyhakn.reportplus.ui.main.asset

import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.fragment.BaseFragment
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.databinding.FragmentAssetBinding
import com.aksoyhakn.reportplus.ui.main.expert.model.UserFollowingListResponse
import com.aksoyhakn.reportplus.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


@AndroidEntryPoint
class AssetFragment : BaseFragment<FragmentAssetBinding>(R.layout.fragment_asset) {

    private val viewModel by viewModels<AssetViewModel>()

    private val assetResponse: UserFollowingListResponse? by lazy {
        arguments?.getParcelable(Constants.Main.EXPERT_DETAIL_USER_FOLLOW_DETAIL)
    }

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.viewModel = viewModel
        dataBinding.fragment = this

        assetResponse?.let {
            viewModel.title.value = it.assetName
            viewModel.data.value = it
        }

    }

    fun clickBack() {
        Navigation.findNavController(requireView()).popBackStack()
    }
}