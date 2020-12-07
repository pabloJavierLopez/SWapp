package com.cylit.swapp.repositories

import com.cylit.swapp.model.PlanetDto

interface IPlanetRepository {

    suspend fun getAll(): List<PlanetDto>

}

