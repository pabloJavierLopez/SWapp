package com.cylit.swapp.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cylit.swapp.repositories.IFilmRepository

class FilmViewModelFactory(private val repository: IFilmRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(IFilmRepository::class.java).newInstance(repository)
    }
}