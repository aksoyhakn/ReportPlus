package com.aksoyhakn.reportplus.data.service.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchUser(
    @SerializedName("users")
    val users: List<User>? = null,
    @SerializedName("status")
    val status: String? = ""
) : Parcelable



