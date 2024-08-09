package com.rajpaliwal.bkpraj.myapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.rajpaliwal.bkpraj.myapplication.data.model.TripInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface TripDao {

    @Query("SELECT * FROM trip_info")
    fun getAllTrip(): Flow<List<TripInfo>>

    @Insert
    suspend fun saveTrip(tripInfo: TripInfo)

    @Query("DELETE FROM trip_info")
    fun removeAllTrip(): Int
}