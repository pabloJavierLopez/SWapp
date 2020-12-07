package com.cylit.swapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FilmDto(
    val title: String,
    val episode_id: Int,
    val release_date: String,
    val opening_crawl: String,
    val director: String,
) : Parcelable
