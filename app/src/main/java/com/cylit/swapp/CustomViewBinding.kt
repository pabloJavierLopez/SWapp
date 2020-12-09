package com.cylit.swapp

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cylit.swapp.model.FilmDetailDto
import com.cylit.swapp.model.PeopleDto
import com.cylit.swapp.model.PlanetDto
import com.cylit.swapp.ui.FilmsAdapter
import com.cylit.swapp.ui.PeopleAdapter
import com.cylit.swapp.ui.PlanetsAdapter
import java.util.*

@BindingAdapter(value = ["setAdapter"])
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    this.run {
        this.setHasFixedSize(true)
        this.adapter = adapter
    }
}

@BindingAdapter("dataPlanets")
fun setRecyclerViewProperties(recyclerView: RecyclerView?, data: MutableList<PlanetDto>?) {
    val adapter = recyclerView?.adapter
    if (adapter is PlanetsAdapter && data != null) {
        adapter.setItems(data)
    }
}

@BindingAdapter("dataFilms")
fun setRecyclerViewFilms(recyclerView: RecyclerView?, data: MutableList<FilmDetailDto>?) {
    val adapter = recyclerView?.adapter
    if (adapter is FilmsAdapter && data != null) {
        adapter.setItems(data)
    }
}

@BindingAdapter("dataPeople")
fun setRecyclerViewPeople(recyclerView: RecyclerView?, data: MutableList<PeopleDto>?) {
    val adapter = recyclerView?.adapter
    if (adapter is PeopleAdapter && data != null) {
        adapter.setItems(data)
    }
}

@BindingAdapter("numberFormatted")
fun TextView.setNumberFormatted(numero: String?) {
    numero?.let {
        text = separatorNumber(it)
    }
}

@BindingAdapter("booleanToVisibility")
fun View.visibilityByBoolean(bool: Boolean?) {
    bool?.let {
        visibility = booleanToVisibility(it)
    }
}

@BindingAdapter("formatDate")
fun TextView.formatDate(date: Date?) {
    date?.let {
        text = stringFormatDate(it)
    }
}