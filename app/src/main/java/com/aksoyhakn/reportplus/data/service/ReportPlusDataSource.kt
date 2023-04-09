package com.aksoyhakn.reportplus.data.service

import com.aksoyhakn.reportplus.data.persistence.AppDatabase
import com.aksoyhakn.reportplus.data.persistence.entity.DataFollowUser
import com.aksoyhakn.reportplus.data.service.model.*
import com.aksoyhakn.reportplus.utils.CookieInfo
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

class ReportPlusDataSource @Inject constructor(
    val baseDao: AppDatabase,
    private val reportPlusService: ReportPlusService
) {

    suspend fun getCurrentUser(): Response<CurrentUser> =
        reportPlusService.getCurrentUser(
            CookieInfo.getHeaders()
        )

    suspend fun getHomeStories(): Response<HomeStory> =
        reportPlusService.getHomeStories(
            CookieInfo.getHeaders()
        )

    suspend fun getFollowers(userID: Long): Response<Follow> =
        reportPlusService.getFollowers(
            CookieInfo.getHeaders(), userID
        )

    suspend fun getFollowing(userID: Long): Response<Follow> =
        reportPlusService.getFollowing(
            CookieInfo.getHeaders(),
            userID,
        )

    suspend fun getUserStories(userID: Long): Response<StoryDetail> =
        reportPlusService.getUserStories(
            CookieInfo.getHeaders(), userID
        )

    suspend fun getStoryViewers(storyPk: Long, maxID: String): Response<Follow> =
        reportPlusService.getStoryViewers(
            CookieInfo.getHeaders(),
            storyPk,
            maxID
        )

    suspend fun getUserSearch(query: String): Response<Follow> =
        reportPlusService.getUserSearch(
            CookieInfo.getHeaders(),
            query
        )

    suspend fun getHighLight(userID: Long): Response<HightLight> =
        reportPlusService.getHighLight(
            CookieInfo.getHeaders(),
            userID
        )

    suspend fun getHighLightDetail(id: String): Response<HighLightDetail> =
        reportPlusService.getHighLightDetail(
            CookieInfo.getHeaders(),
            id
        )

    suspend fun getSavedPosts(maxID: String?): Response<SavedFeeds> =
        reportPlusService.getSavedPosts(
            CookieInfo.getHeaders(),
            maxID,
            true
        )

    suspend fun getUserFeeds(userID: Long, maxID: String?): Response<Feed> =
        reportPlusService.getUserFeeds(
            CookieInfo.getHeaders(),
            userID,
            maxID
        )


    suspend fun getRecentSearch(): Response<RecentSearch> =
        reportPlusService.getRecentSearch(
            CookieInfo.getHeaders(),
            "users"
        )

    suspend fun getUserInfo(userID: Long): Response<CurrentUser> =
        reportPlusService.getUserInfo(
            CookieInfo.getHeaders(),
            userID
        )

}