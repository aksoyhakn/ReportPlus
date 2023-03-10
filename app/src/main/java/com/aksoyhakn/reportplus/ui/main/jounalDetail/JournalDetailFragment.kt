package com.aksoyhakn.reportplus.ui.main.jounalDetail

import android.content.Intent
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.fragment.BaseFragment
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.databinding.FragmentJournalDetailBinding
import com.aksoyhakn.reportplus.ui.main.journal.model.JournalResponse
import com.aksoyhakn.reportplus.utils.Constants
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
    }
}