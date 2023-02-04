package com.seytkalievm.tinkoffjunlab.domain.useCase

import com.seytkalievm.tinkoffjunlab.data.model.FilmDetails
import com.seytkalievm.tinkoffjunlab.data.repository.RemoteFilmsRepository
import javax.inject.Inject

class GetFilmDetailsUseCase @Inject constructor(private val repository: RemoteFilmsRepository) {
    suspend operator fun invoke(id: Int): FilmDetails {
        return repository.getFilmDetails(id)
    }
}