package jsy.test.navermapsample.viewmodels

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.navigation.Navigation
import com.example.naviMapTest.base.BaseViewModel
import com.example.naviMapTest.base.SingleLiveEvent
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.PathOverlay
import dagger.hilt.android.lifecycle.HiltViewModel
import jsy.test.navermapsample.R
import jsy.test.navermapsample.model.repository.EVCSRepositoryImpl
import jsy.test.navermapsample.model.repository.NaverDirectRepositoryImpl
import javax.inject.Inject


@HiltViewModel
class NaverMapViewModel @Inject constructor(
    private val evcsRepositoryImpl: EVCSRepositoryImpl,
    private val naverDirectRepositoryImpl: NaverDirectRepositoryImpl
) : BaseViewModel() {

    private val _markerList = SingleLiveEvent<ArrayList<Marker>>()
    private val _routePath = SingleLiveEvent<PathOverlay>()
    private val _isProgress = SingleLiveEvent<Boolean>()
    private val _currentLocation = SingleLiveEvent<LatLng>()

    val markerList: LiveData<ArrayList<Marker>> = _markerList
    val routePath: LiveData<PathOverlay> = _routePath
    val isProgress: LiveData<Boolean> = _isProgress
    val currentLocation: LiveData<LatLng> = _currentLocation


    fun navigateSecondFragment(view: View) {
        Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment)
    }

    fun getEVCS() {

        Log.d(logTag, "testRetrofit")
        evcsRepositoryImpl.getVehicleLocation().subscribe({ response ->

            val evcsResponse = response.body()
            Log.d(logTag, "retrofit 충전소 :  ${evcsResponse}}")


            val markerList = ArrayList<Marker>()
            evcsResponse?.EVCSItems?.evChargingStationList?.forEach { evChargingStation ->
                Log.d(logTag, "evChargingStation Name : ${evChargingStation.statNm}")
                val lat = evChargingStation.lat.toDoubleOrNull()
                val lng = evChargingStation.lng.toDoubleOrNull()
                if (lat != null && lng != null) {
                    markerList.add(
                        Marker(
                            LatLng(lat, lng)
                        ).apply {
                            tag = evChargingStation.statNm
                            captionText = evChargingStation.statNm
                        }
                    )
                }
            }
            _markerList.postValue(markerList)
        }, {
            Log.d(logTag, "retrofit error getEVCS : $it")
        }).let { }
    }

    fun getRoute(markerPosition: LatLng) {
        disposables.clear()
        if (_currentLocation.value != null) {
            _isProgress.value = true
            if (_routePath.value != null) _routePath.value!!.map = null
            naverDirectRepositoryImpl.getNaverDirect(_currentLocation.value!!, markerPosition)
                .subscribe({ response ->
//                    Log.d(logTag, "response body : ${response.body()}")
                    val naverMapDirectResponse = response.body()

                    if (naverMapDirectResponse != null &&
                        naverMapDirectResponse.route != null &&
                        naverMapDirectResponse.route.trafast != null &&
                        naverMapDirectResponse.route.trafast.isNotEmpty() &&
                        naverMapDirectResponse.route.trafast[0].path != null
                    ) {
                        val path = PathOverlay()
                        path.coords = naverMapDirectResponse.route.trafast[0].path.toCollection(ArrayList())
                        _routePath.postValue(path)
                    }
                    _isProgress.postValue(false)
                }, {
                    _isProgress.postValue(false)
                    Log.d(logTag, "retrofit error getRoute : $it")
                }).let { disposable ->
                    disposables.add(disposable)
                }
        }
    }

    fun setLocationMokdong() {
        _currentLocation.value = LatLng(37.5261, 126.8643)
    }
}