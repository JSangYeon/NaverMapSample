package jsy.test.navermapsample.model.api

import io.reactivex.Flowable
import jsy.test.navermapsample.model.data.evcs.EVCSResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EVSCRepository {

    @GET("/B552584/EvCharger/getChargerInfo")
    fun getVehicleLocation(
        @Query("serviceKey") serviceKey: String,
        @Query("pageNo") pageNo: Int? = 1,
        @Query("numOfRows") numOfRows: Int? = 10,
        @Query("zcode") zcode: Int? = 11,
        @Query("dataType") dataType: String? =  "JSON",
    ): Flowable<Response<EVCSResponse>>

//    @GET("/todos")
//    fun getDefault(): Flowable<Response<ArrayList<User>>>
}