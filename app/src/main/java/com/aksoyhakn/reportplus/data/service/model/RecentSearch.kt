package com.aksoyhakn.reportplus.data.service.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecentSearch(
    @SerializedName("recent")
    val users: List<RecentSearchDetail>? = null
) : Parcelable