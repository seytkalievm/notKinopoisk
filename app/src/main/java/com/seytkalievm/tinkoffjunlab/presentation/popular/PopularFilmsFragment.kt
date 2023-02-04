package com.seytkalievm.tinkoffjunlab.presentation.popular

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.seytkalievm.tinkoffjunlab.databinding.FragmentPopularFilmsBinding
import com.seytkalievm.tinkoffjunlab.presentation.film_preview.FilmPreviewAdapter
import com.seytkalievm.tinkoffjunlab.presentation.film_preview.FilmPreviewItemDiffCalculator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularFilmsFragment : Fragment() {

    private lateinit var binding: FragmentPopularFilmsBinding
    private val viewModel: PopularFilmsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPopularFilmsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.filmsRv.layoutManager = LinearLayoutManager(requireContext())
        val adapter = FilmPreviewAdapter(
            FilmPreviewItemDiffCalculator(),
            { showDetails(it) }, {addToFavourites(it)})
        binding.filmsRv.adapter = adapter

        viewModel.films.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun showDetails(id: Int) {
        val action = PopularFilmsFragmentDirections
            .actionPopularFilmsFragmentToFilmDetailsFragment(id)
        action.local = false
        findNavController().navigate(action)
    }

    private fun addToFavourites(id: Int) {
        viewModel.addToFavourites(id)
    }
}