package com.seytkalievm.tinkoffjunlab.domain.useCase

import com.seytkalievm.tinkoffjunlab.data.model.FilmPreview
import com.seytkalievm.tinkoffjunlab.data.repository.FilmsRepository
import javax.inject.Inject

private const val TAG = "USECASE"

class GetTop100FilmsUseCase @Inject constructor(private val repo: FilmsRepository ) {
    suspend operator fun invoke(page: Int): List<FilmPreview> {
        return repo.getTop100Films(page)
    }

}