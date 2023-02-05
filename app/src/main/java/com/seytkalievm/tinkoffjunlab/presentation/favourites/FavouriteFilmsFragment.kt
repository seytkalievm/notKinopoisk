package com.seytkalievm.tinkoffjunlab.presentation.favourites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.seytkalievm.tinkoffjunlab.databinding.FragmentFavouriteFilmsBinding
import com.seytkalievm.tinkoffjunlab.presentation.film_preview.FilmPreviewAdapter
import com.seytkalievm.tinkoffjunlab.presentation.film_preview.FilmPreviewItemDiffCalculator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteFilmsFragment : Fragment() {


    private val viewModel: FavouriteFilmsViewModel by viewModels()
    private lateinit var binding: FragmentFavouriteFilmsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavouriteFilmsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = FilmPreviewAdapter(
            FilmPreviewItemDiffCalculator(), {showDetails(it)}, {deleteFromFavourites(it)}
        )
        binding.fragmentFavouriteFilmsFilmsRv.layoutManager = LinearLayoutManager(requireContext())
        binding.fragmentFavouriteFilmsFilmsRv.adapter = adapter
        viewModel.films.observe(viewLifecycleOwner) {
            //adapter.submitList(it)
        }
    }

    private fun showDetails(id: Int) {
        val action = FavouriteFilmsFragmentDirections
            .actionFavouriteFilmsFragmentToFilmDetailsFragment(id)
        action.local = true
        findNavController().navigate(action)
    }

    private fun deleteFromFavourites(id: Int) {
        viewModel.deleteFromFavourites(id)
    }
}