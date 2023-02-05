package com.seytkalievm.tinkoffjunlab.presentation.popular

import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.seytkalievm.tinkoffjunlab.domain.useCase.AddFilmToFavouritesUseCase
import com.seytkalievm.tinkoffjunlab.domain.useCase.GetPopularFilmsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularFilmsViewModel @Inject constructor(
    private val addFilmToFavouritesUseCase: AddFilmToFavouritesUseCase,
    getPopularFilmsUseCase: GetPopularFilmsUseCase
): ViewModel() {

    val pagedFilms = getPopularFilmsUseCase.invoke().cachedIn(viewModelScope)
    fun addToFavourites(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            addFilmToFavouritesUseCase(id)
        }
    }
}