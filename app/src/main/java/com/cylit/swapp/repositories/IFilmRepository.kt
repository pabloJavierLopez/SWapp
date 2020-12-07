package com.cylit.swapp.repositories

import com.cylit.swapp.model.FilmDetailDto

interface IFilmRepository {

    suspend fun getAll(): List<FilmDetailDto>

    suspend fun like(id: Int): Boolean

    suspend fun noLike(id: Int): Boolean

}