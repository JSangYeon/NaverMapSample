package jsy.test.navermapsample.ui.fragment

import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import jsy.test.navermapsample.R
import jsy.test.navermapsample.base.BaseFragment
import jsy.test.navermapsample.base.BaseRecyclerView
import jsy.test.navermapsample.databinding.FragmentSavedPathBinding
import jsy.test.navermapsample.databinding.ItemPathBinding
import jsy.test.navermapsample.model.database.entity.RouteHistory
import jsy.test.navermapsample.viewmodels.SavedPathViewmodel
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.activityViewModels
import jsy.test.navermapsample.ui.recycler.view.saved.SavedRecyclerViewAdapter
import jsy.test.navermapsample.viewmodels.NaverMapViewModel


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */

@AndroidEntryPoint
class SavedPathFragment : BaseFragment<FragmentSavedPathBinding>(R.layout.fragment_saved_path) {

    val _savedPathViewmodel : SavedPathViewmodel by viewModels()
    private val _naverMapViewModel: NaverMapViewModel by activityViewModels()

    override fun FragmentSavedPathBinding.init() {
        Log.d(logTag, "init SavedPathFragment")

        binding.savedPathFragment = this@SavedPathFragment
        binding.savedPathViewModel = _savedPathViewmodel

        val adapter = SavedRecyclerViewAdapter{ routeHistory->
            Log.d(logTag, "adapterCallback $routeHistory")
            _savedPathViewmodel.navigateNaverMapFragment(binding.root)
            _naverMapViewModel.setRouteByRouteHistory(routeHistory)
        }



        binding.rvPath.adapter = adapter
        _savedPathViewmodel.pathList.observe(viewLifecycleOwner){ pathList->
            adapter.replaceAll(pathList.toList())
//            adapter.notifyDataSetChanged()
        }





    }
}