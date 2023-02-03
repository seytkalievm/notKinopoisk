package com.seytkalievm.tinkoffjunlab.presentation.film_preview

import androidx.recyclerview.widget.DiffUtil
import com.seytkalievm.tinkoffjunlab.data.model.FilmPreview

class FilmPreviewItemDiffCalculator: DiffUtil.ItemCallback<FilmPreview>() {
    override fun areItemsTheSame(oldItem: FilmPreview, newItem: FilmPreview): Boolean {
        return oldItem.filmId == newItem.filmId
    }

    override fun areContentsTheSame(oldItem: FilmPreview, newItem: FilmPreview): Boolean {
        return oldItem == newItem
    }
}