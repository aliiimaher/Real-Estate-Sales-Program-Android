package com.example.androidcoures.feature.home.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidcoures.feature.home.domain.data.model.HouseResponse
import com.example.androidcoures.feature.home.domain.data.repository.HomeRepository

class HomeViewModel(private val repository: HomeRepository) : ViewModel() {

    //region Properties
    private val _houses = MutableLiveData<List<HouseResponse.House>>()
    val houses: LiveData<List<HouseResponse.House>> get() = _houses
    // endregion

    //region Methods
    fun fetchAllHouses() {
        val response = repository.fetchAllHouses()
    }
    //endregion
}

class PostModule {
    companion object {
        val watchRepository: HomeRepository by lazy {
            HomeRepository()
        }
    }
}

class PostViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(PostModule.watchRepository) as T
        }
        throw java.lang.IllegalArgumentException("wrong dependency")
    }
}