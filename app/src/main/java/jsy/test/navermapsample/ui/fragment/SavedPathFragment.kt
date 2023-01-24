package jsy.test.navermapsample.ui.fragment

import android.util.Log
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


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */

@AndroidEntryPoint
class SavedPathFragment : BaseFragment<FragmentSavedPathBinding>(R.layout.fragment_saved_path) {

    val _savedPathViewmodel : SavedPathViewmodel by viewModels()

    override fun FragmentSavedPathBinding.init() {
        Log.d(logTag, "init SavedPathFragment")

        binding.savedPathFragment = this@SavedPathFragment
        binding.savedPathViewModel = _savedPathViewmodel


        val adapter = object : BaseRecyclerView.Adapter<RouteHistory, ItemPathBinding>(
            layoutResId = R.layout.item_path,
            bindingVariableId = BR.RouteHistory
        ) {
            override fun onBindViewHolder(
                holder: BaseRecyclerView.ViewHolder<ItemPathBinding>,
                position: Int
            ) {
                super.onBindViewHolder(holder, position)
                holder.binding.root.setOnClickListener {
                    Log.d(logTag, "itemViewClick : ${holder.binding.tvDestinationName.text}")
                }
            }
        }
//        adapter.replaceAll(getLanguageCodeList())
//        rvContent.adapter = adapter


        binding.rvPath.adapter = adapter
        _savedPathViewmodel.pathList.observe(viewLifecycleOwner){ pathList->
            adapter.replaceAll(pathList.toList())
            adapter.notifyDataSetChanged()

        }



    }
}