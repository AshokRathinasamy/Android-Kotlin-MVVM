package com.android.mvvm.kotlin.data.source.local

import androidx.lifecycle.LiveData
import com.android.mvvm.kotlin.data.source.model.RealestateResponse
import com.android.mvvm.kotlin.data.Result

interface TaskDataSource {
    fun observeTasks() : LiveData<Result<List<RealestateResponse>>>

    suspend fun getTasks(): Result<List<RealestateResponse>>

    suspend fun saveTaskAll(task: List<RealestateResponse>)

    suspend fun saveTask(task: RealestateResponse)

    suspend fun updateTask(task: RealestateResponse): Int

}