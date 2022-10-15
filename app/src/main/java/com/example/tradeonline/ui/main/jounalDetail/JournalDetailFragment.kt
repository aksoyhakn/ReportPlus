package com.example.tradeonline.ui.main.jounalDetail

import android.content.Intent
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.tradeonline.R
import com.example.tradeonline.base.fragment.BaseFragment
import com.example.tradeonline.base.viewmodel.BaseViewModel
import com.example.tradeonline.databinding.FragmentJournalDetailBinding
import com.example.tradeonline.ui.main.journal.model.JournalResponse
import com.example.tradeonline.ui.videoPlayer.VideoPlayerActivity
import com.example.tradeonline.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


@AndroidEntryPoint
class JournalDetailFragment :
    BaseFragment<FragmentJournalDetailBinding>(R.layout.fragment_journal_detail) {

    private val viewModel by viewModels<JournalDetailViewModel>()

    private val journalDetail: JournalResponse? by lazy {
        arguments?.getParcelable(Constants.Main.JOURNAL_DETAIL)
    }

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.viewModel = viewModel
        dataBinding.fragment = this

        journalDetail?.let {
            viewModel.journalDetail.value = it
        }
    }

    fun clickBack() {
        Navigation.findNavController(requireView()).popBackStack()
    }

    fun clickVideo() {
        val intent = Intent(requireActivity(), VideoPlayerActivity::class.java)
        intent.putExtra(Constants.Main.YOUTUBE_URL, journalDetail?.videoUrl)
        startActivity(intent)
    }
}