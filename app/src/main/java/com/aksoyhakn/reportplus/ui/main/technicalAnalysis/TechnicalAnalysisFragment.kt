package com.aksoyhakn.reportplus.ui.main.technicalAnalysis

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.fragment.BaseFragment
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.databinding.FragmentTechnicalAnalysisBinding
import com.aksoyhakn.reportplus.ui.main.technicalAnalysis.adapter.TechnicalAnalysisAdapter
import com.aksoyhakn.reportplus.ui.main.technicalAnalysis.model.TechnicalAnalysisResponse
import com.aksoyhakn.reportplus.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

@AndroidEntryPoint
class TechnicalAnalysisFragment :
    BaseFragment<FragmentTechnicalAnalysisBinding>(R.layout.fragment_technical_analysis),
    TechnicalAnalysisAdapter.ListenerTechnicalAnalysis {

    private val viewModel by viewModels<TechnicalAnalysisViewModel>()

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.viewModel = viewModel
        dataBinding.listener = this
    }

    override fun clickTechnicalAnalysis(item: TechnicalAnalysisResponse) {
        val bundle = bundleOf(
            Constants.Main.TECHNICAL_ANALYSIS_DETAIL to item
        )
        Navigation.findNavController(dataBinding.root)
            .navigate(
                R.id.action_navigation_technical_analysis_to_technical_analysis_detail, bundle
            )
    }

}