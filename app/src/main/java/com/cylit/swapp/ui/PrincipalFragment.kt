package com.cylit.swapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cylit.swapp.R
import com.cylit.swapp.databinding.FragmentPrincipalBinding

class PrincipalFragment : Fragment(R.layout.fragment_principal) {

    private lateinit var binding: FragmentPrincipalBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPrincipalBinding.bind(view)

        actionsButtons()
    }

    private fun actionsButtons() {
        binding.btnPlanets.setOnClickListener {
            irAPlanetas()
        }

        binding.btnFilms.setOnClickListener {
            irAFilms()
        }

        binding.btnPeople.setOnClickListener {
            irAPeople()
        }
    }

    private fun irAPlanetas() {
        findNavController().navigate(R.id.planetsFragment)
    }

    private fun irAFilms() {
        findNavController().navigate(R.id.filmFragment)
    }

    private fun irAPeople() {
        findNavController().navigate(R.id.peopleFragment)
    }

}