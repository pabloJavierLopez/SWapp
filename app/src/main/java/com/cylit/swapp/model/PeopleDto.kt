package com.cylit.swapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PeopleDto(
    val name: String,
    val gender: String,
    val skin_color: String,
) : Parcelable
