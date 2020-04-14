package com.android.mvvm.kotlin

import android.content.Context
import androidx.room.Room
import com.android.mvvm.kotlin.data.source.DefaultTaskRepository
import com.android.mvvm.kotlin.data.source.local.TaskDataBase
import com.android.mvvm.kotlin.data.source.local.TaskDataSource
import com.android.mvvm.kotlin.data.source.local.TaskLocalDataSource
import com.android.mvvm.kotlin.data.source.remote.ApiCall

object ServiceLocator {

    private val apiCall = ApiCall()
    private var dataBase: TaskDataBase? = null
    @Volatile
    var taskRepository: DefaultTaskRepository? = null

    fun provideTasksRepository(context: Context): DefaultTaskRepository {
        synchronized(this){
            return taskRepository ?: createTasksRepository(context)
        }
    }

    private fun createTasksRepository(context: Context):DefaultTaskRepository {
        val newRepo = DefaultTaskRepository(apiCall, createTaskLocalDataSource(context))
        taskRepository = newRepo
        return newRepo
    }

    private fun createTaskLocalDataSource(context: Context): TaskDataSource {
        val database = dataBase ?: createDataBase(context)
        return TaskLocalDataSource(database.taskDao())
    }

    private fun createDataBase(context: Context) : TaskDataBase {
        val result = Room.databaseBuilder(
            context.applicationContext,
            TaskDataBase::class.java,
            "Tasks.db"
        ).build()
        dataBase = result
        return result
    }
}