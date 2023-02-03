package com.seytkalievm.tinkoffjunlab.presentation.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seytkalievm.tinkoffjunlab.data.model.FilmPreview
import com.seytkalievm.tinkoffjunlab.domain.useCase.GetTop100FilmsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularFilmsViewModel @Inject constructor(
    private val getTop100FilmsUseCase: GetTop100FilmsUseCase
): ViewModel() {
    private val _films = MutableLiveData<List<FilmPreview>>()
    val films: LiveData<List<FilmPreview>> get() = _films

    init {
        getFilms()
    }

    private fun getFilms() {
        viewModelScope.launch(Dispatchers.IO) {
            _films.postValue(getTop100FilmsUseCase.invoke(1))
        }
    }
}