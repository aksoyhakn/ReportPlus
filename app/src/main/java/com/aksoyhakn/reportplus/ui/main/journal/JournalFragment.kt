package com.aksoyhakn.reportplus.ui.main.journal

import androidx.fragment.app.viewModels
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.fragment.BaseFragment
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.databinding.FragmentJournalBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

@AndroidEntryPoint
class JournalFragment :
    BaseFragment<FragmentJournalBinding>(R.layout.fragment_journal) {

    private val viewModel by viewModels<JournalViewModel>()

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.viewModel = viewModel
    }

}