package com.seytkalievm.tinkoffjunlab.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seytkalievm.tinkoffjunlab.data.model.FilmDetails
import com.seytkalievm.tinkoffjunlab.domain.useCase.GetFilmDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FilmDetailsViewModel @Inject constructor(
    private val getFilmDetailsUseCase: GetFilmDetailsUseCase
): ViewModel() {
    private val _filmDetails = MutableLiveData<FilmDetails>()
    val filmDetails: LiveData<FilmDetails> get() = _filmDetails

    fun getFilmDetails(id: Int) {
        viewModelScope.launch (Dispatchers.IO) {
            delay(500)
            _filmDetails.postValue(getFilmDetailsUseCase.invoke(id))
        }
    }
}