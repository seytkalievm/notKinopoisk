package com.seytkalievm.tinkoffjunlab.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite_films")
data class FilmDetails(
    @ColumnInfo val completed: Boolean,
    @ColumnInfo val countries: List<Country>,
    @ColumnInfo val coverUrl: String?,
    @ColumnInfo val description: String?,
    @ColumnInfo val editorAnnotation: String?,
    @ColumnInfo val endYear: Int?,
    @ColumnInfo val filmLength: Int,
    @ColumnInfo val genres: List<Genre>,
    @ColumnInfo val has3D: Boolean,
    @ColumnInfo val hasImax: Boolean,
    @ColumnInfo val imdbId: String?,
    @ColumnInfo val isTicketsAvailable: Boolean,
    @PrimaryKey @ColumnInfo("id") val kinopoiskId: Int,
    @ColumnInfo val lastSync: String,
    @ColumnInfo val logoUrl: String?,
    @ColumnInfo val nameEn: String?,
    @ColumnInfo val nameOriginal: String?,
    @ColumnInfo val nameRu: String,
    @ColumnInfo val posterUrl: String?,
    @ColumnInfo val posterUrlPreview: String?,
    @ColumnInfo val productionStatus: String?,
    @ColumnInfo val ratingAgeLimits: String?,
    @ColumnInfo val ratingAwait: Double?,
    @ColumnInfo val ratingAwaitCount: Int,
    @ColumnInfo val ratingFilmCritics: Double?,
    @ColumnInfo val ratingFilmCriticsVoteCount: Int?,
    @ColumnInfo val ratingGoodReview: Double?,
    @ColumnInfo val ratingGoodReviewVoteCount: Int,
    @ColumnInfo val ratingImdb: Double?,
    @ColumnInfo val ratingImdbVoteCount: Int,
    @ColumnInfo val ratingKinopoisk: Double?,
    @ColumnInfo val ratingKinopoiskVoteCount: Int,
    @ColumnInfo val ratingMpaa: String?,
    @ColumnInfo val ratingRfCritics: Double?,
    @ColumnInfo val ratingRfCriticsVoteCount: Int,
    @ColumnInfo val reviewsCount: Int,
    @ColumnInfo val serial: Boolean,
    @ColumnInfo val shortDescription: String?,
    @ColumnInfo val shortFilm: Boolean,
    @ColumnInfo val slogan: String?,
    @ColumnInfo val startYear: Int?,
    @ColumnInfo val type: String,
    @ColumnInfo val webUrl: String,
    @ColumnInfo val year: Int
) {
    fun toPreview(): FilmPreview = FilmPreview(
        this.countries,
        this.kinopoiskId,
        this.filmLength.toString(),
        this.genres,
        this.nameEn,
        this.nameRu,
        this.posterUrl,
        this.posterUrlPreview,
        this.ratingKinopoisk.toString(),
        "ratingChange",
        this.ratingKinopoiskVoteCount,
        this.year.toString(),
        )
}