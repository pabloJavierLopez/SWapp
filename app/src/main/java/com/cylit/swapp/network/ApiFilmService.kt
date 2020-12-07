package com.cylit.swapp.network

import com.cylit.swapp.model.FilmDetailDto
import com.cylit.swapp.model.ResponseApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiFilmService {

    @GET("films/")
    fun getAll(): Call<ResponseApi<FilmDetailDto>>

    @GET("films/{id}")
    fun getById(@Path("id") id: String): Call<FilmDetailDto>

}