package com.example.trendline.ui.main.indicator

import android.content.Intent
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.trendline.R
import com.example.trendline.base.fragment.BaseFragment
import com.example.trendline.base.viewmodel.BaseViewModel
import com.example.trendline.databinding.FragmentIndicatorBinding
import com.example.trendline.ui.main.indicator.adapter.IndicatorAdapter
import com.example.trendline.ui.main.indicator.model.IndicatorResponse
import com.example.trendline.ui.videoPlayer.VideoPlayerActivity
import com.example.trendline.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


@AndroidEntryPoint
class IndicatorFragment :
    BaseFragment<FragmentIndicatorBinding>(R.layout.fragment_indicator),
    IndicatorAdapter.ListenerIndicator {

    private val viewModel by viewModels<IndicatorViewModel>()

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.viewModel = viewModel
        dataBinding.listener = this
    }

    override fun clickIndicator(item: IndicatorResponse) {

        val bundle = bundleOf(
            Constants.Main.INDICATOR_DETAIL to item
        )

        Navigation.findNavController(dataBinding.root)
            .navigate(
                R.id.action_navigation_indicator_to_indicator_detail, bundle
            )
    }

}