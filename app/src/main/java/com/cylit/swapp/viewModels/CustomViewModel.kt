package com.cylit.swapp.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class CustomViewModel : ViewModel() {

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()

    val loading
        get() = _loading

    fun setLoading(isLoading: Boolean) {
        _loading.value = isLoading
    }
}