package com.seytkalievm.tinkoffjunlab.domain.useCase

import android.database.sqlite.SQLiteConstraintException
import com.seytkalievm.tinkoffjunlab.data.repository.LocalFilmsRepository
import javax.inject.Inject

class AddFilmToFavouritesUseCase @Inject constructor(
    private val getFilmDetailsUseCase: GetFilmDetailsUseCase,
    private val repo: LocalFilmsRepository
    ){
    suspend operator fun invoke(id: Int) {
        val film = getFilmDetailsUseCase(id, false)
        try {
            repo.insertFilm(film)
        } catch (_: SQLiteConstraintException){}
    }
}