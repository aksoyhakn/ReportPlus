package com.aksoyhakn.reportplus.data.service.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

@Parcelize
open class BaseResponse(
    @SerializedName("processStatus") val processStatus: String = "Error",
    @SerializedName("friendlyMessage") var friendlyMessage: FriendlyMessage? = null
) : Parcelable {
    val isSuccess: Boolean
        get() = (processStatus == "Success")
    val isBadRequest: Boolean
        get() = (processStatus == "BadRequest")
    val isNotFound: Boolean
        get() = (processStatus == "NotFound")
    val isError: Boolean
        get() = (processStatus == "Error")
}