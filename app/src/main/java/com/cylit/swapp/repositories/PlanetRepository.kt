package com.cylit.swapp.repositories

import com.cylit.swapp.model.PlanetDto
import com.cylit.swapp.network.ApiSwAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PlanetRepository : IPlanetRepository {

    override suspend fun getAll(): List<PlanetDto> {
        var planeta: List<PlanetDto>? = null
        withContext(Dispatchers.IO) {
            val response = ApiSwAdapter.planetService.getAll().execute()
            if (!response.isSuccessful)
                throw Exception(response.errorBody().toString())
            planeta = response.body()!!.results
        }

        return planeta!!
    }

}