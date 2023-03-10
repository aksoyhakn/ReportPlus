package com.aksoyhakn.reportplus.ui.main.journal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.databinding.ItemJournalBinding
import com.aksoyhakn.reportplus.extensions.isNotNull
import com.aksoyhakn.reportplus.extensions.setSafeOnClickListener
import com.aksoyhakn.reportplus.ui.main.journal.model.JournalResponse

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

class JournalAdapter(
    val journal: ArrayList<JournalResponse>,
    val listener: ListenerJournal
) : RecyclerView.Adapter<JournalAdapter.JournalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JournalViewHolder {
        return JournalViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_journal,
                parent,
                false
            )
        ) { eventItem ->
            listener.clickJournal(eventItem)
        }
    }

    override fun getItemCount(): Int = journal.size

    override fun onBindViewHolder(holder: JournalViewHolder, position: Int) {
        holder.bindData(journal[position], position, (journal.size - 1))
    }

    class JournalViewHolder(
        var binding: ItemJournalBinding,
        val onClick: (JournalResponse) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(course: JournalResponse, position: Int, lastPosition: Int) {
            binding.item = course
            binding.rlJournal.animation =
                AnimationUtils.loadAnimation(binding.rlJournal.context, R.anim.anim_recyclerview)
            binding.rlJournal.setSafeOnClickListener {
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
        @BindingAdapter(value = ["bind:setJournalData", "bind:setJournalListener"])
        fun setJournalData(
            view: RecyclerView,
            course: ArrayList<JournalResponse>?,
            listener: ListenerJournal
        ) {
            if (course.isNotNull()) {
                view.adapter =
                    JournalAdapter(
                        (course as ArrayList<JournalResponse>),
                        listener
                    )
            }
        }

    }

    interface ListenerJournal {
        fun clickJournal(item: JournalResponse)
    }

}