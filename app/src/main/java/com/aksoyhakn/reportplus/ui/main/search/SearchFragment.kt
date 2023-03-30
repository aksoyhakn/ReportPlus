package com.aksoyhakn.reportplus.ui.main.search

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.fragment.BaseFragment
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.databinding.FragmentSearchBinding
import com.aksoyhakn.reportplus.ui.main.search.adapter.SearchAdapter
import com.aksoyhakn.reportplus.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

@AndroidEntryPoint
class SearchFragment :
    BaseFragment<FragmentSearchBinding>(R.layout.fragment_search), SearchAdapter.ListenerSearch {

    private val viewModel by viewModels<SearchViewModel>()

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.viewModel = viewModel
        dataBinding.listener = this
    }

    override fun clickSearch(item: String) {
        val bundle = bundleOf(
            Constants.Download.DOWNLOAD_DATA to item
        )

        Navigation.findNavController(dataBinding.root)
            .navigate(R.id.action_navigation_search_to_download, bundle)
    }

}