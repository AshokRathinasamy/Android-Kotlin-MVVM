package com.android.mvvm.kotlin.data.source

import androidx.lifecycle.LiveData
import com.android.mvvm.kotlin.data.source.model.RealestateResponse
import com.android.mvvm.kotlin.data.Result

interface TaskRepository {

    //API Implementation
    suspend fun getAllData(): Result<List<RealestateResponse>>

    //Room Implementation
    fun observeTask(): LiveData<Result<List<RealestateResponse>>>

    suspend fun getTasks(): Result<List<RealestateResponse>>

    suspend fun saveTaskAll(task: List<RealestateResponse>)

    suspend fun saveTask(task: RealestateResponse)

    suspend fun updateTask(task: RealestateResponse): Int

}