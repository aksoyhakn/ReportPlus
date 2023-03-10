package com.aksoyhakn.reportplus.ui.main.indicator.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

@Parcelize
data class IndicatorResponse(
    var id: String? = null,
    var indicatorCreateDate: String? = null,
    var indicatorName: String? = null,
    var shortDescription: String? = null,
    var youtubeIds: ArrayList<IndicatorYoutubeResponse>? = null
) : Parcelable {
    fun getImageURL(): String {
        return "https://img.youtube.com/vi/${youtubeIds?.get(0)?.youtubeUrl}/hqdefault.jpg"
    }
}

@Parcelize
data class IndicatorYoutubeResponse(
    var description: String? = null,
    var id: String? = null,
    var youtubeUrl: String? = null,
) : Parcelable{
    fun getImageURL(): String {
        return "https://img.youtube.com/vi/${youtubeUrl}/hqdefault.jpg"
    }
}