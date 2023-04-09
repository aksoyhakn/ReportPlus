package com.aksoyhakn.reportplus.ui.main.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.data.service.model.User
import com.aksoyhakn.reportplus.databinding.ItemSearchBinding
import com.aksoyhakn.reportplus.extensions.hide
import com.aksoyhakn.reportplus.extensions.isNotNull
import com.aksoyhakn.reportplus.extensions.setSafeOnClickListener


class SearchAdapter(
    val data: ArrayList<User>,
    val isUnFollow : Boolean ?= false,
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
        holder.bindData(data[position], position, isUnFollow)
    }

    class SearchViewHolder(
        var binding: ItemSearchBinding,
        val onClick: (User) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(item: User, position: Int, isUnFollow: Boolean?) {
            binding.user = item
            binding.isUnFollow = isUnFollow
            binding.rlItem.setSafeOnClickListener {
                onClick(item)
            }
            binding.executePendingBindings()
        }
    }

    companion object {

        @JvmStatic
        @BindingAdapter(value = ["bind:setSearchData","bind:setSearchIsUnFollow", "bind:setSearchListener"])
        fun setSearchData(
            view: RecyclerView,
            data: ArrayList<User>?,
            isUnFollow : Boolean ?= false,
            listener: ListenerSearch
        ) {
            if (data.isNotNull()) {
                view.adapter =
                    SearchAdapter(
                        (data as ArrayList<User>),
                        isUnFollow,
                        listener
                    )
            }
        }
    }

    interface ListenerSearch {
        fun clickSearch(item: User)
    }

}