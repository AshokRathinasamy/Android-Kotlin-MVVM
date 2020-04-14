package com.android.mvvm.kotlin.data.source.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.android.mvvm.kotlin.data.source.model.RealestateResponse
import com.android.mvvm.kotlin.data.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class TaskLocalDataSource internal constructor(
    private val taskDao: TaskDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : TaskDataSource {

    override fun observeTasks(): LiveData<Result<List<RealestateResponse>>> {
        return taskDao.observeTask().map {
            Result.Success(it)
        }
    }

    override suspend fun getTasks(): Result<List<RealestateResponse>> = withContext(ioDispatcher) {
        return@withContext try {
            Result.Success(taskDao.getTask())
        } catch (e: Exception) {
            Result.Error("DataBase Error", e.message!!)
        }
    }

    override suspend fun saveTaskAll(task: List<RealestateResponse>) {
        taskDao.saveAllTask(task)
    }

    override suspend fun saveTask(task: RealestateResponse) {
        taskDao.insertTask(task)
    }

    override suspend fun updateTask(task: RealestateResponse): Int = withContext(ioDispatcher) {
        return@withContext taskDao.updateTask(task)
    }
}