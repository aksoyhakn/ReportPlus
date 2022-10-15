package com.example.tradeonline.ui.main.technicalAnalysisDetail

import android.content.Intent
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.tradeonline.R
import com.example.tradeonline.base.fragment.BaseFragment
import com.example.tradeonline.base.viewmodel.BaseViewModel
import com.example.tradeonline.databinding.FragmentTechnicalAnalysisDetailBinding
import com.example.tradeonline.ui.main.technicalAnalysis.model.TechnicalAnalysisResponse
import com.example.tradeonline.ui.videoPlayer.VideoPlayerActivity
import com.example.tradeonline.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


@AndroidEntryPoint
class TechnicalAnalysisDetailFragment :
    BaseFragment<FragmentTechnicalAnalysisDetailBinding>(R.layout.fragment_technical_analysis_detail) {

    private val viewModel by viewModels<TechnicalAnalysisDetailViewModel>()

    private val technicalAnalysisDetail: TechnicalAnalysisResponse? by lazy {
        arguments?.getParcelable(Constants.Main.TECHNICAL_ANALYSIS_DETAIL)
    }

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.viewModel = viewModel
        dataBinding.fragment = this
        technicalAnalysisDetail?.let {
            viewModel.technicalAnalysisDetail.value = it
        }
    }

    fun clickBack() {
        Navigation.findNavController(requireView()).popBackStack()
    }

    fun clickVideo() {
        val intent = Intent(requireActivity(), VideoPlayerActivity::class.java)
        intent.putExtra(Constants.Main.YOUTUBE_URL, technicalAnalysisDetail?.toolYoutubeUrl)
        startActivity(intent)
    }


}