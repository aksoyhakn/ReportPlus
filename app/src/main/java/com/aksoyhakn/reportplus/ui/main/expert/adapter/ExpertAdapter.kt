package com.aksoyhakn.reportplus.ui.main.expert.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.databinding.ItemExpertBinding
import com.aksoyhakn.reportplus.extensions.isNotNull
import com.aksoyhakn.reportplus.extensions.setSafeOnClickListener
import com.aksoyhakn.reportplus.ui.main.expert.model.ExpertResponse

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


class ExpertAdapter(
    val expert: ArrayList<ExpertResponse>,
    val listener: ListenerExpert
) : RecyclerView.Adapter<ExpertAdapter.ExpertViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpertViewHolder {
        return ExpertViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_expert,
                parent,
                false
            )
        ) { eventItem ->
            listener.clickExpert(eventItem)
        }
    }

    override fun getItemCount(): Int = expert.size

    override fun onBindViewHolder(holder: ExpertViewHolder, position: Int) {
        holder.bindData(expert[position], position, (expert.size - 1))
    }

    class ExpertViewHolder(
        var binding: ItemExpertBinding,
        val onClick: (ExpertResponse) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(course: ExpertResponse, position: Int, lastPosition: Int) {
            binding.item = course
            binding.rlExpert.animation =
                AnimationUtils.loadAnimation(binding.rlExpert.context, R.anim.anim_recyclerview)
            binding.rlExpert.setSafeOnClickListener {
                onClick(course)
            }

            if (lastPosition == position) {
                binding.view.visibility = View.VISIBLE
            } else {
                binding.view.visibility = View.GONE
            }

            binding.executePendingBindings()
        }
    }

    companion object {

        @JvmStatic
        @BindingAdapter(value = ["bind:setExpertData", "bind:setExpertListener"])
        fun setExpertData(
            view: RecyclerView,
            course: ArrayList<ExpertResponse>?,
            listener: ListenerExpert
        ) {
            if (course.isNotNull()) {
                view.adapter =
                    ExpertAdapter(
                        (course as ArrayList<ExpertResponse>),
                        listener
                    )
            }
        }

    }

    interface ListenerExpert {
        fun clickExpert(item: ExpertResponse)
    }

}