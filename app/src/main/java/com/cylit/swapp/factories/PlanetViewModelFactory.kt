package com.cylit.swapp.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cylit.swapp.repositories.IPlanetRepository

class PlanetViewModelFactory(private val repository: IPlanetRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(IPlanetRepository::class.java).newInstance(repository)
    }
}