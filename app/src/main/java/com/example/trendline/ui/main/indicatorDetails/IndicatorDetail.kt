package com.example.trendline.ui.main.indicatorDetails

import android.content.Intent
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.trendline.R
import com.example.trendline.base.fragment.BaseFragment
import com.example.trendline.base.viewmodel.BaseViewModel
import com.example.trendline.databinding.FragmentIndicatorDetailBinding
import com.example.trendline.ui.main.indicator.model.IndicatorResponse
import com.example.trendline.ui.main.indicator.model.IndicatorYoutubeResponse
import com.example.trendline.ui.main.indicatorDetails.adapter.IndicatorDetailAdapter
import com.example.trendline.ui.videoPlayer.VideoPlayerActivity
import com.example.trendline.utils.Constants
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
        val intent = Intent(requireActivity(), VideoPlayerActivity::class.java)
        intent.putExtra(Constants.Main.YOUTUBE_URL, item.youtubeUrl)
        startActivity(intent)
    }


}