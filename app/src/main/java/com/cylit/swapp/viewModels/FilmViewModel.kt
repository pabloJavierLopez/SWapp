package com.cylit.swapp.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cylit.swapp.repositories.IFilmRepository
import com.cylit.swapp.model.FilmDetailDto
import kotlinx.coroutines.launch

class FilmViewModel(private val filmRepository: IFilmRepository) : CustomViewModel() {

    private var error: MutableLiveData<String> = MutableLiveData()
    private var filmDetail: MutableLiveData<FilmDetailDto> = MutableLiveData()
    private var all: MutableLiveData<List<FilmDetailDto>> = MutableLiveData()
    private val _like: MutableLiveData<Boolean?> = MutableLiveData()
    private val _noLike: MutableLiveData<Boolean?> = MutableLiveData()

    fun getAll() {
        viewModelScope.launch {
            try {
                if (allFilms.value == null || allFilms.value?.size == 0) {
                    setLoading(true)
                    setAllFilms(filmRepository.getAll())
                }
            } catch (e: Exception) {
                e.message?.let { setRequestError(it) }
            } finally {
                setLoading(false)
            }
        }
    }

    fun likeFilm() {
        viewModelScope.launch {
            try {
                setLoading(true)
                film.value?.let {
                    setLike(filmRepository.like(film.value!!.episodeId))
                    addLikeFilm()
                }
            } catch (e: Exception) {
                e.message?.let { setRequestError(it) }
            } finally {
                setLoading(false)
            }
        }
    }

    fun noLikeFilm() {
        viewModelScope.launch {
            try {
                setLoading(true)
                film.value?.let {
                    setNoLike(filmRepository.noLike(film.value!!.episodeId))
                    addNoLikeFilm()
                }
            } catch (e: Exception) {
                e.message?.let { setRequestError(it) }
            } finally {
                setLoading(false)
            }
        }
    }

    private fun addLikeFilm() {
        val film =
            allFilms.value?.firstOrNull { film -> film.episodeId == filmDetail.value?.episodeId }

        film?.let {
            it.like = true
            it.noLike = false
        }
    }

    private fun addNoLikeFilm() {
        val film =
            allFilms.value?.firstOrNull { film -> film.episodeId == filmDetail.value?.episodeId }

        film?.let {
            it.noLike = true
            it.like = false
        }

    }


    val requestError
        get() = error

    private fun setRequestError(message: String) {
        error.value = message
    }

    val like
        get() = _like

    fun setLike(like: Boolean) {
        _like.value = like
    }

    val noLike
        get() = _noLike

    fun setNoLike(noLike: Boolean) {
        _noLike.value = noLike
    }


    val allFilms
        get() = all

    fun setAllFilms(films: List<FilmDetailDto>) {
        all.value = films
    }


    val film
        get() = filmDetail

    fun setFilmDetail(film: FilmDetailDto) {
        filmDetail.value = film
    }


}