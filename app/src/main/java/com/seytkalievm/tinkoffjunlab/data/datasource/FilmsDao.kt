package com.seytkalievm.tinkoffjunlab.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.seytkalievm.tinkoffjunlab.data.model.FilmDetails
import kotlinx.coroutines.flow.Flow


@Dao
interface FilmsDao {

    @Insert
    suspend fun insertFilm(film: FilmDetails)

    @Query("DELETE FROM favourite_films WHERE id = :id")
    suspend fun deleteFilm(id: Int)

    @Query("SELECT * FROM favourite_films")
    fun getAllFilms(): Flow<List<FilmDetails>>

    @Query("SELECT * FROM favourite_films WHERE id = :id")
    suspend fun getFilmDetails(id: Int): FilmDetails

}