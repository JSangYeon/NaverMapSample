package jsy.test.navermapsample.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import jsy.test.navermapsample.R
import jsy.test.navermapsample.base.BaseActivity
import jsy.test.navermapsample.databinding.ActivityMainBinding
import jsy.test.navermapsample.viewmodels.MainViewModel

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val _mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(logTag, "startActivity");



//        _mainViewModel.mainText.observe(lifecycleOwner) { text ->
//                binding.tvMain.text = text
//        }
//
//        binding.btnTextChange.setOnClickListener{
//            _mainViewModel.changeMainText()
//        }

    }

}