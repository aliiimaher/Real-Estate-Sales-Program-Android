package com.example.androidcoures.feature.home.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidcoures.feature.home.domain.data.model.HouseInfoResponse
import com.example.androidcoures.feature.home.domain.data.repository.HouseInfoRepository

class HouseInfoViewModel(private val repository: HouseInfoRepository) : ViewModel() {

    //region Properties
    private val _houseInfo = MutableLiveData<List<HouseInfoResponse.HouseInfo>>()
    val houseInfo: LiveData<List<HouseInfoResponse.HouseInfo>> get() = _houseInfo
    // endregion

    //region Methods
    fun fetchAllHouseInfo() {
        _houseInfo.postValue(repository.fetchAllHouseInfo())
    }
    //endregion
}

class HouseInfoModule {
    companion object {
        val watchRepository: HouseInfoRepository by lazy {
            HouseInfoRepository()
        }
    }
}

class HouseInfoViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HouseInfoViewModel::class.java)) {
            return HouseInfoViewModel(HouseInfoModule.watchRepository) as T
        }
        throw java.lang.IllegalArgumentException("wrong dependency")
    }
}