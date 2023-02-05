package com.seytkalievm.tinkoffjunlab.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.seytkalievm.tinkoffjunlab.data.remote.KinopoiskApi
import com.seytkalievm.tinkoffjunlab.data.model.FilmPreview
import com.seytkalievm.tinkoffjunlab.data.paging.KinopoiskPagingSource
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "MainRepository"
@Singleton
class MainRepository @Inject constructor(
    private val api: KinopoiskApi
){
    fun getPopularFilms():LiveData<PagingData<FilmPreview>>{
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 200,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {KinopoiskPagingSource(api)}
        ).liveData
    }

}