package com.seytkalievm.tinkoffjunlab.domain.useCase

import com.seytkalievm.tinkoffjunlab.data.repository.LocalFilmsRepository
import javax.inject.Inject

class RemoveFilmFromFavouritesUseCase @Inject constructor(private val repo: LocalFilmsRepository) {
    suspend operator fun invoke(id: Int) {
        repo.deleteFilm(id)
    }
}