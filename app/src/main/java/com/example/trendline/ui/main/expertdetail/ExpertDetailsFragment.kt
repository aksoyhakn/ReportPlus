package com.example.trendline.ui.main.expertdetail

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import com.example.trendline.R
import com.example.trendline.base.fragment.BaseFragment
import com.example.trendline.base.viewmodel.BaseViewModel
import com.example.trendline.databinding.FragmentExpertDetailsBinding
import com.example.trendline.ui.main.expert.model.UserFollowingListResponse
import com.example.trendline.ui.main.expertdetail.adapter.ExpertDetailAdapter
import com.example.trendline.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


@AndroidEntryPoint
class ExpertDetailsFragment :
    BaseFragment<FragmentExpertDetailsBinding>(R.layout.fragment_expert_details),
    ExpertDetailAdapter.ListenerExpertDetail {

    private val viewModel by viewModels<ExpertDetailsViewModel>()

    private val expertDetail: ArrayList<UserFollowingListResponse>? by lazy {
        arguments?.getParcelableArrayList(Constants.Main.EXPERT_DETAIL_USER_FOLLOW)
    }

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.viewModel = viewModel
        dataBinding.fragment = this
        dataBinding.listener = this

        viewModel.expertDetailList.value = expertDetail

    }

    override fun clickExpertDetail(item: UserFollowingListResponse) {
        val bundle = bundleOf(
            Constants.Main.EXPERT_DETAIL_USER_FOLLOW_DETAIL to item
        )

        findNavController(dataBinding.root)
            .navigate(R.id.action_navigation_expert_detail_to_asset, bundle)

    }

    fun clickBack() {
        findNavController(requireView()).popBackStack()
    }

}