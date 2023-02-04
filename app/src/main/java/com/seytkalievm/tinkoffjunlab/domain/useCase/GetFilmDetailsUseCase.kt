package com.seytkalievm.tinkoffjunlab.domain.useCase

import com.seytkalievm.tinkoffjunlab.data.model.FilmDetails
import com.seytkalievm.tinkoffjunlab.data.repository.LocalFilmsRepository
import com.seytkalievm.tinkoffjunlab.data.repository.RemoteFilmsRepository
import javax.inject.Inject

class GetFilmDetailsUseCase @Inject constructor(
    private val remoteRepo: RemoteFilmsRepository,
    private val localRepo: LocalFilmsRepository,
    ) {
    suspend operator fun invoke(id: Int, local: Boolean): FilmDetails {
        return if (local) localRepo.getFilmDetails(id) else remoteRepo.getFilmDetails(id)
    }
}