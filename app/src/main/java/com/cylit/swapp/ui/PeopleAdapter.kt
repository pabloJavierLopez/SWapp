package com.cylit.swapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cylit.swapp.R
import com.cylit.swapp.model.PeopleDto
import java.text.DecimalFormat
import java.util.*

class PeopleAdapter : RecyclerView.Adapter<PeopleAdapter.View>() {
    private var planetas: List<PeopleDto> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): View {
        val v: android.view.View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_people, parent, false)
        return View(v)
    }

    override fun onBindViewHolder(holder: View, position: Int) {
        val person = planetas[position]

        holder.txtNombre.text = person.name
        holder.txtGender.text = person.gender
        holder.txtSkinColor.text = person.skin_color
    }

    fun setItems(_detalle: List<PeopleDto>) {
        planetas = _detalle
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return planetas.size
    }

    class View(itemView: android.view.View) : RecyclerView.ViewHolder(itemView) {
        val txtNombre: TextView = itemView.findViewById(R.id.txtName)
        val txtGender: TextView = itemView.findViewById(R.id.txtGender)
        val txtSkinColor: TextView = itemView.findViewById(R.id.txtSkinColor)
    }
}