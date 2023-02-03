package com.seytkalievm.tinkoffjunlab.presentation.film_preview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.seytkalievm.tinkoffjunlab.data.model.FilmPreview
import com.seytkalievm.tinkoffjunlab.databinding.FilmPreviewBinding

class FilmPreviewAdapter constructor(
    filmPreviewItemDiffCalculator: FilmPreviewItemDiffCalculator
)
    : ListAdapter<FilmPreview, FilmPreviewViewHolder>(filmPreviewItemDiffCalculator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmPreviewViewHolder {
        return FilmPreviewViewHolder(FilmPreviewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: FilmPreviewViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}