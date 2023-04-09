package com.aksoyhakn.reportplus.data.persistence.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.aksoyhakn.reportplus.data.service.model.User

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

@Entity
data class Data(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val data: String
)

@Entity
data class DataFollowUser(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val followUser: String
)
