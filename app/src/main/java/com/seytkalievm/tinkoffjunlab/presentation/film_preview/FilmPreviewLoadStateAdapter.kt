package com.seytkalievm.tinkoffjunlab.presentation.film_preview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.seytkalievm.tinkoffjunlab.databinding.FilmPreviewLoadStateFooterBinding

class FilmPreviewLoadStateAdapter (private val retry: () -> Unit):
    LoadStateAdapter<FilmPreviewLoadStateAdapter.LoadStateViewHolder>() {

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        val binding = FilmPreviewLoadStateFooterBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return LoadStateViewHolder(binding)
    }

    inner class LoadStateViewHolder(private val binding: FilmPreviewLoadStateFooterBinding):
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.button.setOnClickListener { retry.invoke() }
        }
        fun bind(state: LoadState){
            binding.apply {
                progressBar2.isVisible = state is LoadState.Loading
                button.isVisible = state !is LoadState.Loading
                textView.isVisible = state is LoadState.Error
            }
        }
    }
}