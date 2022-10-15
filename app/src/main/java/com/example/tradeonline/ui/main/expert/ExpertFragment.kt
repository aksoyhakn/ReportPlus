package com.example.tradeonline.ui.main.expert

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.tradeonline.R
import com.example.tradeonline.base.fragment.BaseFragment
import com.example.tradeonline.base.viewmodel.BaseViewModel
import com.example.tradeonline.databinding.FragmentExpertBinding
import com.example.tradeonline.ui.main.expert.adapter.ExpertAdapter
import com.example.tradeonline.ui.main.expert.model.ExpertResponse
import com.example.tradeonline.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


@AndroidEntryPoint
class ExpertFragment : BaseFragment<FragmentExpertBinding>(R.layout.fragment_expert),
    ExpertAdapter.ListenerExpert {

    private val viewModel by viewModels<ExpertViewModel>()

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.viewModel = viewModel
        dataBinding.listener = this
    }

    override fun clickExpert(item: ExpertResponse) {
        val bundle = bundleOf(
            Constants.Main.EXPERT_DETAIL_USER_FOLLOW to item.userFollowList
        )

        Navigation.findNavController(dataBinding.root)
            .navigate(R.id.action_navigation_expert_to_expertDetail, bundle)

    }
}