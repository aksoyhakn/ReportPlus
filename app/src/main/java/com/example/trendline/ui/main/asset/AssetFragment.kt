package com.example.trendline.ui.main.asset

import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.trendline.R
import com.example.trendline.base.fragment.BaseFragment
import com.example.trendline.base.viewmodel.BaseViewModel
import com.example.trendline.databinding.FragmentAssetBinding
import com.example.trendline.ui.main.expert.model.UserFollowingListResponse
import com.example.trendline.utils.Constants
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