package jsy.test.navermapsample.ui.fragment

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import jsy.test.navermapsample.R
import jsy.test.navermapsample.base.BaseFragment
import jsy.test.navermapsample.databinding.FragmentSecondBinding
import jsy.test.navermapsample.viewmodels.SecondViewModel


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */

@AndroidEntryPoint
class SecondFragment : BaseFragment<FragmentSecondBinding>(R.layout.fragment_second) {

    val _secondViewModel : SecondViewModel by viewModels()

    override fun FragmentSecondBinding.init() {
        Log.d(logTag, "init secondFragment")

        binding.secondFragment = this@SecondFragment
        binding.secondViewModel = _secondViewModel

    }
}