package com.example.tradeonline.ui.main.journal

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.tradeonline.R
import com.example.tradeonline.base.fragment.BaseFragment
import com.example.tradeonline.base.viewmodel.BaseViewModel
import com.example.tradeonline.databinding.FragmentJournalBinding
import com.example.tradeonline.ui.main.journal.adapter.JournalAdapter
import com.example.tradeonline.ui.main.journal.model.JournalResponse
import com.example.tradeonline.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

@AndroidEntryPoint
class JournalFragment :
    BaseFragment<FragmentJournalBinding>(R.layout.fragment_journal),
    JournalAdapter.ListenerJournal {

    private val viewModel by viewModels<JournalViewModel>()

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.viewModel = viewModel
        dataBinding.listener = this
    }

    override fun clickJournal(item: JournalResponse) {
        val bundle = bundleOf(
            Constants.Main.JOURNAL_DETAIL to item
        )
        Navigation.findNavController(dataBinding.root)
            .navigate(R.id.action_navigation_journal_to_journal_detail, bundle)
    }

}