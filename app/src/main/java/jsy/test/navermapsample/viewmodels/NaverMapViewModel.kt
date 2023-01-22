package jsy.test.navermapsample.viewmodels

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.navigation.Navigation
import com.example.naviMapTest.base.BaseViewModel
import com.example.naviMapTest.base.SingleLiveEvent
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.overlay.Marker
import dagger.hilt.android.lifecycle.HiltViewModel
import jsy.test.navermapsample.R
import jsy.test.navermapsample.model.repository.TestRepositoryImpl
import javax.inject.Inject


@HiltViewModel
class NaverMapViewModel @Inject constructor(
    private val testRepositoryImpl: TestRepositoryImpl
) : BaseViewModel() {

    private val _markerList = SingleLiveEvent<ArrayList<Marker>>()

    val markerList: LiveData<ArrayList<Marker>> = _markerList


    private val _currentLocation = SingleLiveEvent<LatLng>()
    val currentLocation: LiveData<LatLng>
        get() = _currentLocation


    fun navigateSecondFragment(view: View) {
        Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment)
    }

    fun testRetrofit() {

        Log.d(logTag, "testRetrofit")
        testRepositoryImpl.getVehicleLocation().subscribe({ response ->

            val evcsResponse = response.body()
            Log.d(logTag, "retrofit 충전소 :  ${evcsResponse}}")

            evcsResponse?.items?.evChargingStationList?.forEach { evChargingStation ->
                Log.d(logTag, "evChargingStation Name : ${evChargingStation.statNm}")

            }

        }, {
            Log.d(logTag, "retrofit error : $it")
        }).let { }

    }

    fun setLocationMokdong() {
        _currentLocation.value = LatLng(37.5261, 126.8643)
    }
}