package com.android.mvvm.kotlin.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.android.mvvm.kotlin.TaskApplication
import com.android.mvvm.kotlin.databinding.FragmentTaskBinding

class TaskFragment : Fragment() {

    private lateinit var viewDataBinding: FragmentTaskBinding
    private val viewModel by viewModels<TasksViewModel> {
        TasksViewModelFactory((requireContext().applicationContext as TaskApplication).taskRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewDataBinding = FragmentTaskBinding.inflate(inflater, container, false).apply {
            viewModels = viewModel
        }

        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        setupListAdapter()
    }

    private fun setupListAdapter() {
        val taskListAdapter = TasksAdapter(viewModel)
        viewDataBinding.tasksList.adapter = taskListAdapter
    }
}
