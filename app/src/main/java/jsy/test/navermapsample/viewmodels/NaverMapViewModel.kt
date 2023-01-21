package jsy.test.navermapsample.viewmodels

import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.naviMapTest.base.SingleLiveEvent
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraAnimation
import com.naver.maps.map.CameraUpdate
import dagger.hilt.android.lifecycle.HiltViewModel
import jsy.test.navermapsample.R
import javax.inject.Inject


@HiltViewModel
class NaverMapViewModel @Inject constructor()
    : ViewModel() {

    private val _currentLocation = SingleLiveEvent<LatLng>()
    val currentLocation: LiveData<LatLng>
        get() = _currentLocation



    fun navigateSecondFragment(view: View) {
        Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment)
    }


    fun setLocationMokdong(){
        _currentLocation.value = LatLng(37.5261, 126.8643)
    }
}