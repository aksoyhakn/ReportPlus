package com.aksoyhakn.reportplus.ui.main.main

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.data.service.model.CurrentUser
import com.aksoyhakn.reportplus.data.service.model.User
import com.aksoyhakn.reportplus.data.service.util.State
import com.aksoyhakn.reportplus.extensions.notNull
import com.aksoyhakn.reportplus.extensions.toString
import com.aksoyhakn.reportplus.ui.main.MainRepository
import com.aksoyhakn.reportplus.utils.SingleLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel() {

    var freeItemList = arrayListOf<MenuItem>()
    var preeItemList = arrayListOf<MenuItem>()

    var userData = ObservableField<User>()

    fun getCurrentUser() {
        viewModelScope.launch {
            mainRepository.getCurrentUser().collect {
                when (it) {
                    is State.Loading -> {
                        toogleFragmentLoading(true)
                    }
                    is State.Success -> {
                        toogleFragmentLoading(false)

                        userData.set(it.data.body()?.user)

                        //getFollow(it.data.body()?.user?.pk)
                        //getFollowing(it.data.body()?.user?.pk)
                        getUserInfo(it.data.body()?.user?.pk)

                    }
                }
            }
        }
    }

    private fun getFollow(userId: Long?) {
        viewModelScope.launch {
            mainRepository.getFollowers(userId ?: 0L).collect {
                when (it) {
                    is State.Success -> {
                        Log.d("Hakan - getFollow ", it.data.body()?.users?.size.toString())
                        it.data.body()?.users?.let{
                            mainRepository.insertFollowUser(it)
                        }
                    }
                }
            }
        }
    }

    private fun getFollowing(userId: Long?) {
        viewModelScope.launch {
            mainRepository.getFollowing(userId ?: 0L).collect {
                when (it) {
                    is State.Success -> {
                        Log.d("Hakan - getFollowing ", it.data.body()?.users?.size.toString())
                        it.data.body()?.users?.let{
                            mainRepository.insertFollowUser(it)
                        }
                    }
                }
            }
        }
    }

    private fun getUserInfo(userId: Long?) {
        viewModelScope.launch {
            mainRepository.getUserInfo(userId ?: 0L).collect {
                when (it) {
                    is State.Success -> {
                    }
                }
            }
        }
    }

}