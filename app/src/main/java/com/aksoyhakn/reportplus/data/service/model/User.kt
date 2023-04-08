package com.aksoyhakn.reportplus.data.service.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    @SerializedName("is_private")
    val isPrivate: Boolean? = false,
    @SerializedName("full_name")
    val fullName: String? = "",
    @SerializedName("is_favorite")
    val isFavorite: Boolean? = false,
    @SerializedName("profile_pic_id")
    val profilePicId: String? = "",
    @SerializedName("can_see_primary_country_in_settings")
    val canSeePrimaryCountryInSettings: Boolean? = false,
    @SerializedName("is_unpublished")
    val isUnpublished: Boolean? = false,
    @SerializedName("pk")
    val pk: Long? = 0,
    @SerializedName("has_anonymous_profile_picture")
    val hasAnonymousProfilePicture: Boolean? = false,
    @SerializedName("profile_pic_url")
    val profilePicUrl: String? = "",
    @SerializedName("is_verified")
    val isVerified: Boolean? = false,
    @SerializedName("username")
    val username: String? = "",
    @SerializedName("friendship_status")
    val friendshipStatus: FriendshipStatus? = null
) : Parcelable

@Parcelize
data class FriendshipStatus(
    @SerializedName("is_private")
    val isPrivate: Boolean? = false,
    @SerializedName("followed_by")
    val followedBy: Boolean? = false,
    @SerializedName("muting")
    val muting: Boolean? = false,
    @SerializedName("incoming_request")
    val incomingRequest: Boolean? = false,
    @SerializedName("blocking")
    val blocking: Boolean? = false,
    @SerializedName("is_restricted")
    val isRestricted: Boolean? = false,
    @SerializedName("following")
    val following: Boolean? = false,
    @SerializedName("outgoing_request")
    val outgoingRequest: Boolean? = false,
    @SerializedName("is_bestie")
    val isBestie: Boolean? = false
) : Parcelable