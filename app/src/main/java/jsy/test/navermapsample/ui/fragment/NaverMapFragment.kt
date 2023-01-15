package jsy.test.navermapsample.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import jsy.test.navermapsample.R
import jsy.test.navermapsample.base.BaseFragment
import jsy.test.navermapsample.databinding.FragmentNaverMapBinding
import jsy.test.navermapsample.viewmodels.MainViewModel
import jsy.test.navermapsample.viewmodels.NaverMapViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

@AndroidEntryPoint
class NaverMapFragment : BaseFragment<FragmentNaverMapBinding>(R.layout.fragment_naver_map) {

    private val _naverMapViewModel: NaverMapViewModel by viewModels()


    override fun FragmentNaverMapBinding.init() {
        Log.d(logTag, "init naverMapFragment")
        binding.naverMapFragment = this@NaverMapFragment
        binding.naverMapViewModel = _naverMapViewModel


    }


}