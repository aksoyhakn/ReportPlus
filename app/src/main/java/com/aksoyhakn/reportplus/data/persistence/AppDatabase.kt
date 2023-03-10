package com.aksoyhakn.reportplus.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aksoyhakn.reportplus.data.persistence.entity.Data

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

@Database(entities = [Data::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun baseDao(): BaseDao
}