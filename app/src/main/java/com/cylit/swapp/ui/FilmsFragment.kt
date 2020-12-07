package com.cylit.swapp.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.cylit.swapp.R
import com.cylit.swapp.repositories.FilmRepository
import com.cylit.swapp.databinding.FragmentFilmsBinding
import com.cylit.swapp.factories.FilmViewModelFactory
import com.cylit.swapp.model.FilmDetailDto
import com.cylit.swapp.viewModels.FilmViewModel

class FilmsFragment : Fragment(R.layout.fragment_films) {

    lateinit var adapter: FilmsAdapter
    lateinit var binding: FragmentFilmsBinding

    private val viewModel by lazy {
        ViewModelProvider(requireActivity(),
            FilmViewModelFactory(FilmRepository())).get(FilmViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FilmsAdapter(object : FilmsAdapter.ClickItemListener {
            override fun onClick(film: FilmDetailDto) {
                val action = FilmsFragmentDirections.actionFilmDetail(film)
                val navController = Navigation.findNavController(view)
                navController.navigate(action)
            }
        }, viewLifecycleOwner)


        binding = DataBindingUtil.bind(view)!!
        binding.filmsRecyclerView.adapter = adapter
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        observerError()

        viewModel.getAll()
    }

    private fun observerError() {
        viewModel.requestError.observe(viewLifecycleOwner, {
            it?.let { Toast.makeText(requireActivity(), it, Toast.LENGTH_LONG).show() }
        })
    }
}