package com.seytkalievm.tinkoffjunlab.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.paging.*
import com.seytkalievm.tinkoffjunlab.data.local.FilmsDao
import com.seytkalievm.tinkoffjunlab.data.model.FilmDetails
import com.seytkalievm.tinkoffjunlab.data.model.FilmPreview
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalFilmsRepository @Inject constructor(private val dao: FilmsDao) {

    suspend fun insertFilm(film: FilmDetails) {
        dao.insertFilm(film)
    }

    suspend fun deleteFilm(id: Int) {
        dao.deleteFilm(id)
    }

    suspend fun getFilmDetails(id: Int): FilmDetails {
        return dao.getFilmDetails(id)
    }

    fun getSavedFilms(): LiveData<PagingData<FilmPreview>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 200,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { dao.getAllFilms() }
        ).flow.map {pagingData-> pagingData.map { it.toPreview() } }.asLiveData()
    }

}