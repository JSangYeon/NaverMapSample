package jsy.test.navermapsample.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.naviMapTest.base.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
) :  ViewModel(){

    private val _mainText = SingleLiveEvent<String>()
    val mainText: LiveData<String>
        get() = _mainText

    init {
        _mainText.value = "1234"
    }

    fun changeMainText() {

//        _mainText.value = distanceCheck().toString()

//        _mainText.value = MvvmSampleApplication.instance.getString(R.string.test_provider)
    }

//    private fun distanceCheck() : Float {
//
//        val test = DistanceCalculator()
//
//        val latitude = 37.5666805
//        val longitude = 126.9784147
//
//        val startLocation = Location("startLocation")
//        startLocation.latitude = latitude
//        startLocation.longitude = longitude
//
//        val locationList = ArrayList<Location>()
//
//
//        for (i in 0..5) {
//
//            val location = Location("location$i")
//            location.latitude = latitude + ((i + 1) * 0.002)
//            location.longitude = longitude - ((i + 1) * 0.002)
//
//            locationList.add(location)
//        }
//
//        val minDistance = test.shortestDistance(startLocation, locationList)
//
//        Log.d("test", "minDistance : $minDistance")
//
//        return minDistance
//    }
}