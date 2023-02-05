package com.seytkalievm.tinkoffjunlab.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.seytkalievm.tinkoffjunlab.data.model.FilmDetails


@Dao
interface FilmsDao {

    @Insert
    suspend fun insertFilm(film: FilmDetails)

    @Query("DELETE FROM favourite_films WHERE id = :id")
    suspend fun deleteFilm(id: Int)

    @Query("SELECT * FROM favourite_films")
    fun getAllFilms(): PagingSource<Int, FilmDetails>

    @Query("SELECT * FROM favourite_films WHERE id = :id")
    suspend fun getFilmDetails(id: Int): FilmDetails

    @Query("SELECT EXISTS(SELECT * FROM favourite_films WHERE id =:id)")
    suspend fun hasItem(id: Int): Boolean
}