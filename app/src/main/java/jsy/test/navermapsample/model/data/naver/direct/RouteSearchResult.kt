package jsy.test.navermapsample.model.data.naver.direct

import com.naver.maps.geometry.LatLng
import jsy.test.navermapsample.model.database.entity.RouteHistory


data class RouteSearchResult(val searchedKeyword: String = "") {
    var totalItem: ArrayList<Route> = arrayListOf()
    val size: Int
        get() = totalItem.size

    data class Route(
        val departurePlaceName: String,
        val destinationName: String,
        val departurePlaceLatLng: LatLng,
        val destinationLatLng: LatLng,
        val path: ArrayList<LatLng>
    ) {
//        var code: Int = 0
    }
}

fun RouteSearchResult.Route.createPlaceHistory(): RouteHistory {
    return RouteHistory(departurePlaceName, destinationName, departurePlaceLatLng, destinationLatLng, path)
}