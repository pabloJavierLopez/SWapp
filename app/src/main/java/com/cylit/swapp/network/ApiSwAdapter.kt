package com.cylit.swapp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiSwAdapter {

    private const val BASE_URL = "https://swapi.dev/api/"

    private fun retrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client)
            .build()
    }

    val planetService: ApiPlanetService by lazy {
        retrofit().create(ApiPlanetService::class.java)
    }

    val filmService: ApiFilmService by lazy {
        retrofit().create(ApiFilmService::class.java)
    }

    val peopleService: ApiPeopleService by lazy {
        retrofit().create(ApiPeopleService::class.java)
    }

}