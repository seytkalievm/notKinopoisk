package com.seytkalievm.tinkoffjunlab.domain.useCase

import com.seytkalievm.tinkoffjunlab.data.repository.RemoteFilmsRepository
import javax.inject.Inject

class GetPopularFilmsUseCase @Inject constructor(
    private val remoteFilmsRepository: RemoteFilmsRepository){
    operator fun invoke() = remoteFilmsRepository.getPopularFilms()

}