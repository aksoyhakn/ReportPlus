package com.aksoyhakn.reportplus.ui.main.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.databinding.ItemCategoryBinding
import com.aksoyhakn.reportplus.extensions.isNotNull
import com.aksoyhakn.reportplus.ui.main.main.FreeMenuType
import com.aksoyhakn.reportplus.ui.main.main.MenuItem
import com.aksoyhakn.reportplus.ui.main.main.PremiumMenuType

class MainCategoryAdapter(
    val data: ArrayList<MenuItem>,
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
        val onClick: (MenuItem) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(item: MenuItem, position: Int, lastPosition: Int) {
            binding.executePendingBindings()
            binding.tvCategoryTitle.text = item.title
            binding.tvCategoryAmount.text = item.count

            when (item.menuType) {
                0 -> {
                    when (item.type) {
                        FreeMenuType.FOLLOWERS.ordinal -> {
                            binding.ivAppIcon.setImageResource(R.drawable.menu_followers)
                        }
                        FreeMenuType.LOST_FOLLOWERS.ordinal -> {
                            binding.ivAppIcon.setImageResource(R.drawable.menu_lost_followers)
                        }
                        FreeMenuType.MY_FANS.ordinal -> {
                            binding.ivAppIcon.setImageResource(R.drawable.menu_my_fans)
                        }
                        FreeMenuType.UN_FOLLOWES.ordinal -> {
                            binding.ivAppIcon.setImageResource(R.drawable.menu_unfollowers)
                        }
                        FreeMenuType.DO_FOLLOWERS.ordinal -> {
                            binding.ivAppIcon.setImageResource(R.drawable.menu_do_followers)
                        }
                    }
                }
                1 -> {
                    when (item.type) {
                        PremiumMenuType.WHO_BLOCKED.ordinal -> {
                            binding.ivAppIcon.setImageResource(R.drawable.menu_who_blocked)
                        }
                        PremiumMenuType.HAVE_BLOCKED.ordinal -> {
                            binding.ivAppIcon.setImageResource(R.drawable.menu_have_blocked)
                        }
                        PremiumMenuType.TOP_COMMENTERS.ordinal -> {
                            binding.ivAppIcon.setImageResource(R.drawable.menu_top_commenters)
                        }
                        PremiumMenuType.MOST_LIKED_USERS.ordinal -> {
                            binding.ivAppIcon.setImageResource(R.drawable.menu_most_like_users)
                        }
                        PremiumMenuType.GHOST_USERS.ordinal -> {
                            binding.ivAppIcon.setImageResource(R.drawable.menu_ghost_users)
                        }
                    }
                }
            }
        }
    }

    companion object {

        @JvmStatic
        @BindingAdapter(value = ["bind:setMainCategoryData", "bind:setMainCategoryListener"])
        fun setMainCategoryData(
            view: RecyclerView,
            data: ArrayList<MenuItem>?,
            listener: ListenerMainCategory
        ) {
            if (data.isNotNull()) {
                view.adapter =
                    MainCategoryAdapter(
                        (data as ArrayList<MenuItem>),
                        listener
                    )
            }
        }
    }

    interface ListenerMainCategory {
        fun clickMainCategory(item: MenuItem)
    }

}