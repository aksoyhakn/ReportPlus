package com.aksoyhakn.reportplus.ui.main.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.databinding.ItemSearchBinding
import com.aksoyhakn.reportplus.extensions.isNotNull
import com.aksoyhakn.reportplus.extensions.setSafeOnClickListener


class SearchAdapter(
    val data: ArrayList<String>,
    val listener: ListenerSearch
) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_search,
                parent,
                false
            )
        ) { item ->
            listener.clickSearch(item)
        }
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bindData(data[position], position, data.size)
    }

    class SearchViewHolder(
        var binding: ItemSearchBinding,
        val onClick: (String) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(item: String, position: Int, lastPosition: Int) {
            binding.rlItem.setSafeOnClickListener {
                onClick(item)
            }
            binding.executePendingBindings()
        }
    }

    companion object {

        @JvmStatic
        @BindingAdapter(value = ["bind:setSearchData", "bind:setSearchListener"])
        fun setSearchData(
            view: RecyclerView,
            data: ArrayList<String>?,
            listener: ListenerSearch
        ) {
            if (data.isNotNull()) {
                view.adapter =
                    SearchAdapter(
                        (data as ArrayList<String>),
                        listener
                    )
            }
        }
    }

    interface ListenerSearch {
        fun clickSearch(item: String)
    }

}