package com.aksoyhakn.reportplus.ui.main.indicator

import android.content.Intent
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.fragment.BaseFragment
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.databinding.FragmentIndicatorBinding
import com.aksoyhakn.reportplus.ui.main.indicator.adapter.IndicatorAdapter
import com.aksoyhakn.reportplus.ui.main.indicator.model.IndicatorResponse
import com.aksoyhakn.reportplus.utils.Constants
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