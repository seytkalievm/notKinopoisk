package com.seytkalievm.tinkoffjunlab.presentation.favourites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.seytkalievm.tinkoffjunlab.domain.useCase.GetFavouriteFilmsUseCase
import com.seytkalievm.tinkoffjunlab.domain.useCase.RemoveFilmFromFavouritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteFilmsViewModel @Inject constructor(
    getFavouriteFilmsUseCase: GetFavouriteFilmsUseCase,
    private val deleteFromFavouritesUseCase: RemoveFilmFromFavouritesUseCase
): ViewModel() {

    val films = getFavouriteFilmsUseCase.invoke().cachedIn(viewModelScope)

    fun deleteFromFavourites(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteFromFavouritesUseCase(id)
        }
    }
}