package jsy.test.navermapsample.model.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jsy.test.navermapsample.model.database.DatabaseConfig.DATABASE_NAME
import jsy.test.navermapsample.model.database.dao.RouteHistoryDao
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    fun provideRouteDao(database: MaasDatabase): RouteHistoryDao {
        return database.routeHistoryDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): MaasDatabase {
        return Room.databaseBuilder(
            appContext,
            MaasDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
}