package com.seytkalievm.tinkoffjunlab.presentation.popular

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Transformations
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.flatMap
import androidx.recyclerview.widget.LinearLayoutManager
import com.seytkalievm.tinkoffjunlab.R
import com.seytkalievm.tinkoffjunlab.databinding.FragmentPopularFilmsBinding
import com.seytkalievm.tinkoffjunlab.presentation.film_preview.FilmPreviewAdapter
import com.seytkalievm.tinkoffjunlab.presentation.film_preview.FilmPreviewItemDiffCalculator
import com.seytkalievm.tinkoffjunlab.presentation.film_preview.FilmPreviewLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

private const val TAG = "PopularFilmsFragment"
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
            { showDetails(it) }, {addToFavourites(it)}
        )

        binding.filmsRv.adapter = adapter.withLoadStateHeaderAndFooter(
            header = FilmPreviewLoadStateAdapter{adapter.retry()},
            footer = FilmPreviewLoadStateAdapter{adapter.retry()}
        )
        binding.button2.setOnClickListener {
            adapter.retry()
        }

        viewModel.pagedFilms.observe(viewLifecycleOwner) {
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            adapter.loadStateFlow.collectLatest { loadState ->
                binding.progressBar.isVisible = loadState.refresh is LoadState.Loading
                binding.internetConnectionError.isVisible = loadState.refresh is LoadState.Error
                binding.filmsRv.isVisible = loadState.refresh !is LoadState.Error &&
                        loadState.refresh !is LoadState.Loading
            }
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