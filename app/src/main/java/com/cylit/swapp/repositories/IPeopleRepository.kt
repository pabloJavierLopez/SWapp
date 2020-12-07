package com.cylit.swapp.repositories

import com.cylit.swapp.model.PeopleDto

interface IPeopleRepository {

    suspend fun getAll(): List<PeopleDto>
}