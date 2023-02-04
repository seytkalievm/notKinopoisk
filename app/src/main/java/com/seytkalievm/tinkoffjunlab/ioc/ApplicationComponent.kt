package com.seytkalievm.tinkoffjunlab.ioc

import android.content.Context
import com.seytkalievm.tinkoffjunlab.data.datasource.FilmsDao
import com.seytkalievm.tinkoffjunlab.data.model.FavouriteFilmsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationComponent {
    @Singleton
    @Provides
    fun provideDb(@ApplicationContext context: Context): FavouriteFilmsDatabase {
        return FavouriteFilmsDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideDao(db: FavouriteFilmsDatabase): FilmsDao {
        return db.dao
    }
}