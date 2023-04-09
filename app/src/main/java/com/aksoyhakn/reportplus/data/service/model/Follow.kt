package com.aksoyhakn.reportplus.data.service.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Follow(
    @SerializedName("users") val users: ArrayList<User>? = null
) : Parcelable