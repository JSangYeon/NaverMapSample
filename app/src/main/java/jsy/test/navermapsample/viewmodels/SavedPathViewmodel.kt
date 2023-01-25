package jsy.test.navermapsample.viewmodels

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.navigation.Navigation
import com.example.naviMapTest.base.BaseViewModel
import com.example.naviMapTest.base.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import jsy.test.navermapsample.R
import jsy.test.navermapsample.model.database.entity.RouteHistory
import jsy.test.navermapsample.model.repository.LocalRepository
import javax.inject.Inject


@HiltViewModel
class SavedPathViewmodel @Inject constructor(
    private val localRepository: LocalRepository
) : BaseViewModel() {

    private val _pathList = SingleLiveEvent<Array<RouteHistory>>()

    val pathList: LiveData<Array<RouteHistory>> = _pathList


    init {
        getAllPlace()
    }

    fun navigateNaverMapFragment(view: View) {
        Navigation.findNavController(view).navigate(R.id.action_saved_path_to_naver_map)
    }

    fun getAllPlace() {
        disposables.clear()
        localRepository.getPathListHistory().subscribe(
            { pathList ->
                Log.d(logTag, "getPlaceSize : ${pathList.size}")
                pathList.forEach { path->
                    Log.d(logTag, "getPlace : ${path}")
                }
                _pathList.postValue(pathList)
            },{
                Log.d(logTag, "getAllPlace error : $it")
            }
        ).let {
          disposables.add(it)
        };
    }


}