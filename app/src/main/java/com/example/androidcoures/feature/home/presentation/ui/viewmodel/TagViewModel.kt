package com.example.androidcoures.feature.home.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidcoures.feature.home.domain.data.model.TagResponse
import com.example.androidcoures.feature.home.domain.data.repository.TagRepository

class TagViewModel(private val repository: TagRepository) : ViewModel() {

    //region Properties
    private var _tags = MutableLiveData<List<TagResponse.Tag>>()
    val tags: LiveData<List<TagResponse.Tag>> get() = _tags
    //endregion

    //region Methods
    fun fetchAllTags() {
        _tags.postValue(repository.fetchAllTags())
    }
    //endregion
}

class TagModule {
    companion object {
        val watchRepository: TagRepository by lazy {
            TagRepository()
        }
    }
}

class TagViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TagViewModel::class.java)) {
            return TagViewModel(TagModule.watchRepository) as T
        }
        throw java.lang.IllegalArgumentException("wrong dependency")
    }
}