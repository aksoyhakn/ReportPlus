package com.aksoyhakn.reportplus.ui.main.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.databinding.ItemCategoryBinding
import com.aksoyhakn.reportplus.extensions.isNotNull

class MainCategoryAdapter(
    val data: ArrayList<String>,
    val listener: ListenerMainCategory
) : RecyclerView.Adapter<MainCategoryAdapter.MainCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainCategoryViewHolder {
        return MainCategoryViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_category,
                parent,
                false
            )
        ) { item ->
            listener.clickMainCategory(item)
        }
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MainCategoryViewHolder, position: Int) {
        holder.bindData(data[position], position, data.size)
    }

    class MainCategoryViewHolder(
        var binding: ItemCategoryBinding,
        val onClick: (String) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(item: String, position: Int, lastPosition: Int) {
            binding.executePendingBindings()
            binding.categoryTitle = item
        }
    }

    companion object {

        @JvmStatic
        @BindingAdapter(value = ["bind:setMainCategoryData", "bind:setMainCategoryListener"])
        fun setMainCategoryData(
            view: RecyclerView,
            data: ArrayList<String>?,
            listener: ListenerMainCategory
        ) {
            if (data.isNotNull()) {
                view.adapter =
                    MainCategoryAdapter(
                        (data as ArrayList<String>),
                        listener
                    )
            }
        }
    }

    interface ListenerMainCategory {
        fun clickMainCategory(item: String)
    }

}