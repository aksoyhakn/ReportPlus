package com.aksoyhakn.reportplus.ui.main.expertdetail

import androidx.lifecycle.MutableLiveData
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.ui.main.expert.model.UserFollowingListResponse

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


class ExpertDetailsViewModel : BaseViewModel() {

    val expertDetailList = MutableLiveData<ArrayList<UserFollowingListResponse>>()

}