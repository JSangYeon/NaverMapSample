package jsy.test.navermapsample.model.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Items(

    @SerializedName("item")
    @Expose
    val evChargingStationList: ArrayList<EVChargingStation>,
)
