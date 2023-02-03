package com.seytkalievm.tinkoffjunlab.presentation.film_preview

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.seytkalievm.tinkoffjunlab.R
import com.seytkalievm.tinkoffjunlab.data.model.FilmPreview
import com.seytkalievm.tinkoffjunlab.databinding.FilmPreviewBinding

class FilmPreviewViewHolder(private val binding: FilmPreviewBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: FilmPreview) {

        binding.apply {
            nameRuTv.text = item.nameRu
            yearTv.text = item.year
            genresTv.text = item.genres.joinToString(", ")
            item.posterUrlPreview?.let { url ->
                Glide.with(binding.root.context)
                    .load(url)
                    .placeholder(R.drawable.ic_baseline_hide_image_24)
                    .into(binding.posterPreviewIv)
            }
        }

    }
}