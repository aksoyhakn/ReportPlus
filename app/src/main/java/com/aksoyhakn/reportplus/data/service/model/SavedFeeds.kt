package com.aksoyhakn.reportplus.data.service.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class SavedFeeds(
    @SerializedName("items") var items: List<Items>?,
    @SerializedName("num_results") var numResults: Int,
    @SerializedName("more_available") var moreAvailable: Boolean,
    @SerializedName("auto_load_more_enabled") var autoLoadMoreEnabled: Boolean,
    @SerializedName("next_max_id") var nextMaxId: String,
    @SerializedName("status") var status: String

)

data class Items(
    @SerializedName("media") var media: Media
)

@Parcelize
data class Media(

    @SerializedName("taken_at") var takenAt: Long?,
    @SerializedName("pk") var pk: Long?,
    @SerializedName("id") var id: String?,
    @SerializedName("device_timestamp") var deviceTimestamp: Long?,
    @SerializedName("media_type") var mediaType: Int?,
    @SerializedName("code") var code: String?,
    @SerializedName("client_cache_key") var clientCacheKey: String?,
    @SerializedName("filter_type") var filterType: Int?,
    @SerializedName("carousel_media_count") var carouselMediaCount: Int?,
    @SerializedName("carousel_media") var carouselMedia: List<CarouselMedia>?,
    @SerializedName("can_see_insights_as_brand") var canSeeInsightsAsBrand: Boolean?,
    @SerializedName("location") var location: Location?,
    @SerializedName("lat") var lat: Double?,
    @SerializedName("lng") var lng: Double?,
    @SerializedName("user") var user: User?,
    @SerializedName("can_viewer_reshare") var canViewerReshare: Boolean?,
    @SerializedName("caption_is_edited") var captionIsEdited: Boolean?,
    @SerializedName("comment_likes_enabled") var commentLikesEnabled: Boolean?,
    @SerializedName("comment_threading_enabled") var commentThreadingEnabled: Boolean?,
    @SerializedName("has_more_comments") var hasMoreComments: Boolean?,
    @SerializedName("next_max_id") var nextMaxId: Long?,
    @SerializedName("max_num_visible_preview_comments") var maxNumVisiblePreviewComments: Int?,
    @SerializedName("can_view_more_preview_comments") var canViewMorePreviewComments: Boolean?,
    @SerializedName("comment_count") var commentCount: Int?,
    @SerializedName("inline_composer_display_condition") var inlineComposerDisplayCondition: String?,
    @SerializedName("inline_composer_imp_trigger_time") var inlineComposerImpTriggerTime: Int?,
    @SerializedName("like_count") var likeCount: Int?,
    @SerializedName("has_liked") var hasLiked: Boolean?,
    @SerializedName("like_and_view_counts_disabled") var likeAndViewCountsDisabled: Boolean?,
    @SerializedName("photo_of_you") var photoOfYou: Boolean?,
    @SerializedName("can_viewer_save") var canViewerSave: Boolean?,
    @SerializedName("has_viewer_saved") var hasViewerSaved: Boolean?,
    @SerializedName("saved_collection_ids") var savedCollectionIds: List<String>?,
    @SerializedName("organic_tracking_token") var organicTrackingToken: String?,
    @SerializedName("is_in_profile_grid") var isInProfileGrid: Boolean?,
    @SerializedName("profile_grid_control_enabled") var profileGridControlEnabled: Boolean?,
    @SerializedName("is_shop_the_look_eligible") var isShopTheLookEligible: Boolean?,
    @SerializedName("deleted_reason") var deletedReason: Int?,
    @SerializedName("integrity_review_decision") var integrityReviewDecision: String?,
    @SerializedName("image_versions2") var imageVersions2: ImageVersions?,
    @SerializedName("video_versions") val videoVersions: List<VideoVersionsItem>?,
    @SerializedName("original_width") var originalWidth: Int?,
    @SerializedName("original_height") var originalHeight: Int?,
    @SerializedName("is_dash_eligible") var isDashEligible: Int?,
    @SerializedName("video_dash_manifest") var videoDashManifest: String?,
    @SerializedName("video_codec") var videoCodec: String?,
    @SerializedName("number_of_qualities") var numberOfQualities: Int?,
    @SerializedName("has_audio") var hasAudio: Boolean?,
    @SerializedName("video_duration") var videoDuration: Double?,
    @SerializedName("view_count") var viewCount: Int?,
    @SerializedName("play_count") var playCount: Int?,
    @SerializedName("product_type") var productType: String?

) : Parcelable

@Parcelize
data class Location(
    @SerializedName("pk") var pk: Long?,
    @SerializedName("short_name") var shortName: String?,
    @SerializedName("facebook_places_id") var facebookPlacesId: Long?,
    @SerializedName("external_source") var externalSource: String?,
    @SerializedName("name") var name: String?,
    @SerializedName("address") var address: String?,
    @SerializedName("city") var city: String?,
    @SerializedName("lng") var lng: Double?,
    @SerializedName("lat") var lat: Double?

) : Parcelable

@Parcelize
data class CarouselMedia(
    @SerializedName("id") var id: String?,
    @SerializedName("media_type") var mediaType: Int?,
    @SerializedName("image_versions2") var imageVersions2: ImageVersions?,
    @SerializedName("video_versions") val videoVersions: List<VideoVersionsItem>?,
    @SerializedName("original_width") var originalWidth: Int?,
    @SerializedName("original_height") var originalHeight: Int?,
    @SerializedName("pk") var pk: Long?,
    @SerializedName("carousel_parent_id") var carouselParentId: String?,
    @SerializedName("can_see_insights_as_brand") var canSeeInsightsAsBrand: Boolean?
) : Parcelable
