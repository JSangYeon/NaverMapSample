package jsy.test.navermapsample.model.repository

import com.naver.maps.geometry.LatLng
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import jsy.test.navermapsample.model.data.naver.direct.NaverDirectResponse
import jsy.test.navermapsample.module.RetrofitModule
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NaverDirectRepositoryImpl @Inject constructor() {
    private val logTag = javaClass.simpleName

    fun getNaverDirect(startLatLng: LatLng, goalLatLng: LatLng): Flowable<Response<NaverDirectResponse>> {
        val start = "${startLatLng.longitude},${startLatLng.latitude}"
        val goal = "${goalLatLng.longitude},${goalLatLng.latitude}"
        return RetrofitModule.getNaverDirectRepository().getMapDirection(
            start = start,
            goal = goal
        ).subscribeOn(Schedulers.io())
    }
}