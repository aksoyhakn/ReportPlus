package com.aksoyhakn.reportplus.ui.main.search

import android.os.Handler
import android.os.Looper
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.fragment.BaseFragment
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.data.service.model.User
import com.aksoyhakn.reportplus.databinding.FragmentSearchBinding
import com.aksoyhakn.reportplus.extensions.afterTextChanged
import com.aksoyhakn.reportplus.extensions.toString
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

    private val typingDuration: Handler = Handler(Looper.getMainLooper())

    override fun bindScreen() {
        dataBinding.viewModel = viewModel
        dataBinding.listener = this

        initSearch()
    }

    private fun initSearch() {
        dataBinding.edtSearch.afterTextChanged {
            if (it.toString().isNotEmpty()) {

                typingDuration.removeCallbacksAndMessages(null)
                typingDuration.postDelayed({
                    if (it.toString().isNotEmpty()) {
                        viewModel.getUserSearch(it.toString())
                    } else {
                        viewModel.getRecentSearch()
                    }
                }, 500L)

            }
        }
    }

    override fun clickSearch(item: User) {
        val bundle = bundleOf(
            Constants.Download.DOWNLOAD_DATA to item
        )

        Navigation.findNavController(dataBinding.root)
            .navigate(R.id.action_navigation_search_to_download, bundle)
    }

}