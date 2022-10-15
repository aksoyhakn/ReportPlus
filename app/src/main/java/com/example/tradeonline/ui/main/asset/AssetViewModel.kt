package com.example.tradeonline.ui.main.asset

import androidx.lifecycle.MutableLiveData
import com.example.tradeonline.base.viewmodel.BaseViewModel
import com.example.tradeonline.ui.main.expert.model.UserFollowingListResponse

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


class AssetViewModel : BaseViewModel() {

    val title = MutableLiveData<String>()
    val data = MutableLiveData<UserFollowingListResponse>()

}