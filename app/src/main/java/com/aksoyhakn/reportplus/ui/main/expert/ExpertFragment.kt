package com.aksoyhakn.reportplus.ui.main.expert

import androidx.fragment.app.viewModels
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.fragment.BaseFragment
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.databinding.FragmentExpertBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


@AndroidEntryPoint
class ExpertFragment : BaseFragment<FragmentExpertBinding>(R.layout.fragment_expert) {

    private val viewModel by viewModels<ExpertViewModel>()

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.viewModel = viewModel
    }
}