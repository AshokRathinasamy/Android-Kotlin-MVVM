package com.android.mvvm.kotlin.task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.mvvm.kotlin.data.source.TaskRepository

class TasksViewModelFactory(
    private val repository: TaskRepository)
    : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TasksViewModel(repository) as T
    }
}