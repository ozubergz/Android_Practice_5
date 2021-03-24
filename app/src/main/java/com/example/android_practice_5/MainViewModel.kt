package com.example.android_practice_5

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _components = MutableLiveData<List<Component>>()

    val components : LiveData<List<Component>>
        get() = _components

    fun loadItems() {
        val components = MockClient.getFeed()
        _components.postValue(components)
    }
}