package com.cylit.swapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.cylit.swapp.R
import com.cylit.swapp.databinding.ItemPlanetaBinding
import com.cylit.swapp.model.PlanetDto

class PlanetsAdapter(_lifecycleOwner: LifecycleOwner) :
    RecyclerView.Adapter<PlanetsAdapter.View>() {
    private var planetas: List<PlanetDto> = listOf()
    private var lifecycleOwner = _lifecycleOwner
    lateinit var binding: ItemPlanetaBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): View {
        val v: android.view.View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_planeta, parent, false)
        binding = DataBindingUtil.bind(v)!!
        binding.lifecycleOwner = lifecycleOwner
        return View(binding.root)
    }

    override fun onBindViewHolder(holder: View, position: Int) {
        val planet = planetas[position]
        binding.planet = planet
    }

    fun setItems(_detalle: MutableList<PlanetDto>) {
        planetas = _detalle
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return planetas.size
    }

    class View(itemView: android.view.View) : RecyclerView.ViewHolder(itemView)
}