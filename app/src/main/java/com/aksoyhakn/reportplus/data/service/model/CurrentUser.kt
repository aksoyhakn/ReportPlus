package com.aksoyhakn.reportplus.data.service.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrentUser(
    @SerializedName("user") val user: User?,
    @SerializedName("status") val status: String? = ""
) : Parcelable



