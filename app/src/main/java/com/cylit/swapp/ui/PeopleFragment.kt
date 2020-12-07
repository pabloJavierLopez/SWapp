package com.cylit.swapp.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cylit.swapp.R
import com.cylit.swapp.repositories.PeopleRepository
import com.cylit.swapp.databinding.FragmentPeopleBinding
import com.cylit.swapp.factories.PeopleViewModelFactory
import com.cylit.swapp.viewModels.PeopleViewModel

class PeopleFragment : Fragment(R.layout.fragment_people) {

    private val adapter = PeopleAdapter()

    private val viewModel by lazy {
        ViewModelProvider(this,
            PeopleViewModelFactory(PeopleRepository())).get(PeopleViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding: FragmentPeopleBinding = DataBindingUtil.bind(view)!!
        binding.peopleRecyclerView.adapter = adapter

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        observerError()
    }

    private fun observerError() {
        viewModel.requestError.observe(viewLifecycleOwner, {
            it?.let { Toast.makeText(requireActivity(), it, Toast.LENGTH_LONG).show() }
        })
    }
}