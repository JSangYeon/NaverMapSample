package jsy.test.navermapsample.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import jsy.test.navermapsample.model.api.EVSCApi
import jsy.test.navermapsample.model.api.NaverDirectApi
import jsy.test.navermapsample.util.network.ApiConfig
import jsy.test.navermapsample.util.network.RetrofitClient
import javax.inject.Singleton


@Module
@InstallIn(ActivityComponent::class)
object RetrofitModule {
    @Singleton
    @Provides
    fun getEVSCRepository(): EVSCApi {
        val retrofit = RetrofitClient.retrofit(ApiConfig.PUBLIC_DATA_API_URL)
        return retrofit.create(EVSCApi::class.java)
    }

    @Singleton
    @Provides
    fun getNaverDirectRepository(): NaverDirectApi {
        val retrofit = RetrofitClient.retrofit(ApiConfig.NAVER_DIRECT5_URL)
        return retrofit.create(NaverDirectApi::class.java)
    }
}
