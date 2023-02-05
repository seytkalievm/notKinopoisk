package com.seytkalievm.tinkoffjunlab.domain.useCase

import com.seytkalievm.tinkoffjunlab.data.repository.LocalFilmsRepository
import javax.inject.Inject

class GetFavouriteFilmsUseCase @Inject constructor(private val repo: LocalFilmsRepository){
    operator fun invoke() = repo.getSavedFilms()
}