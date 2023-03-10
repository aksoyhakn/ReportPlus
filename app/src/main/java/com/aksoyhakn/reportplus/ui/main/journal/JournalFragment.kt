package com.aksoyhakn.reportplus.ui.main.journal

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.fragment.BaseFragment
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.databinding.FragmentJournalBinding
import com.aksoyhakn.reportplus.ui.main.journal.adapter.JournalAdapter
import com.aksoyhakn.reportplus.ui.main.journal.model.JournalResponse
import com.aksoyhakn.reportplus.utils.Constants
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