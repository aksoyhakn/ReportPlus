package com.aksoyhakn.reportplus.data.service.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class HightLight(
    @SerializedName("tray") val tray: ArrayList<HightLightItem>? = null,
    @SerializedName("stories_viewer_gestures_nux_eligible") val storiesViewerGesturesNuxEligible: Boolean = false,
    @SerializedName("sticker_version") val stickerVersion: Int? = 0,
    @SerializedName("face_filter_nux_version") val faceFilterNuxVersion: Int? = 0,
    @SerializedName("story_ranking_token") val storyRankingToken: String? = "",
    @SerializedName("has_new_nux_story") val hasNewNuxStory: Boolean? = false,
    @SerializedName("status") val status: String? = ""
) : Parcelable

@Parcelize
data class HightLightItem(
    @SerializedName("media_count") val mediaCount: Int? = 0,
    @SerializedName("media_ids") val mediaIds: List<Long?>?,
    @SerializedName("hide_from_feed_unit") val hideFromFeedUnit: Boolean? = false,
    @SerializedName("seen") val seen: Long? = 0,
    @SerializedName("expiring_at") val expiringAt: Long? = 0,
    @SerializedName("can_reply") val canReply: Boolean? = false,
    @SerializedName("ranked_position") val rankedPosition: Int? = 0,
    @SerializedName("prefetch_count") val prefetchCount: Int? = 0,
    @SerializedName("has_pride_media") val hasPrideMedia: Boolean? = false,
    @SerializedName("id") val id: String? = "",
    @SerializedName("latest_reel_media") val latestReelMedia: Long? = 0,
    @SerializedName("has_besties_media") val hasBestiesMedia: Boolean? = false,
    @SerializedName("can_reshare") val canReshare: Boolean? = false,
    @SerializedName("reel_type") val reelType: String? = "",
    @SerializedName("user") val user: User?,
    @SerializedName("muted") val muted: Boolean? = false,
    @SerializedName("items") val items: List<ItemsItem>? = null,
    @SerializedName("seen_ranked_position") val seenRankedPosition: Int? = 0,
    var isLoaded: Boolean = false,
    @SerializedName("cover_media") val coverMedia: CoverMedia? = null,
    @SerializedName("title") val title: String = ""
) : Parcelable



