package jsy.test.navermapsample.model.repository

import android.util.Log
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import jsy.test.navermapsample.BuildConfig
import jsy.test.navermapsample.model.data.EVCSResponse
import jsy.test.navermapsample.module.TestRetrofitModule
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestRepositoryImpl @Inject constructor() {
    private val logTag = javaClass.simpleName

//    fun getDefault(): Flowable<Response<ArrayList<User>>> {
//        Log.d(logTag, "getDefault")
//        return TestRetrofitModule.getService().getDefault().subscribeOn(Schedulers.io())
//    }

     fun getVehicleLocation(): Flowable<Response<EVCSResponse>> {
        Log.d(logTag, "EVCS_API_KEY ${BuildConfig.EVCS_API_KEY}")

        
        return TestRetrofitModule.getService().getVehicleLocation(
            serviceKey = BuildConfig.EVCS_API_KEY,
        ).subscribeOn(Schedulers.io())
    }
}