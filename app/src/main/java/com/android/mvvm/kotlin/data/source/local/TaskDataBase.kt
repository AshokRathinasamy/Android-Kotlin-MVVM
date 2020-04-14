package com.android.mvvm.kotlin.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.mvvm.kotlin.data.source.model.RealestateResponse

@Database(entities = [RealestateResponse::class], version = 1, exportSchema = false)
abstract class TaskDataBase : RoomDatabase() {
    abstract fun taskDao() : TaskDao
}