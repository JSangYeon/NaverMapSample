package jsy.test.navermapsample.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import jsy.test.navermapsample.model.database.DatabaseConfig.DATABASE_VERSION
import jsy.test.navermapsample.model.database.dao.RouteHistoryDao
import jsy.test.navermapsample.model.database.entity.RouteHistory


@Database(entities = [RouteHistory::class], version = DATABASE_VERSION, exportSchema = false)
@TypeConverters(DataListConverters::class)
abstract class MaasDatabase : RoomDatabase() {
    abstract fun routeHistoryDao(): RouteHistoryDao
}