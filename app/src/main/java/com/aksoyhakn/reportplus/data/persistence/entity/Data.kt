package com.aksoyhakn.reportplus.data.persistence.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

@Entity
data class Data(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val data: String
)