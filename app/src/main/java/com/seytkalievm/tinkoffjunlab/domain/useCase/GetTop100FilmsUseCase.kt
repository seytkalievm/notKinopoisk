package com.seytkalievm.tinkoffjunlab.domain.useCase

import com.seytkalievm.tinkoffjunlab.data.model.FilmPreview
import com.seytkalievm.tinkoffjunlab.data.repository.RemoteFilmsRepository
import javax.inject.Inject


class GetTop100FilmsUseCase @Inject constructor(private val repo: RemoteFilmsRepository ) {
    suspend operator fun invoke(page: Int): List<FilmPreview> {
        return repo.getTop100Films(page)
    }

}