package com.aksoyhakn.reportplus.ui.main.download


import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.fragment.BaseFragment
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.databinding.FragmentDownloadBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

@AndroidEntryPoint
class DownloadFragment : BaseFragment<FragmentDownloadBinding>(R.layout.fragment_download) {

    private val viewModel by viewModels<DownloadViewModel>()

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.fragment = this
        dataBinding.viewModel = viewModel
    }

    fun clickBack() {
        Navigation.findNavController(requireView()).popBackStack()
    }

}