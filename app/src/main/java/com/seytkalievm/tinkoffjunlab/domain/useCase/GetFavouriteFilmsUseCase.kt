package com.seytkalievm.tinkoffjunlab.domain.useCase

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.seytkalievm.tinkoffjunlab.data.model.FilmPreview
import com.seytkalievm.tinkoffjunlab.data.repository.LocalFilmsRepository
import javax.inject.Inject

class GetFavouriteFilmsUseCase @Inject constructor(private val repo: LocalFilmsRepository){
    operator fun invoke(): LiveData<List<FilmPreview>>{
        return repo.getAllFilms().asLiveData()
    }
}