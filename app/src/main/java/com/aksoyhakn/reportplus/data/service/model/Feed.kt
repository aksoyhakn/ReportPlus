package com.aksoyhakn.reportplus.data.service.model

import com.google.gson.annotations.SerializedName

data class Feed(
    @SerializedName("items") var items: List<Media>?,
    @SerializedName("num_results") var numResults: Int,
    @SerializedName("more_available") var moreAvailable: Boolean,
    @SerializedName("auto_load_more_enabled") var autoLoadMoreEnabled: Boolean,
    @SerializedName("next_max_id") var nextMaxId: String,
    @SerializedName("status") var status: String
)
