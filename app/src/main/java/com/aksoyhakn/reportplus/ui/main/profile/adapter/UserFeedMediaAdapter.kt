package com.aksoyhakn.reportplus.ui.main.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.data.service.model.Media
import com.aksoyhakn.reportplus.databinding.ItemUserfeedBinding
import com.aksoyhakn.reportplus.extensions.isNotNull
import com.aksoyhakn.reportplus.extensions.isNull
import com.aksoyhakn.reportplus.extensions.setSafeOnClickListener
import com.bumptech.glide.Glide


class UserFeedMediaAdapter(
    val data: ArrayList<Media>,
    val listener: ListenerUserFeedMedia
) : RecyclerView.Adapter<UserFeedMediaAdapter.UserFeedMediaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserFeedMediaViewHolder {
        return UserFeedMediaViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_userfeed,
                parent,
                false
            )
        ) { item ->
            listener.clickUserFeed(item)
        }
    }

    override fun getItemCount(): Int = data.size

    fun addItem(list: ArrayList<Media>) {
        list.let {
            val previousSize = this.data.size
            this.data.addAll(it)
            notifyItemRangeInserted(previousSize, list.size)
        }
    }

    override fun onBindViewHolder(holder: UserFeedMediaViewHolder, position: Int) {
        holder.bindData(data[position], position)
    }

    class UserFeedMediaViewHolder(
        var binding: ItemUserfeedBinding,
        val onClick: (Media) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(item: Media, position: Int) {
            binding.item = item

            item.imageVersions2?.let {
                it.candidates?.first().let {
                    binding.feedUrl = it?.url
                }
            }
            item.carouselMedia?.let {
                it.first().let {
                    binding.imgPlay.isVisible = it.videoVersions != null
                    it.imageVersions2?.let {
                        it.candidates?.first().let {
                            binding.feedUrl = it?.url
                        }
                    }
                }
            }

            binding.clRoot.setSafeOnClickListener {
                onClick(item)
            }

            binding.executePendingBindings()
        }
    }

    companion object {

        @JvmStatic
        @BindingAdapter(value = ["bind:setUserFeedMediaItemData", "bind:setUserFeedMediaListener"])
        fun setUserFeedMediaItemData(
            view: RecyclerView,
            data: ArrayList<Media>?,
            listener: ListenerUserFeedMedia
        ) {
            if (data.isNotNull()) {
                view.setItemViewCacheSize(100)
                if(view.adapter.isNull()){
                    view.adapter =
                        UserFeedMediaAdapter(
                            (data as ArrayList<Media>),
                            listener
                        )
                }else{
                    if (!data.isNullOrEmpty()) {
                        (view.adapter as? UserFeedMediaAdapter)?.addItem(data)
                    }
                }
            }
        }
    }

    interface ListenerUserFeedMedia {
        fun clickUserFeed(item: Media)
    }

}