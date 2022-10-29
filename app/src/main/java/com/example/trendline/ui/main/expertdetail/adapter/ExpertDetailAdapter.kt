package com.example.trendline.ui.main.expertdetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.trendline.R
import com.example.trendline.databinding.ItemExpertDetailBinding
import com.example.trendline.extensions.isNotNull
import com.example.trendline.extensions.setSafeOnClickListener
import com.example.trendline.ui.main.expert.model.UserFollowingListResponse

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


class ExpertDetailAdapter(
    val expertDetail: ArrayList<UserFollowingListResponse>,
    val listener: ListenerExpertDetail
) : RecyclerView.Adapter<ExpertDetailAdapter.ExpertDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpertDetailViewHolder {
        return ExpertDetailViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_expert_detail,
                parent,
                false
            )
        ) { eventItem ->
            listener.clickExpertDetail(eventItem)
        }
    }

    override fun getItemCount(): Int = expertDetail.size

    override fun onBindViewHolder(holder: ExpertDetailViewHolder, position: Int) {
        holder.bindData(expertDetail[position], position, expertDetail.size)
    }

    class ExpertDetailViewHolder(
        var binding: ItemExpertDetailBinding,
        val onClick: (UserFollowingListResponse) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(course: UserFollowingListResponse, position: Int, lastPosition: Int) {
            binding.item = course
            binding.rlExpertDetail.animation =
                AnimationUtils.loadAnimation(
                    binding.rlExpertDetail.context,
                    R.anim.anim_recyclerview
                )
            binding.rlExpertDetail.setSafeOnClickListener {
                onClick(course)
            }
            binding.executePendingBindings()
        }
    }

    companion object {

        @JvmStatic
        @BindingAdapter(value = ["bind:setExpertDetailData", "bind:setExpertDetailListener"])
        fun setExpertDetailData(
            view: RecyclerView,
            data: ArrayList<UserFollowingListResponse>?,
            listener: ListenerExpertDetail
        ) {
            if (data.isNotNull()) {
                view.adapter =
                    ExpertDetailAdapter(
                        (data as ArrayList<UserFollowingListResponse>),
                        listener
                    )
            }
        }

    }

    interface ListenerExpertDetail {
        fun clickExpertDetail(item: UserFollowingListResponse)
    }

}