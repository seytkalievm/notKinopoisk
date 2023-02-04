package com.seytkalievm.tinkoffjunlab.data.model

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converter {
    @TypeConverter
    fun countryListToJson(countries: List<Country>): String =  Gson().toJson(countries)

    @TypeConverter
    fun jsonToCountryList(countries: String): List<Country> =
        Gson().fromJson(countries, Array<Country>::class.java).toList()

    @TypeConverter
    fun genreListToJson(genres: List<Genre>): String = Gson().toJson(genres)

    @TypeConverter
    fun jsonToGenreList(genres: String): List<Genre> =
        Gson().fromJson(genres, Array<Genre>::class.java).toList()
}