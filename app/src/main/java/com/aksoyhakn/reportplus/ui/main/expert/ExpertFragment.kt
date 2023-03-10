package com.aksoyhakn.reportplus.ui.main.expert

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.fragment.BaseFragment
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.databinding.FragmentExpertBinding
import com.aksoyhakn.reportplus.ui.main.expert.adapter.ExpertAdapter
import com.aksoyhakn.reportplus.ui.main.expert.model.ExpertResponse
import com.aksoyhakn.reportplus.utils.Constants
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