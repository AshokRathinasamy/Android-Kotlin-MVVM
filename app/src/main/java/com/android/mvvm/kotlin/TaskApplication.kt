package com.android.mvvm.kotlin

import android.app.Application
import com.android.mvvm.kotlin.data.source.TaskRepository

class TaskApplication : Application() {

    val taskRepository: TaskRepository
        get() = ServiceLocator.provideTasksRepository(this)

}