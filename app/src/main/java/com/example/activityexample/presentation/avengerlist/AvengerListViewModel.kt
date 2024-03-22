package com.example.activityexample.presentation.avengerlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.activityexample.data.datasource.AvengersDataSource
import com.example.activityexample.data.datasource.AvengersDataSourceImpl

class AvengerListViewModel : ViewModel() {
    private val dataSource: AvengersDataSource by lazy {
        AvengersDataSourceImpl()
    }

    private val _isUsingGridMode = MutableLiveData(false)

    val isUsingGridMode: LiveData<Boolean>
        get() = _isUsingGridMode

    fun changeListMode() {
        val currenValue = _isUsingGridMode.value ?: false
        _isUsingGridMode.postValue(!currenValue)
    }

    fun getAvengerList() = dataSource.getAvengerMembers()
}