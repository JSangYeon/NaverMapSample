package jsy.test.navermapsample.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import jsy.test.navermapsample.util.network.ApiConfig
import jsy.test.navermapsample.util.network.RetrofitClient
import jsy.test.navermapsample.model.api.TestRepository
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object TestRetrofitModule {
    @Singleton
    @Provides
    fun getService(): TestRepository {
        val retrofit = RetrofitClient.retrofit(ApiConfig.API_URL_BASE)
        return retrofit.create(TestRepository::class.java)
    }
}
