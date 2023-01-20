package jsy.test.navermapsample.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraAnimation
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import dagger.hilt.android.AndroidEntryPoint
import jsy.test.navermapsample.R
import jsy.test.navermapsample.base.BaseFragment
import jsy.test.navermapsample.databinding.FragmentNaverMapBinding
import jsy.test.navermapsample.viewmodels.MainViewModel
import jsy.test.navermapsample.viewmodels.NaverMapViewModel
import kotlin.math.log

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

@AndroidEntryPoint
class NaverMapFragment : BaseFragment<FragmentNaverMapBinding>(R.layout.fragment_naver_map) {

    private val _naverMapViewModel: NaverMapViewModel by viewModels()

    private lateinit var naverMap : MapFragment

    override fun FragmentNaverMapBinding.init() {
        Log.d(logTag, "init naverMapFragment")
        binding.naverMapFragment = this@NaverMapFragment
        binding.naverMapViewModel = _naverMapViewModel

        naverMap = (binding.fcNaverMap.getFragment() as MapFragment)

        naverMap.getMapAsync {naverMap-> //  naverMapInit
            Log.d(logTag,"naverMapInit : $naverMap")

            initCamera(naverMap)
        }
    }


    private fun initCamera(naverMap : NaverMap){

        val cameraUpdate = CameraUpdate.scrollTo(LatLng(37.5261, 126.8643))
            .reason(3)
            .animate(CameraAnimation.Easing, 2000)
            .finishCallback {
                Toast.makeText(context, "완료", Toast.LENGTH_SHORT).show()
            }
            .cancelCallback {
                Toast.makeText(context, "취소", Toast.LENGTH_SHORT).show()
            }

        naverMap.moveCamera(cameraUpdate)

    }


}