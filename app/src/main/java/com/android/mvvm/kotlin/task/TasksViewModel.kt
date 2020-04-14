package com.android.mvvm.kotlin.task

import androidx.lifecycle.*
import com.android.mvvm.kotlin.data.Result
import com.android.mvvm.kotlin.data.source.TaskRepository
import com.android.mvvm.kotlin.data.source.model.RealestateResponse
import kotlinx.coroutines.launch

class TasksViewModel(private val repository: TaskRepository): ViewModel() {

    private val _realEstateList = repository.observeTask().switchMap {
        val listData = MutableLiveData<List<RealestateResponse>>()
        when(it){
            is Result.Success -> listData.value = it.data
            else -> listData.value = emptyList()
        }
        listData
    }
    val realEstateList: LiveData<List<RealestateResponse>> = _realEstateList

    init {
        getRealEstateData()
    }

    fun getRealEstateData(){
        viewModelScope.launch {
            repository.getAllData()
        }
    }
}