package com.aksoyhakn.reportplus.ui.main.download

import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.data.service.model.HightLight
import com.aksoyhakn.reportplus.data.service.model.User
import com.aksoyhakn.reportplus.data.service.util.State
import com.aksoyhakn.reportplus.ui.main.MainRepository
import com.aksoyhakn.reportplus.utils.SingleLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DownloadViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel() {

    var downloadUrl = ObservableField<String>()
    var downloadLiveData = SingleLiveData<Boolean>()

    fun getUserInfo(userId: Long?) {
        viewModelScope.launch {
            mainRepository.getUserInfo(userId ?: 0L).collect {
                when (it) {
                    is State.Loading ->{
                        toogleFragmentLoading(true)
                    }
                    is State.Success -> {
                        toogleFragmentLoading(false)
                        downloadUrl.set(it.data.body()?.user?.hdProfile?.url)
                        downloadLiveData.value = true
                    }
                }
            }
        }
    }
}