package jsy.test.navermapsample.viewmodels

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import dagger.hilt.android.lifecycle.HiltViewModel
import jsy.test.navermapsample.R
import javax.inject.Inject


@HiltViewModel
class NaverMapViewModel @Inject constructor()
    : ViewModel() {

    fun navigateSecondFragment(view: View) {
        Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment)
    }
}