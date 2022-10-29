package com.example.trendline.ui.main.technicalAnalysis.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.trendline.R
import com.example.trendline.databinding.ItemTechnicalAnalysisBinding
import com.example.trendline.extensions.isNotNull
import com.example.trendline.extensions.setSafeOnClickListener
import com.example.trendline.ui.main.technicalAnalysis.model.TechnicalAnalysisResponse

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


class TechnicalAnalysisAdapter(
    val technicalAnalysis: ArrayList<TechnicalAnalysisResponse>,
    val listener: ListenerTechnicalAnalysis
) : RecyclerView.Adapter<TechnicalAnalysisAdapter.TechnicalAnalysisViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TechnicalAnalysisViewHolder {
        return TechnicalAnalysisViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_technical_analysis,
                parent,
                false
            )
        ) { eventItem ->
            listener.clickTechnicalAnalysis(eventItem)
        }
    }

    override fun getItemCount(): Int = technicalAnalysis.size

    override fun onBindViewHolder(holder: TechnicalAnalysisViewHolder, position: Int) {
        holder.bindData(technicalAnalysis[position], position, (technicalAnalysis.size - 1))
    }

    class TechnicalAnalysisViewHolder(
        var binding: ItemTechnicalAnalysisBinding,
        val onClick: (TechnicalAnalysisResponse) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(course: TechnicalAnalysisResponse, position: Int, lastPosition: Int) {
            binding.item = course
            binding.rlTechnicalAnalysis.animation =
                AnimationUtils.loadAnimation(
                    binding.rlTechnicalAnalysis.context,
                    R.anim.anim_recyclerview
                )
            binding.rlTechnicalAnalysis.setSafeOnClickListener {
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
        @BindingAdapter(value = ["bind:setTechnicalAnalysisData", "bind:setTechnicalAnalysisListener"])
        fun setTechnicalAnalysisData(
            view: RecyclerView,
            course: ArrayList<TechnicalAnalysisResponse>?,
            listener: ListenerTechnicalAnalysis
        ) {
            if (course.isNotNull()) {
                view.adapter =
                    TechnicalAnalysisAdapter(
                        (course as ArrayList<TechnicalAnalysisResponse>),
                        listener
                    )
            }
        }

    }

    interface ListenerTechnicalAnalysis {
        fun clickTechnicalAnalysis(item: TechnicalAnalysisResponse)
    }

}