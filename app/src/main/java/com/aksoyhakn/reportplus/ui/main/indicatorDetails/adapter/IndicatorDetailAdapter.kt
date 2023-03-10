package com.aksoyhakn.reportplus.ui.main.indicatorDetails.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.databinding.ItemIndicatorDetailBinding
import com.aksoyhakn.reportplus.extensions.isNotNull
import com.aksoyhakn.reportplus.extensions.setSafeOnClickListener
import com.aksoyhakn.reportplus.ui.main.indicator.model.IndicatorYoutubeResponse


/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


class IndicatorDetailAdapter(
    val indicatorDetail: ArrayList<IndicatorYoutubeResponse>,
    val listener: ListenerIndicatorDetail
) : RecyclerView.Adapter<IndicatorDetailAdapter.IndicatorDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndicatorDetailViewHolder {
        return IndicatorDetailViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_indicator_detail,
                parent,
                false
            )
        ) { eventItem ->
            listener.clickIndicatorDetail(eventItem)
        }
    }

    override fun getItemCount(): Int = indicatorDetail.size

    override fun onBindViewHolder(holder: IndicatorDetailViewHolder, position: Int) {
        holder.bindData(indicatorDetail[position], position, indicatorDetail.size)
    }

    class IndicatorDetailViewHolder(
        var binding: ItemIndicatorDetailBinding,
        val onClick: (IndicatorYoutubeResponse) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(
            indicatorYoutubeResponse: IndicatorYoutubeResponse,
            position: Int,
            itemSize: Int
        ) {
            binding.item = indicatorYoutubeResponse
            binding.rlIndicatorDetail.animation =
                AnimationUtils.loadAnimation(
                    binding.rlIndicatorDetail.context,
                    R.anim.anim_recyclerview
                )
            binding.rlIndicatorDetail.setSafeOnClickListener {
                onClick(indicatorYoutubeResponse)
            }

            itemSize.takeIf { it >= 5 }?.apply {
                if ((this - 1) == position) {
                    binding.view.visibility = View.VISIBLE
                } else {
                    binding.view.visibility = View.GONE
                }
            }

            binding.executePendingBindings()
        }
    }

    companion object {

        @JvmStatic
        @BindingAdapter(value = ["bind:setIndicatorDetailData", "bind:setIndicatorDetailListener"])
        fun setIndicatorDetailData(
            view: RecyclerView,
            indicatorYoutubeResponse: ArrayList<IndicatorYoutubeResponse>?,
            listener: ListenerIndicatorDetail
        ) {
            if (indicatorYoutubeResponse.isNotNull()) {
                view.adapter =
                    IndicatorDetailAdapter(
                        (indicatorYoutubeResponse as ArrayList<IndicatorYoutubeResponse>),
                        listener
                    )
            }
        }

    }

    interface ListenerIndicatorDetail {
        fun clickIndicatorDetail(item: IndicatorYoutubeResponse)
    }

}