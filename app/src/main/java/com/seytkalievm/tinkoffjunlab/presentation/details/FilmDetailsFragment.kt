package com.seytkalievm.tinkoffjunlab.presentation.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.seytkalievm.tinkoffjunlab.R
import com.seytkalievm.tinkoffjunlab.data.model.FilmDetails
import com.seytkalievm.tinkoffjunlab.databinding.FragmentFilmDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmDetailsFragment : Fragment() {

    private val viewModel: FilmDetailsViewModel by viewModels()
    private lateinit var binding: FragmentFilmDetailsBinding
    private val args: FilmDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilmDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = args.id
        val local = args.local
        val detailsLayout = binding.filmDetails
        detailsLayout.visibility = View.GONE
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        val shimmerLayout = binding.shimmerLayout
        shimmerLayout.startShimmer()

        viewModel.getFilmDetails(id, local)

        viewModel.filmDetails.observe(viewLifecycleOwner) {
            shimmerLayout.stopShimmer()
            shimmerLayout.visibility = View.GONE
            bindFilmDetails(it)
            binding.filmDetails.visibility = View.VISIBLE

        }

    }

    private fun bindFilmDetails(details: FilmDetails) {
        binding.filmDetailsLayout.apply {
            Glide.with(binding.root.context)
                .load(details.posterUrl)
                .placeholder(R.drawable.ic_baseline_hide_image_24)
                .into(filmDetailsPosterIv)
            filmDetailsTitleTv.text = details.nameRu
            filmDetailsDescriptionTv.text = details.description
            filmDetailsCountryTv.text = details.countries.joinToString(", ")
            filmDetailsGenresTv.text = details.genres.joinToString(", ")
            filmDetailsYearTv.text = details.year.toString()
        }

    }

}