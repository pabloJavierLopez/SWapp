package com.cylit.swapp.network

import com.cylit.swapp.model.PlanetDto
import com.cylit.swapp.model.ResponseApi
import retrofit2.Call
import retrofit2.http.GET

interface ApiPlanetService {

    @GET("planets/")
    fun getAll(): Call<ResponseApi<PlanetDto>>

}