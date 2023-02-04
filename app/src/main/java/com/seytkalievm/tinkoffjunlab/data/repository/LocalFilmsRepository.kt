package com.seytkalievm.tinkoffjunlab.data.repository

import com.seytkalievm.tinkoffjunlab.data.datasource.FilmsDao
import com.seytkalievm.tinkoffjunlab.data.model.FilmDetails
import com.seytkalievm.tinkoffjunlab.data.model.FilmPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalFilmsRepository @Inject constructor(private val dao: FilmsDao) {

    suspend fun insertFilm(film: FilmDetails) {
        dao.insertFilm(film)
    }

    suspend fun deleteFilm(id: Int) {
        dao.deleteFilm(id)
    }

    fun getAllFilms(): Flow<List<FilmPreview>> {
        return dao.getAllFilms().map {list ->
            list.map { it.toPreview() }
        }
    }
}