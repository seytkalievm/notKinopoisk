package com.seytkalievm.tinkoffjunlab.data.repository

import com.seytkalievm.tinkoffjunlab.data.datasource.KinopoiskApi
import com.seytkalievm.tinkoffjunlab.data.model.FilmDetails
import com.seytkalievm.tinkoffjunlab.data.model.FilmPreview
import javax.inject.Inject


class RemoteFilmsRepository @Inject constructor(private val api: KinopoiskApi) {
    suspend fun getTop100Films(page: Int): List<FilmPreview> {
        return api.getTop100Films(page).films
    }

    suspend fun getFilmDetails(id: Int): FilmDetails {
        return api.getFilmDetails(id)
    }
}