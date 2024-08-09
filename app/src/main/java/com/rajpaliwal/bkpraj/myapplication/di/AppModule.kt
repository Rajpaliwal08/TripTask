package com.rajpaliwal.bkpraj.myapplication.di

import android.content.Context
import androidx.room.Room
import com.rajpaliwal.bkpraj.myapplication.data.local.TripDao
import com.rajpaliwal.bkpraj.myapplication.data.local.TripDatabase
import com.rajpaliwal.bkpraj.myapplication.repository.TripRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): TripDatabase =
        Room.databaseBuilder(context, TripDatabase::class.java, "trip_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideTripDao(appDatabase: TripDatabase): TripDao = appDatabase.tripDao()

    @Provides
    fun provideTripeRepository(tripDao: TripDao): TripRepository = TripRepository(tripDao)
}