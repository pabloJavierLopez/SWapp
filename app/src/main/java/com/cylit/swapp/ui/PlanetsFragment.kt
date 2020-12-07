package com.cylit.swapp.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cylit.swapp.R
import com.cylit.swapp.repositories.PlanetRepository
import com.cylit.swapp.databinding.FragmentPlanetsBinding
import com.cylit.swapp.factories.PlanetViewModelFactory
import com.cylit.swapp.viewModels.PlanetViewModel

class PlanetsFragment : Fragment(R.layout.fragment_planets) {

    lateinit var adapter: PlanetsAdapter
    lateinit var binding: FragmentPlanetsBinding

    private val viewModel by lazy {
        ViewModelProvider(this,
            PlanetViewModelFactory(PlanetRepository())).get(PlanetViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PlanetsAdapter(viewLifecycleOwner)
        binding = DataBindingUtil.bind(view)!!
        binding.planetsRecyclerView.adapter = adapter
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        observerError()

        /* viewModel.loading.observe(viewLifecycleOwner, {
             it?.let {
                 if (it) {
                     binding.progressBar.visibility = View.VISIBLE
                 } else {
                     binding.progressBar.visibility = View.GONE
                 }
             }
         })*/
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
/*        (requireActivity().application as SwApplication).appComponent.addPlanetComponent()
            .create().inject(this)*/
    }

    private fun observerError() {
        viewModel.requestError.observe(viewLifecycleOwner, {
            it?.let { Toast.makeText(requireActivity(), it, Toast.LENGTH_LONG).show() }
        })
    }
}