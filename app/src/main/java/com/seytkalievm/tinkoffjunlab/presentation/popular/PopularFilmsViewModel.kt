package com.seytkalievm.tinkoffjunlab.presentation.popular

import android.util.Log
import androidx.lifecycle.*
import androidx.paging.cachedIn
import androidx.paging.filter
import com.seytkalievm.tinkoffjunlab.data.repository.MainRepository
import com.seytkalievm.tinkoffjunlab.domain.useCase.AddFilmToFavouritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "PopularFilmsViewModel"
@HiltViewModel
class PopularFilmsViewModel @Inject constructor(
    private val addFilmToFavouritesUseCase: AddFilmToFavouritesUseCase,
    private val mainRepository: MainRepository,
): ViewModel() {

    val pagedFilms = mainRepository.getPopularFilms().cachedIn(viewModelScope)
    fun addToFavourites(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            addFilmToFavouritesUseCase(id)
        }
    }
}