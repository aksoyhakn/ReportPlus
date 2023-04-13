package com.aksoyhakn.reportplus.ui.main.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.data.service.model.HightLightItem
import com.aksoyhakn.reportplus.databinding.ItemHighlightBinding
import com.aksoyhakn.reportplus.extensions.isNotNull
import com.aksoyhakn.reportplus.extensions.setSafeOnClickListener


class HighLightAdapter(
    val data: ArrayList<HightLightItem>,
    val listener: ListenerHighLightItem
) : RecyclerView.Adapter<HighLightAdapter.HighLightViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HighLightViewHolder {
        return HighLightViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_highlight,
                parent,
                false
            )
        ) { item ->
            listener.clickHightLightItem(item)
        }
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: HighLightViewHolder, position: Int) {
        holder.bindData(data[position], position)
    }

    class HighLightViewHolder(
        var binding: ItemHighlightBinding,
        val onClick: (HightLightItem) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(item: HightLightItem, position: Int) {
            binding.item = item
            binding.rlHighLight.setSafeOnClickListener {
                onClick(item)
            }
            binding.executePendingBindings()
        }
    }

    companion object {

        @JvmStatic
        @BindingAdapter(value = ["bind:setHightLightItemData", "bind:setHightLightItemListener"])
        fun setHightLightItemData(
            view: RecyclerView,
            data: ArrayList<HightLightItem>?,
            listener: ListenerHighLightItem
        ) {
            if (data.isNotNull()) {
                view.setItemViewCacheSize(100)
                view.adapter =
                    HighLightAdapter(
                        (data as ArrayList<HightLightItem>),
                        listener
                    )
            }
        }
    }

    interface ListenerHighLightItem {
        fun clickHightLightItem(item: HightLightItem)
    }

}