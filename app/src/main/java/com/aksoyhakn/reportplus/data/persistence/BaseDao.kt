package com.aksoyhakn.reportplus.data.persistence

import androidx.room.*
import com.aksoyhakn.reportplus.data.persistence.entity.Data
import com.aksoyhakn.reportplus.data.persistence.entity.DataFollowUser

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

@Dao
interface BaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: Data)

    @Update
    fun updateUser(user: Data)

    @Delete
    fun deleteUser(user: Data)

    @Query("DELETE FROM Data")
    fun deleteAllUsers()

    @Query("SELECT * FROM Data WHERE data == :name")
    fun getUserByName(name: String): List<Data>

    @Query("SELECT * FROM Data")
    fun getUsers(): List<Data>


    //Follow
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFollowUser(user: DataFollowUser)

    @Query("DELETE FROM DataFollowUser")
    fun deleteAllFollowUsers()

    @Query("SELECT * FROM DataFollowUser")
    fun getAllFollowUser(): List<DataFollowUser>
    //Follow

}