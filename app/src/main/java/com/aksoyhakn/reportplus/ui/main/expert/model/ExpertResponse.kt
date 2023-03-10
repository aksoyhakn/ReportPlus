package com.aksoyhakn.reportplus.ui.main.expert.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


@Parcelize
data class ExpertResponse(
    var id: String? = null,
    var userCreateDate: String? = null,
    var userFollowList: ArrayList<UserFollowingListResponse>? = null,
    var userName: String? = null,
    var userPhoto: String? = null
) : Parcelable

@Parcelize
data class UserFollowingListResponse(
    var assetCode: String? = null,
    var assetName: String? = null,
    var dailyTrackingValue: String? = null,
    var direction: String? = null,
    var explanation: String? = null,
    var id: String? = null,
    var pivotPrice: String? = null,
    var stopLossPrice: String? = null,
    var targetPrice: String? = null,
    var weeklyTrackingValue: String? = null,
    var youtubeId: String? = null
) : Parcelable{
    fun getImageURL(): String {
        return "https://img.youtube.com/vi/${youtubeId}/hqdefault.jpg"
    }
}
