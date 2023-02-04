package com.seytkalievm.tinkoffjunlab.data.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.seytkalievm.tinkoffjunlab.data.datasource.FilmsDao

@Database(entities = [FilmDetails::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class FavouriteFilmsDatabase : RoomDatabase(){
    abstract val dao: FilmsDao

    companion object {
        @Volatile
        private var INSTANCE: FavouriteFilmsDatabase? = null

        fun getInstance(context: Context): FavouriteFilmsDatabase {
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FavouriteFilmsDatabase::class.java, "favourite_films")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }

        }
    }
}