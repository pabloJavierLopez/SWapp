package com.cylit.swapp.repositories

import com.cylit.swapp.model.PeopleDto
import com.cylit.swapp.network.ApiSwAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PeopleRepository /*@Inject constructor() */ : IPeopleRepository {

    override suspend fun getAll(): List<PeopleDto> {
        var people: List<PeopleDto>? = null
        withContext(Dispatchers.IO) {
            val response = ApiSwAdapter.peopleService.getAll().execute()
            if (!response.isSuccessful)
                throw Exception(response.message())
            people = response.body()!!.results
        }

        return people!!
    }

}