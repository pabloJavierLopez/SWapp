package com.cylit.swapp.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.cylit.swapp.R
import com.cylit.swapp.databinding.FragmentFilmDetailBinding
import com.cylit.swapp.factories.FilmViewModelFactory
import com.cylit.swapp.repositories.FilmRepository
import com.cylit.swapp.viewModels.FilmViewModel

class FilmDetailFragment : Fragment(R.layout.fragment_film_detail) {

    private val viewModel by lazy {
        ViewModelProvider(requireActivity(),
            FilmViewModelFactory(FilmRepository())).get(FilmViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding: FragmentFilmDetailBinding = DataBindingUtil.bind(view)!!
        val args = FilmDetailFragmentArgs.fromBundle(requireArguments())
        viewModel.setFilmDetail(args.film)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        viewModel.like.observe(viewLifecycleOwner, {
            it?.let {
                if (it) {
                    val navController = Navigation.findNavController(view)
                    navController.navigate(R.id.actionLike)
                    viewModel.setLike(false)
                    viewModel.setNoLike(false)
                }
            }
        })


        viewModel.noLike.observe(viewLifecycleOwner, {
            it?.let {
                if (it) {
                    val navController = Navigation.findNavController(view)
                    navController.navigate(R.id.actionNoLike)
                    viewModel.setLike(false)
                    viewModel.setNoLike(false)
                }
            }
        })
    }
}