package com.aksoyhakn.reportplus.ui.main.indicator

import androidx.fragment.app.viewModels
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.fragment.BaseFragment
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.databinding.FragmentIndicatorBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


@AndroidEntryPoint
class IndicatorFragment :
    BaseFragment<FragmentIndicatorBinding>(R.layout.fragment_indicator) {

    private val viewModel by viewModels<IndicatorViewModel>()

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.viewModel = viewModel
    }

}