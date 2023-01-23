package jsy.test.navermapsample.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import jsy.test.navermapsample.model.api.EVSCRepository
import jsy.test.navermapsample.model.api.NaverDirectRepository
import jsy.test.navermapsample.util.network.ApiConfig
import jsy.test.navermapsample.util.network.RetrofitClient
import javax.inject.Singleton


@Module
@InstallIn(ActivityComponent::class)
object RetrofitModule {
    @Singleton
    @Provides
    fun getEVSCRepository(): EVSCRepository {
        val retrofit = RetrofitClient.retrofit(ApiConfig.PUBLIC_DATA_API_URL)
        return retrofit.create(EVSCRepository::class.java)
    }

    @Singleton
    @Provides
    fun getNaverDirectRepository(): NaverDirectRepository {
        val retrofit = RetrofitClient.retrofit(ApiConfig.NAVER_DIRECT5_URL)
        return retrofit.create(NaverDirectRepository::class.java)
    }
}
