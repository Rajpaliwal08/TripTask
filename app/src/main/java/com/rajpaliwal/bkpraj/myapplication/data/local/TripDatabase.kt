package com.rajpaliwal.bkpraj.myapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rajpaliwal.bkpraj.myapplication.data.model.TripInfo

@Database(entities = [TripInfo::class], version = 1)
abstract class TripDatabase : RoomDatabase() {
    abstract fun tripDao(): TripDao
}