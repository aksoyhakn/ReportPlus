package com.aksoyhakn.reportplus.ui.main.indicatorDetails

import android.content.Intent
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.fragment.BaseFragment
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.databinding.FragmentIndicatorDetailBinding
import com.aksoyhakn.reportplus.ui.main.indicator.model.IndicatorResponse
import com.aksoyhakn.reportplus.ui.main.indicator.model.IndicatorYoutubeResponse
import com.aksoyhakn.reportplus.ui.main.indicatorDetails.adapter.IndicatorDetailAdapter
import com.aksoyhakn.reportplus.utils.Constants
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class IndicatorDetail :
    BaseFragment<FragmentIndicatorDetailBinding>(R.layout.fragment_indicator_detail),IndicatorDetailAdapter.ListenerIndicatorDetail {

    private val viewModel by viewModels<IndicatorDetailViewModel>()

    private val indicatorDetailResponse: IndicatorResponse? by lazy {
        arguments?.getParcelable(Constants.Main.INDICATOR_DETAIL)
    }

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.viewModel = viewModel
        dataBinding.fragment = this
        dataBinding.listener = this
        indicatorDetailResponse?.let {
            viewModel.indicatorDetailResponse.value = it
        }
    }

    fun clickBack() {
        Navigation.findNavController(requireView()).popBackStack()
    }

    override fun clickIndicatorDetail(item: IndicatorYoutubeResponse) {

    }


}