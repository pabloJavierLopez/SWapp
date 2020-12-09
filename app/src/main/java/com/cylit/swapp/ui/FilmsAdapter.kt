package com.cylit.swapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.cylit.swapp.R
import com.cylit.swapp.databinding.ItemFilmBinding
import com.cylit.swapp.model.FilmDetailDto

class FilmsAdapter(_clickListener: ClickItemListener, _lifecycleOwner: LifecycleOwner) :
    RecyclerView.Adapter<FilmsAdapter.View>() {
    private var films: List<FilmDetailDto> = listOf()
    private var clickListener: ClickItemListener = _clickListener
    lateinit var binding: ItemFilmBinding
    private var lifecycleOwner = _lifecycleOwner

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): View {
        val v: android.view.View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_film, parent, false)
        binding = DataBindingUtil.bind(v)!!
        binding.lifecycleOwner = lifecycleOwner
        binding.itemClickListener = clickListener
        return View(binding.root)
    }

    override fun onBindViewHolder(holder: View, position: Int) {
        val film = films[position]
        binding.film = film
    }

    fun setItems(_detalle: List<FilmDetailDto>) {
        films = _detalle
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return films.size
    }

    class View(itemView: android.view.View) : RecyclerView.ViewHolder(itemView)

    interface ClickItemListener {
        fun onClick(film: FilmDetailDto)
    }
}