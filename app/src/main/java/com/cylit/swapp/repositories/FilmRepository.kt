package com.cylit.swapp.repositories

import com.cylit.swapp.model.FilmDetailDto
import com.cylit.swapp.network.ApiSwAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FilmRepository : IFilmRepository {

    override suspend fun getAll(): List<FilmDetailDto> {
        var films: List<FilmDetailDto>? = null
        withContext(Dispatchers.IO) {
            val response = ApiSwAdapter.filmService.getAll().execute()
            if (!response.isSuccessful)
                throw Exception(response.message())
            films = response.body()!!.results
        }

        return films!!
    }

    override suspend fun like(id: Int): Boolean {
        var ok = false
        withContext(Dispatchers.IO) {
            Thread.sleep(1500)
            ok = true
        }
        return ok
    }


    override suspend fun noLike(id: Int): Boolean {
        var ok = false
        withContext(Dispatchers.IO) {
            Thread.sleep(1500)
            ok = true
        }
        return ok
    }

}