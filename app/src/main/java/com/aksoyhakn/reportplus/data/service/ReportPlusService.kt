package com.aksoyhakn.reportplus.data.service

import com.aksoyhakn.reportplus.data.service.model.*
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

interface ReportPlusService {

    @Headers("Content-Type: application/json")
    @GET("feed/reels_tray/")
    fun getHomeStories(@HeaderMap headers: Map<String, String>): Response<HomeStory?>

    @GET("accounts/current_user/")
    fun getCurrentUser(@HeaderMap headers: Map<String, String>): Response<CurrentUser?>

    @GET("friendships/autocomplete_user_list")
    fun getSearchUser(@HeaderMap headers: Map<String, String>): Response<Follow?>

    @GET("feed/user/{userID}/story")
    fun getUserStories(
        @HeaderMap headers: Map<String, String>,
        @Path("userID") userID: Long
    ): Response<StoryDetail?>

    @GET("media/{storypk}/list_reel_media_viewer")
    fun getStoryViewers(
        @HeaderMap headers: Map<String, String>,
        @Path("storypk") storypk: Long,
        @Query("max_id") max_id: String
    ): Response<Follow?>

    @GET("users/search")
    fun getUserSearch(
        @HeaderMap headers: Map<String, String>,
        @Query("q") query: String
    ): Response<Follow?>

    @GET("friendships/{userID}/followers")
    fun getFollowers(
        @HeaderMap headers: Map<String, String>,
        @Path("userID") userID: Long
    ): Response<Follow?>

    @GET("friendships/{userID}/following")
    fun getFollowing(
        @HeaderMap headers: Map<String, String>,
        @Path("userID") userID: Long
    ): Response<Follow?>


    @GET("highlights/{userID}/highlights_tray")
    fun getHighLight(
        @HeaderMap headers: Map<String, String>,
        @Path("userID") userID: Long
    ): Response<HightLight?>

    @GET("feed/reels_media/")
    fun getHighLightDetail(
        @HeaderMap headers: Map<String, String>,
        @Query("user_ids") id: String
    ): Response<HighLightDetail?>

    @GET("/api/v1/feed/saved/")
    fun getSavedPosts(
        @HeaderMap headers: Map<String, String>,
        @Query("max_id") max_id: String?,
        @Query("include_igtv_preview") include_igtv_preview: Boolean
    ): Response<SavedFeeds?>

    @GET("feed/user/{id}")
    fun getUserFeeds(
        @HeaderMap headers: Map<String, String>,
        @Path("id") id: Long,
        @Query("max_id") max_id: String?
    ): Response<Feed?>

    @GET("fbsearch/recent_searches/")
    fun getRecentSearch(
        @HeaderMap headers: Map<String, String>,
        @Query("type") type: String
    ): Response<RecentSearch?>

}