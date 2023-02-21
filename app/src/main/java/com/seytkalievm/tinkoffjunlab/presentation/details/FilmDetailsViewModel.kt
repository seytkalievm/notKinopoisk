package com.seytkalievm.tinkoffjunlab.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seytkalievm.tinkoffjunlab.data.model.FilmDetails
import com.seytkalievm.tinkoffjunlab.domain.useCase.GetFilmDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FilmDetailsViewModel @Inject constructor(
    private val getFilmDetailsUseCase: GetFilmDetailsUseCase
): ViewModel() {
    private var _filmDetails: FilmDetails? = null
    val filmDetails: FilmDetails get() = _filmDetails!!

    private val _state = MutableLiveData(LoadState.LOADING)
    val state: LiveData<LoadState> get() = _state

    fun getFilmDetails(id: Int, local: Boolean) {
        _state.postValue(LoadState.LOADING)
        viewModelScope.launch (Dispatchers.IO) {
            try {
                _filmDetails = getFilmDetailsUseCase.invoke(id, local)
                _state.postValue(LoadState.SUCCESS)
            } catch (e: Exception) {
                _state.postValue(LoadState.ERROR)
            }
        }
    }
}