package com.aksoyhakn.reportplus.ui.main.download


import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.fragment.BaseFragment
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.data.service.model.User
import com.aksoyhakn.reportplus.databinding.FragmentDownloadBinding
import com.aksoyhakn.reportplus.extensions.downloadImageVideo
import com.aksoyhakn.reportplus.extensions.show
import com.aksoyhakn.reportplus.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

@AndroidEntryPoint
class DownloadFragment : BaseFragment<FragmentDownloadBinding>(R.layout.fragment_download) {

    private val viewModel by viewModels<DownloadViewModel>()

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    private val downloadData: User? by lazy {
        arguments?.getParcelable(Constants.Download.DOWNLOAD_DATA)
    }

    override fun bindScreen() {
        dataBinding.fragment = this
        dataBinding.viewModel = viewModel

        downloadData?.let {
            viewModel.getUserInfo(it.pk)
        }

        initObserve()
    }

    private fun initObserve() {
        viewModel.downloadLiveData.observe(this) {
            dataBinding.rlProfile.show()
            dataBinding.rlDownload.show()
        }
    }

    fun clickBack() {
        Navigation.findNavController(requireView()).popBackStack()
    }

    fun clickDownload() {
        requireActivity().downloadImageVideo(downloadData?.profilePicUrl, downloadData?.fullName)
    }

}