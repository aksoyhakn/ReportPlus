package com.example.tradeonline.ui.main.asset

import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.tradeonline.R
import com.example.tradeonline.base.fragment.BaseFragment
import com.example.tradeonline.base.viewmodel.BaseViewModel
import com.example.tradeonline.databinding.FragmentAssetBinding
import com.example.tradeonline.ui.main.expert.model.UserFollowingListResponse
import com.example.tradeonline.utils.Constants
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