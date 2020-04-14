package com.android.mvvm.kotlin.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.android.mvvm.kotlin.data.source.model.RealestateResponse

@Dao
interface TaskDao {

    @Query("Select * From Tasks")
    fun observeTask(): LiveData<List<RealestateResponse>>

    @Query("Select * From Tasks")
    suspend fun getTask(): List<RealestateResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task : RealestateResponse)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllTask(task: List<RealestateResponse>)

    @Update
    suspend fun updateTask(task: RealestateResponse):Int
}