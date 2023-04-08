package com.aksoyhakn.reportplus.data.service.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemsItem(
    @SerializedName("code")
    val code: String? = "",
    @SerializedName("can_send_custom_emojis")
    val canSendCustomEmojis: Boolean? = false,
    @SerializedName("caption")
    val caption: String? = null,
    @SerializedName("has_shared_to_fb")
    val hasSharedToFb: Int? = 0,
    @SerializedName("is_pride_media")
    val isPrideMedia: Boolean? = false,
    @SerializedName("expiring_at")
    val expiringAt: Long? = 0,
    @SerializedName("is_reel_media")
    val isReelMedia: Boolean? = false,
    @SerializedName("media_type")
    val mediaType: Int? = 0,
    @SerializedName("filter_type")
    val filterType: Int? = 0,
    @SerializedName("device_timestamp")
    val deviceTimestamp: Long? = 0,
    @SerializedName("original_height")
    val originalHeight: Int? = 0,
    @SerializedName("supports_reel_reactions")
    val supportsReelReactions: Boolean? = false,
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("caption_position")
    val captionPosition: Int? = 0,
    @SerializedName("original_width")
    val originalWidth: Int? = 0,
    @SerializedName("show_one_tap_fb_share_tooltip")
    val showOneTapFbShareTooltip: Boolean? = false,
    @SerializedName("photo_of_you")
    val photoOfYou: Boolean? = false,
    @SerializedName("timezone_offset")
    val timezoneOffset: Int? = 0,
    @SerializedName("story_is_saved_to_archive")
    val storyIsSavedToArchive: Boolean? = false,
    @SerializedName("organic_tracking_token")
    val organicTrackingToken: String? = "",
    @SerializedName("client_cache_key")
    val clientCacheKey: String? = "",
    @SerializedName("viewers")
    val viewers: List<ViewersItem>? = null,
    @SerializedName("can_reply")
    val canReply: Boolean? = false,
    @SerializedName("taken_at")
    val takenAt: Long? = 0,
    @SerializedName("caption_is_edited")
    val captionIsEdited: Boolean? = false,
    @SerializedName("image_versions2")
    val imageVersions: ImageVersions? = null,
    @SerializedName("video_duration")
    val videoDuration: Double? = 0.0,
    @SerializedName("video_codec")
    val videoCodec: String? = "",
    @SerializedName("video_versions")
    val videoVersions: List<VideoVersionsItem>? = null,
    @SerializedName("total_viewer_count")
    val totalViewerCount: Int? = 0,
    @SerializedName("pk")
    val pk: Long? = 0,
    @SerializedName("can_viewer_save")
    val canViewerSave: Boolean? = false,
    @SerializedName("viewer_count")
    val viewerCount: Int? = 0,
    @SerializedName("can_reshare")
    val canReshare: Boolean? = false,
    @SerializedName("user")
    val user: User?
) : Parcelable

@Parcelize
data class VideoVersionsItem(
    @SerializedName("width")
    val width: Int? = 0,
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("type")
    val type: Int? = 0,
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("height")
    val height: Int? = 0
) : Parcelable

@Parcelize
data class ImageVersions(
    @SerializedName("candidates")
    val candidates: List<CandidatesItem>?
) : Parcelable

@Parcelize
data class CandidatesItem(
    @SerializedName("scans_profile")
    val scansProfile: String? = "",
    @SerializedName("width")
    val width: Int? = 0,
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("height")
    val height: Int? = 0
) : Parcelable

@Parcelize
data class ViewersItem(
    @SerializedName("is_private")
    val isPrivate: Boolean? = false,
    @SerializedName("full_name")
    val fullName: String? = "",
    @SerializedName("profile_pic_id")
    val profilePicId: String? = "",
    @SerializedName("pk")
    val pk: Long? = 0,
    @SerializedName("profile_pic_url")
    val profilePicUrl: String? = "",
    @SerializedName("is_verified")
    val isVerified: Boolean? = false,
    @SerializedName("username")
    val username: String? = ""
) : Parcelable