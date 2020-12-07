package com.cylit.swapp.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cylit.swapp.repositories.IPeopleRepository

class PeopleViewModelFactory(private val repository: IPeopleRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(IPeopleRepository::class.java).newInstance(repository)
    }
}