package com.aksoyhakn.reportplus.ui.main.profile

import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.fragment.BaseFragment
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.data.service.model.HightLightItem
import com.aksoyhakn.reportplus.data.service.model.Media
import com.aksoyhakn.reportplus.data.service.model.User
import com.aksoyhakn.reportplus.databinding.FragmentProfileBinding
import com.aksoyhakn.reportplus.extensions.handler
import com.aksoyhakn.reportplus.extensions.onScrollToEnd
import com.aksoyhakn.reportplus.extensions.show
import com.aksoyhakn.reportplus.ui.main.profile.adapter.HighLightAdapter
import com.aksoyhakn.reportplus.ui.main.profile.adapter.UserFeedMediaAdapter
import com.aksoyhakn.reportplus.utils.Constants
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProfileFragment :
    BaseFragment<FragmentProfileBinding>(R.layout.fragment_profile),
    HighLightAdapter.ListenerHighLightItem, UserFeedMediaAdapter.ListenerUserFeedMedia {

    private val viewModel by viewModels<ProfileViewModel>()

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    private val profileData: User? by lazy {
        arguments?.getParcelable(Constants.Profile.PROFILE_DATA)
    }


    override fun bindScreen() {
        dataBinding.viewModel = viewModel
        dataBinding.listenerHighlight = this
        dataBinding.listenerUserFeed = this
        dataBinding.fragment = this

        profileData?.let {
            viewModel.userData.set(it)
            viewModel.getHighLight(it.pk)
            viewModel.getUserFeeds(it.pk)
        }

        initObserve()
        initNested()
    }

    fun clickBack() {
        Navigation.findNavController(requireView()).popBackStack()
    }

    private fun initNested() {
        dataBinding.nested.onScrollToEnd {
            if (viewModel.numberResult == 12) {
                viewModel.getUserFeeds(profileData?.pk, viewModel.nextMaxID)
            }
        }
    }

    private fun initObserve() {
        viewModel.hightLightLiveData.observe(this) {
            dataBinding.clRoot.show()
        }
    }

    override fun clickHightLightItem(item: HightLightItem) {}

    override fun clickUserFeed(item: Media) {}

}