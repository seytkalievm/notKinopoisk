package com.seytkalievm.tinkoffjunlab.data.repository

import com.seytkalievm.tinkoffjunlab.data.remote.KinopoiskApi
import com.seytkalievm.tinkoffjunlab.data.model.FilmDetails
import com.seytkalievm.tinkoffjunlab.data.model.FilmPreview
import javax.inject.Inject


class RemoteFilmsRepository @Inject constructor(private val api: KinopoiskApi) {
    suspend fun getFilmDetails(id: Int): FilmDetails {
        return api.getFilmDetails(id)
    }
}