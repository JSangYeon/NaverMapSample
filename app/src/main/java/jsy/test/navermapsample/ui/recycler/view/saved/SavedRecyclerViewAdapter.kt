package jsy.test.navermapsample.ui.recycler.view.saved

import android.util.Log
import androidx.databinding.library.baseAdapters.BR
import jsy.test.navermapsample.R
import jsy.test.navermapsample.base.BaseRecyclerView
import jsy.test.navermapsample.databinding.ItemPathBinding
import jsy.test.navermapsample.model.database.entity.RouteHistory

class SavedRecyclerViewAdapter(private val itemClickListener: (routeHistory: RouteHistory) -> Unit) : BaseRecyclerView.Adapter<RouteHistory, ItemPathBinding>(
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
            itemClickListener(holder.binding.routeHistory!!)
        }
    }

}