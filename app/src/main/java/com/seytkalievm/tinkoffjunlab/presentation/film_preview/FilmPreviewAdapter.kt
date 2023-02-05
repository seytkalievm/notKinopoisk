package com.seytkalievm.tinkoffjunlab.presentation.film_preview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.seytkalievm.tinkoffjunlab.data.model.FilmPreview
import com.seytkalievm.tinkoffjunlab.databinding.FilmPreviewBinding

private const val TAG = "FilmPreviewAdapter"
class FilmPreviewAdapter constructor(
    filmPreviewItemDiffCalculator: FilmPreviewItemDiffCalculator,
    private val onClickListener: (Int) -> Unit,
    private val onLongClickListener: (Int) -> Unit,
    ) : PagingDataAdapter<FilmPreview, FilmPreviewViewHolder>(filmPreviewItemDiffCalculator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmPreviewViewHolder {
        val binding =
            FilmPreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmPreviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmPreviewViewHolder, position: Int) {
        val item = getItem(position) ?: return
        holder.bind(item)
        holder.itemView.setOnClickListener { onClickListener(item.filmId) }
        holder.itemView.setOnLongClickListener {
            Log.i(TAG, "onBindViewHolder: LongClick")
            Log.i(TAG, "onBindViewHolder: ${item.filmId}")
            onLongClickListener(item.filmId)
            true
        }
    }
}