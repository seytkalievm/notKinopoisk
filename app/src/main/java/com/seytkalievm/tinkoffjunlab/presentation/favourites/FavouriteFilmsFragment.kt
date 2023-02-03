package com.seytkalievm.tinkoffjunlab.presentation.favourites

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.seytkalievm.tinkoffjunlab.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteFilmsFragment : Fragment() {


    private val viewModel: FavouriteFilmsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favourite_films, container, false)
    }



}