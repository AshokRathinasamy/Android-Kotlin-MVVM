package com.android.mvvm.kotlin.data.source

import androidx.lifecycle.LiveData
import com.android.mvvm.kotlin.data.Result
import com.android.mvvm.kotlin.data.source.local.TaskDataSource
import com.android.mvvm.kotlin.data.source.model.RealestateResponse
import com.android.mvvm.kotlin.data.source.remote.ApiCall
import com.android.mvvm.kotlin.data.source.remote.SafeApiRequest

class DefaultTaskRepository(
    private val apiCall: ApiCall,
    private val roomDb: TaskDataSource): SafeApiRequest(), TaskRepository {

    override suspend fun getAllData(): Result<List<RealestateResponse>> {
        var taskList = apiRequest { apiCall.getAllData() }
        if (taskList is Result.Success){
            saveTaskAll(taskList.data)
        }
        return roomDb.getTasks()
    }

    override fun observeTask(): LiveData<Result<List<RealestateResponse>>> {
        return roomDb.observeTasks()
    }

    override suspend fun getTasks(): Result<List<RealestateResponse>> {
        return roomDb.getTasks()
    }

    override suspend fun saveTaskAll(task: List<RealestateResponse>) {
        return roomDb.saveTaskAll(task)
    }

    override suspend fun saveTask(task: RealestateResponse) {
        roomDb.saveTask(task)
    }

    override suspend fun updateTask(task: RealestateResponse): Int {
        return roomDb.updateTask(task)
    }
}