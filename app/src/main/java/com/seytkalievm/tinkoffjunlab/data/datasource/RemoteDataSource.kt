package com.seytkalievm.tinkoffjunlab.data.datasource

import com.seytkalievm.tinkoffjunlab.data.model.FilmDetails
import com.seytkalievm.tinkoffjunlab.data.model.FilmPreview
import com.seytkalievm.tinkoffjunlab.data.model.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface KinopoiskApi {
    @GET("top?type=TOP_100_POPULAR_FILMS")
    suspend fun getTop100Films(@Query("page") page: Int): Response

    @GET("{id}")
    suspend fun getFilmDetails(@Path("id") id: Int): FilmDetails
}