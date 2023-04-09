package com.aksoyhakn.reportplus.ui.main.search

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.data.service.model.User
import com.aksoyhakn.reportplus.data.service.util.State
import com.aksoyhakn.reportplus.extensions.notNull
import com.aksoyhakn.reportplus.ui.main.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel() {

    init {

        Handler(Looper.getMainLooper()).postDelayed({
            getRecentSearch()
        }, 400L)

    }

    var searchList = ObservableField<ArrayList<User>>()

    fun getRecentSearch() {
        viewModelScope.launch {
            mainRepository.getRecentSearch().collect {
                when (it) {
                    is State.Loading -> {
                        toogleFragmentLoading(true)
                    }
                    is State.Success -> {
                        toogleFragmentLoading(false)

                        val userList = arrayListOf<User>()
                        it.data.body()?.recent?.forEach {
                            it.users?.let {
                                userList.add(it)
                            }
                        }

                        searchList.set(userList)
                    }
                    is State.Fail -> {
                        it.baseResponse.friendlyMessage.notNull {}
                    }
                    is State.Error -> {
                        Log.d("A", "A")
                    }
                }
            }
        }
    }

    fun getUserSearch(query : String) {
        viewModelScope.launch {
            mainRepository.getUserSearch(query).collect {
                when (it) {
                    is State.Loading -> {
                        toogleFragmentLoading(true)
                    }
                    is State.Success -> {
                        toogleFragmentLoading(false)
                        searchList.set(it.data.body()?.users)
                    }
                    is State.Fail -> {
                        it.baseResponse.friendlyMessage.notNull {}
                    }
                    is State.Error -> {
                        Log.d("A", "A")
                    }
                }
            }
        }
    }
}