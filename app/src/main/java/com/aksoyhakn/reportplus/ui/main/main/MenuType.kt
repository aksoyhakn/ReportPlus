package com.aksoyhakn.reportplus.ui.main.main

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuItem(
    var menuType: Int,
    var title: String?,
    var count: String?,
    var type: Int? = null
) : Parcelable

enum class FreeMenuType {
    FOLLOWERS, LOST_FOLLOWERS, MY_FANS, UN_FOLLOWES, DO_FOLLOWERS
}

enum class PremiumMenuType {
    WHO_BLOCKED, HAVE_BLOCKED, TOP_COMMENTERS, MOST_LIKED_USERS, GHOST_USERS
}