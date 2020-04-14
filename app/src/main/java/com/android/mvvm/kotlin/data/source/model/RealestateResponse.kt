package com.android.mvvm.kotlin.data.source.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class RealestateResponse @JvmOverloads constructor(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "imageSource")
    val img_src: String,
    val price: Int,
    val type: String
)