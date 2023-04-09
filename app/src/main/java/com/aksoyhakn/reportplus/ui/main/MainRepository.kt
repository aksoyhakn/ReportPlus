package com.aksoyhakn.reportplus.ui.main

import com.aksoyhakn.reportplus.data.persistence.entity.DataFollowUser
import com.aksoyhakn.reportplus.data.service.ReportPlusDataSource
import com.aksoyhakn.reportplus.data.service.model.*
import com.aksoyhakn.reportplus.data.service.util.NetworkBoundRepository
import com.aksoyhakn.reportplus.data.service.util.State
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(
    private val reportPlusDataSource: ReportPlusDataSource
) {

    //Remote Database

    fun getCurrentUser(): Flow<State<CurrentUser>> {
        return object : NetworkBoundRepository<CurrentUser, CurrentUser>() {
            override suspend fun fetchFromRemote(): Response<CurrentUser> =
                reportPlusDataSource.getCurrentUser()
        }.asFlow()
    }

    fun getHomeStories(): Flow<State<HomeStory>> {
        return object : NetworkBoundRepository<HomeStory, HomeStory>() {
            override suspend fun fetchFromRemote(): Response<HomeStory> =
                reportPlusDataSource.getHomeStories()
        }.asFlow()
    }

    fun getFollowers(userID: Long): Flow<State<Follow>> {
        return object : NetworkBoundRepository<Follow, Follow>() {
            override suspend fun fetchFromRemote(): Response<Follow> =
                reportPlusDataSource.getFollowers(userID)
        }.asFlow()
    }

    fun getFollowing(userID: Long): Flow<State<Follow>> {
        return object : NetworkBoundRepository<Follow, Follow>() {
            override suspend fun fetchFromRemote(): Response<Follow> =
                reportPlusDataSource.getFollowing(userID)
        }.asFlow()
    }

    fun getUserStories(userID: Long): Flow<State<StoryDetail>> {
        return object : NetworkBoundRepository<StoryDetail, StoryDetail>() {
            override suspend fun fetchFromRemote(): Response<StoryDetail> =
                reportPlusDataSource.getUserStories(userID)
        }.asFlow()
    }

    fun getStoryViewers(storyPk: Long, maxId: String): Flow<State<Follow>> {
        return object : NetworkBoundRepository<Follow, Follow>() {
            override suspend fun fetchFromRemote(): Response<Follow> =
                reportPlusDataSource.getStoryViewers(storyPk, maxId)
        }.asFlow()
    }

    fun getUserSearch(query: String): Flow<State<Follow>> {
        return object : NetworkBoundRepository<Follow, Follow>() {
            override suspend fun fetchFromRemote(): Response<Follow> =
                reportPlusDataSource.getUserSearch(query)
        }.asFlow()
    }

    fun getRecentSearch(): Flow<State<RecentSearch>> {
        return object : NetworkBoundRepository<RecentSearch, RecentSearch>() {
            override suspend fun fetchFromRemote(): Response<RecentSearch> =
                reportPlusDataSource.getRecentSearch()
        }.asFlow()
    }

    fun getUserInfo(storyPk: Long): Flow<State<CurrentUser>> {
        return object : NetworkBoundRepository<CurrentUser, CurrentUser>() {
            override suspend fun fetchFromRemote(): Response<CurrentUser> =
                reportPlusDataSource.getUserInfo(storyPk)
        }.asFlow()
    }

    fun getHighLight(storyPk: Long): Flow<State<HightLight>> {
        return object : NetworkBoundRepository<HightLight, HightLight>() {
            override suspend fun fetchFromRemote(): Response<HightLight> =
                reportPlusDataSource.getHighLight(storyPk)
        }.asFlow()
    }
    //Remote Database


    //Local Database
    fun insertFollowUser(item: ArrayList<User>) {
        CoroutineScope(Dispatchers.IO).launch {
            item.forEach {
                reportPlusDataSource.baseDao.baseDao().insertFollowUser(DataFollowUser(followUser = item.toString()))
            }
        }
    }

    fun getFollowUser(): ArrayList<String> {
        val user = arrayListOf<String>()
        CoroutineScope(Dispatchers.IO).launch {
            reportPlusDataSource.baseDao.baseDao().getAllFollowUser().forEach { item ->
                user.add(item.followUser)
            }
        }
        return user
    }
    //Local Database

}