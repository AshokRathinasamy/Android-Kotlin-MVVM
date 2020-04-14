package com.android.mvvm.kotlin.task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.mvvm.kotlin.data.source.model.RealestateResponse
import com.android.mvvm.kotlin.databinding.RowItemTaskBinding

class TasksAdapter(private val viewModel: TasksViewModel) :
    ListAdapter<RealestateResponse, TasksAdapter.TaskViewHolder>(TaskDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(viewModel, item)
    }

    class TaskViewHolder private constructor(val binding: RowItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModels: TasksViewModel, realestate: RealestateResponse) {
            binding.viewModel = viewModels
            binding.itemRealEstate = realestate
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): TaskViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowItemTaskBinding.inflate(layoutInflater, parent, false)
                return TaskViewHolder(binding)
            }
        }
    }
}

class TaskDiffCallback : DiffUtil.ItemCallback<RealestateResponse>() {
    override fun areItemsTheSame(
        oldItem: RealestateResponse,
        newItem: RealestateResponse
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: RealestateResponse,
        newItem: RealestateResponse
    ): Boolean {
        return oldItem == newItem
    }

}