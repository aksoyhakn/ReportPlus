package com.aksoyhakn.reportplus.utils.notification

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

@Parcelize
data class BaseNotification(
    @SerializedName("body") @Expose val body: String?,
    @SerializedName("title") @Expose val title: String?,
    @SerializedName("type") @Expose val type: String?,
    @SerializedName("link") @Expose val link: String?,
    @SerializedName("button_1") @Expose val button1: String?,
    @SerializedName("button_1_url") @Expose val button1Url: String?,
    @SerializedName("button_2") @Expose val button2: String?,
    @SerializedName("button_2_url") @Expose val button2Url: String?,
    @SerializedName("big_image_url") @Expose val bigImageUrl: String?
) : Parcelable