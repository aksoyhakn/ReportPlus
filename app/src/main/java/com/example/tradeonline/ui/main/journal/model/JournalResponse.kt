package com.example.tradeonline.ui.main.journal.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


@Parcelize
data class JournalResponse(
    var id: String? = null,
    var videDescription: String? = null,
    var videoCreateDate: String? = null,
    var videoTitle: String? = null,
    var videoUrl: String? = null
) : Parcelable {

    fun getImageURL(): String {
        return "https://img.youtube.com/vi/${videoUrl}/hqdefault.jpg"
    }

}