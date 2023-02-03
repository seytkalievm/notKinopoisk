package com.seytkalievm.tinkoffjunlab.presentation.popular

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.seytkalievm.tinkoffjunlab.databinding.FragmentPopularFilmsBinding
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


}