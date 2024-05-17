package com.example.androidcoures.feature.home.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidcoures.feature.home.domain.data.model.HouseResponse
import com.example.androidcoures.feature.home.domain.data.model.TagResponse
import com.example.androidcoures.feature.home.domain.data.repository.HomeRepository
import com.example.androidcoures.feature.home.domain.data.repository.TagRepository

class HomeViewModel(
    private val repository: HomeRepository, private val tagsRepository: TagRepository
) : ViewModel() {

    //region Properties
    private val _houses = MutableLiveData<List<HouseResponse.House>>()
    val houses: LiveData<List<HouseResponse.House>> get() = _houses
    private val _tags = MutableLiveData<List<TagResponse.Tag>>()
    val tags: LiveData<List<TagResponse.Tag>> get() = _tags
    // endregion

    //region Methods
    fun fetchAllHouses() {
        _houses.postValue(repository.fetchAllHouses())
    }

    fun fetchAllTags() {
        _tags.postValue(tagsRepository.fetchAllTags())
    }
    //endregion
}

class HouseModule {
    companion object {
        val watchRepository: HomeRepository by lazy {
            HomeRepository()
        }
        val watchTagsRepository: TagRepository by lazy {
            TagRepository()
        }
    }
}

class HouseViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(HouseModule.watchRepository, HouseModule.watchTagsRepository) as T
        }
        throw java.lang.IllegalArgumentException("wrong dependency")
    }
}