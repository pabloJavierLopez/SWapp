package com.cylit.swapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlanetDto(
    val name: String,
    val climate: String,
    val terrain: String,
    val population: String
) : Parcelable