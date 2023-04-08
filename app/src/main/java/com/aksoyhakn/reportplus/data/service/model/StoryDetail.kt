package com.aksoyhakn.reportplus.data.service.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoryDetail(
    @SerializedName("reel")
    val reel: Reel? = null,
    @SerializedName("status")
    val status: String? = ""
) : Parcelable

@Parcelize
data class Reel(
    @SerializedName("media_count")
    val mediaCount: Int? = 0,
    @SerializedName("seen")
    val seen: Long? = 0,
    @SerializedName("expiring_at")
    val expiringAt: Long? = 0,
    @SerializedName("can_reply")
    val canReply: Boolean? = false,
    @SerializedName("prefetch_count")
    val prefetchCount: Int? = 0,
    @SerializedName("has_pride_media")
    val hasPrideMedia: Boolean? = false,
    @SerializedName("id")
    val id: Long? = 0,
    @SerializedName("latest_reel_media")
    val latestReelMedia: Long? = 0,
    @SerializedName("has_besties_media")
    val hasBestiesMedia: Boolean? = false,
    @SerializedName("can_reshare")
    val canReshare: Boolean? = false,
    @SerializedName("reel_type")
    val reelType: String? = "",
    @SerializedName("user")
    val user: User? = null,
    @SerializedName("items")
    val items: List<ItemsItem>? = null
) : Parcelable