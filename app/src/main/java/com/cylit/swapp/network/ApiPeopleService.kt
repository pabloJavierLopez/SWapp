package com.cylit.swapp.network

import com.cylit.swapp.model.PeopleDto
import com.cylit.swapp.model.ResponseApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiPeopleService {

    @GET("people/")
    fun getAll(): Call<ResponseApi<PeopleDto>>

}