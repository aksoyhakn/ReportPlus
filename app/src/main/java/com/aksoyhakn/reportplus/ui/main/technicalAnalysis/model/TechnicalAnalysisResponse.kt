package com.aksoyhakn.reportplus.ui.main.technicalAnalysis.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

@Parcelize
data class TechnicalAnalysisResponse(
    var id: String? = null,
    var toolCreateDate: String? = null,
    var toolDescription: String? = null,
    var toolName: String? = null,
    var toolYoutubeUrl: String? = null
) : Parcelable {

    fun getImageURL(): String {
        return "https://img.youtube.com/vi/${toolYoutubeUrl}/hqdefault.jpg"
    }

}