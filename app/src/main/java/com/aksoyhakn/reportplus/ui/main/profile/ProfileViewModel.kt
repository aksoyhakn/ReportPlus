package com.aksoyhakn.reportplus.ui.main.profile

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.data.service.model.HightLight
import com.aksoyhakn.reportplus.data.service.model.HightLightItem
import com.aksoyhakn.reportplus.data.service.model.Media
import com.aksoyhakn.reportplus.data.service.model.User
import com.aksoyhakn.reportplus.data.service.util.State
import com.aksoyhakn.reportplus.extensions.toString
import com.aksoyhakn.reportplus.ui.main.MainRepository
import com.aksoyhakn.reportplus.utils.SingleLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel() {

    var hightLightItem = ObservableField<ArrayList<HightLightItem>>()
    var userFeedItem = ObservableField<ArrayList<Media>>()

    var userData = ObservableField<User>()

    var hightLightLiveData = SingleLiveData<HightLight>()

    fun getHighLight(userId: Long?) {
        viewModelScope.launch {
            mainRepository.getHighLight(userId ?: 0L).collect {
                when (it) {
                    is State.Loading ->{
                        toogleFragmentLoading(true)
                    }
                    is State.Success -> {
                        toogleFragmentLoading(false)
                        Log.d("Hakan - getHighLight ", it.data.body()?.tray?.size.toString())
                        hightLightLiveData.value = it.data.body()
                        it.data.body()?.tray?.takeIf { it.isNotEmpty() }?.apply {
                            hightLightItem.set(this)
                        }
                    }
                }
            }
        }
    }

    var nextMaxID: String? = null
    var numberResult: Int? = null

    fun getUserFeeds(userId: Long?, nextMaxId: String? = null) {
        viewModelScope.launch {
            mainRepository.getUserFeeds(userId ?: 0L,nextMaxId ?: "").collect {
                when (it) {
                    is State.Loading ->{
                        toogleFragmentLoading(true)
                    }
                    is State.Success -> {
                        toogleFragmentLoading(false)
                        Log.d("Hakan - getUserFeeds ", it.data.body()?.items?.size.toString())
                        nextMaxID = it.data.body()?.nextMaxId
                        numberResult = it.data.body()?.numResults
                        it.data.body()?.items?.takeIf { it.isNotEmpty() }?.apply {
                            userFeedItem.set(this)
                        }
                    }
                }
            }
        }
    }
}