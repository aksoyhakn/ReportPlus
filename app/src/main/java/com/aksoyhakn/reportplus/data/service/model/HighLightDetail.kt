package com.aksoyhakn.reportplus.data.service.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class HighLightDetail(
    @SerializedName("reels") val reel: Map<String, HightLightItem>? = null,
    @SerializedName("status") val status: String? = ""
) : Parcelable

