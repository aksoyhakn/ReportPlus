package com.example.tradeonline.ui.main.indicator.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tradeonline.R
import com.example.tradeonline.databinding.ItemIndicatorBinding
import com.example.tradeonline.extensions.isNotNull
import com.example.tradeonline.extensions.setSafeOnClickListener
import com.example.tradeonline.ui.main.indicator.model.IndicatorResponse

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


class IndicatorAdapter(
    val indicator: ArrayList<IndicatorResponse>,
    val listener: ListenerIndicator
) : RecyclerView.Adapter<IndicatorAdapter.IndicatorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndicatorViewHolder {
        return IndicatorViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_indicator,
                parent,
                false
            )
        ) { eventItem ->
            listener.clickIndicator(eventItem)
        }
    }

    override fun getItemCount(): Int = indicator.size

    override fun onBindViewHolder(holder: IndicatorViewHolder, position: Int) {
        holder.bindData(indicator[position], position, (indicator.size - 1))
    }

    class IndicatorViewHolder(
        var binding: ItemIndicatorBinding,
        val onClick: (IndicatorResponse) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(indicator: IndicatorResponse, position: Int, lastPosition: Int) {
            binding.item = indicator
            binding.rlIndicator.animation =
                AnimationUtils.loadAnimation(binding.rlIndicator.context, R.anim.anim_recyclerview)
            binding.rlIndicator.setSafeOnClickListener {
                onClick(indicator)
            }

            if (lastPosition == position) {
                binding.view.visibility = View.VISIBLE
            } else {
                binding.view.visibility = View.GONE
            }

            binding.rlIndicator.setSafeOnClickListener {
                onClick(indicator)
            }

            binding.executePendingBindings()
        }
    }

    companion object {

        @JvmStatic
        @BindingAdapter(value = ["bind:setIndicatorData", "bind:setIndicatorListener"])
        fun setIndicatorData(
            view: RecyclerView,
            course: ArrayList<IndicatorResponse>?,
            listener: ListenerIndicator
        ) {
            if (course.isNotNull()) {
                view.adapter =
                    IndicatorAdapter(
                        (course as ArrayList<IndicatorResponse>),
                        listener
                    )
            }
        }

    }

    interface ListenerIndicator {
        fun clickIndicator(item: IndicatorResponse)
    }

}