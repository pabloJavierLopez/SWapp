package com.cylit.swapp.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.cylit.swapp.repositories.IPlanetRepository


class PlanetViewModel(private val planetRepository: IPlanetRepository) :
    CustomViewModel() {

    private var error: MutableLiveData<String> = MutableLiveData()

    val all = liveData {
        try {
            setLoading(true)
            emit(planetRepository.getAll())
        } catch (e: Exception) {
            e.message?.let { setRequestError(it) }
        } finally {
            setLoading(false)
        }
    }
    val requestError
        get() = error

    fun setRequestError(message: String) {
        error.value = message
    }


}